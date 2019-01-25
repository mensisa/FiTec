package com.example.jakeoneim.fitec;

import android.util.Log;

public class HeartRateCheck extends Thread{

    int standardHeartRateOfUser;

    private int makeTheStandardHeartRateOfUser(){
        return 0;
    }

    public boolean isProblem(int currentHertRate){
        return false;
    }

    public void run(){ //thread start
        while (true){
            Log.d("Debug" , "hearBeatThread");

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

}
