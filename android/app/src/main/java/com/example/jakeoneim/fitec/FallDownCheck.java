package com.example.jakeoneim.fitec;

import android.util.Log;

public class FallDownCheck extends Thread{

    public boolean isFallenDown(int gyroX, int gyroY , int gyroZ , int accelX , int accelY , int accelZ){
        return true;
    }

    public void run(){ //thread start
        while (true){
            Log.d("Debug" , "fallDownThread");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
