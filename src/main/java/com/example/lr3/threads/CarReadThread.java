package com.example.lr3.threads;

import com.example.lr3.Car;
import com.example.lr3.interfaces.ICar;

public class CarReadThread extends Thread {

    private final ICar car;

    public CarReadThread(ICar car){
        this.car = car;
    }

    @Override
    public void run(){
        double[] speed = car.getSpeed();
        for(int i = 0;i < speed.length;i++){
            System.out.println("Read:" + speed[i] +" from position " + i );
        }
    }
}
