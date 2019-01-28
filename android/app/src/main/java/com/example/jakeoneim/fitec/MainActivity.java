package com.example.jakeoneim.fitec;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FallDownCheck fTest;
    HeartRateCheck hTest;
    boolean isConnected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fTest = new FallDownCheck(); // fallDown Object create
        hTest = new HeartRateCheck();// heartBeat Object create
        isConnected = false;

        findViewById(R.id.connectButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isConnected){
                    if(makeConnectionWithSensor()){
                        Toast.makeText(getApplicationContext(),"start FitBit",Toast.LENGTH_LONG);
                    }else{
                        Toast.makeText(getApplicationContext(),"connection problem",Toast.LENGTH_LONG);
                    }
                }else{
                    isConnected = false;
                    Toast.makeText(getApplicationContext(),"stop FitBit",Toast.LENGTH_LONG);
                }
            }
        });

    }

    public boolean makeConnectionWithSensor(){
        //isConnected should be changed here
        isConnected = true;
        receiveDataFromSensor();
        return false;
    }

    public void receiveDataFromSensor(){
        while (isConnected){
            //receiveData here
            if(hTest.isProblem(0)){
                hTest.start();
            }

            if(fTest.isFallenDown(1,1,1,1,1,1)){
                fTest.start();
            }

        }


    }



}
