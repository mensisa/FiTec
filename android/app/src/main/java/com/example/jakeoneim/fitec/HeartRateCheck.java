package com.example.jakeoneim.fitec;

public class HeartRateCheck extends Thread{

    boolean isProbremOccured;

    public HeartRateCheck(){
        this.isProbremOccured = false;
    }

    int standardHeartRateOfUser;

    private int makeTheStandardHeartRateOfUser(){
        return 0;
    }

    public boolean isProblem(int currentHertRate){
        if(isProbremOccured) return true;
        return false;
    }

    public void run(){ //thread start
        problemOccured();
    }

    public void problemOccured(){
        isProbremOccured = true;
        isProbremOccured = false;

    }

}
