package com.example.lr3.threads;



import com.example.lr3.Car;
import com.example.lr3.interfaces.ICar;

import java.util.Random;

public class CarWriteThread extends Thread{

    private final ICar car;

    public CarWriteThread(ICar car){
        this.car = car;
    }

    @Override
    public void run(){
        Random r = new Random();
        for(int i = 0;i < car.getSpeed().length;i++){
            double value = r.nextDouble() * 10;
            car.setSpeed(i,value);
            System.out.println("Write:" + value +" on position " + i );
        }
    }
}
