package com.example.jakeoneim.fitec;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import app.akexorcist.bluetotohspp.library.BluetoothSPP;
import app.akexorcist.bluetotohspp.library.BluetoothState;
import app.akexorcist.bluetotohspp.library.DeviceList;

public class MainActivity extends AppCompatActivity {

    private BluetoothSPP bluetooth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bluetooth = new BluetoothSPP(MainActivity.this);

        if(!bluetooth.isBluetoothAvailable()){
            Toast.makeText(getApplicationContext() , "[Error] Bluetooth Connection" , Toast.LENGTH_LONG).show();
            finish();
        }

        bluetooth.setOnDataReceivedListener(new BluetoothSPP.OnDataReceivedListener() { // for receiving Data
            @Override
            public void onDataReceived(byte[] data, String message) {
                Toast.makeText(MainActivity.this, message,Toast.LENGTH_LONG).show();
            }
        });

        bluetooth.setBluetoothConnectionListener(new BluetoothSPP.BluetoothConnectionListener() {
            @Override
            public void onDeviceConnected(String name, String address) {
                Toast.makeText(getApplicationContext() , "[Connected] " + name +" , " + address,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onDeviceDisconnected() {
                Toast.makeText(getApplicationContext() , "[Disconnected]",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onDeviceConnectionFailed() {
                Toast.makeText(getApplicationContext() , "[Connection Fail]",Toast.LENGTH_LONG).show();
            }
        });

        Button connectBtn = findViewById(R.id.connectButton);

        connectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bluetooth.getServiceState() == BluetoothState.STATE_CONNECTED){
                    bluetooth.disconnect();
                }else{
                    startActivityForResult(new Intent(getApplicationContext() , DeviceList.class), BluetoothState.REQUEST_CONNECT_DEVICE);
                }
            }
        });
    }


    public void onDestroy() {
        super.onDestroy();
        bluetooth.stopService();
    }

    public void onStart(){
        super.onStart();

        if(!bluetooth.isBluetoothEnabled()){
            startActivityForResult(new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE) , BluetoothState.REQUEST_ENABLE_BT);
        }else{
            if(!bluetooth.isServiceAvailable()){
               setupService(); // make bluetooth available and set button onClick
            }
        }
    }
/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == Activity.RESULT_OK){
            if(requestCode == BluetoothState.REQUEST_CONNECT_DEVICE){
                bluetooth.connect(data);
            }else if(requestCode == BluetoothState.REQUEST_ENABLE_BT){
                setupService();
            }
        }else{
            Toast.makeText(getApplicationContext() , "" , Toast.LENGTH_LONG).show();
            finish();
        }
    }*/

    public void setupService(){
        bluetooth.setupService();
        bluetooth.startService(BluetoothState.DEVICE_OTHER); // Device which is not android

        findViewById(R.id.sendButton).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                bluetooth.send("wooRineun Fitec Da" , true);
            }
        });
    }
}
