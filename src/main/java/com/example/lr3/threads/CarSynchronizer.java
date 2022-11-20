package com.example.lr3.threads;

import com.example.lr3.Car;
import com.example.lr3.interfaces.ICar;

import java.util.Random;

public class CarSynchronizer {

    private final ICar car;
    private volatile int current = 0;
    private boolean set = false;

    public CarSynchronizer(ICar car) {
        this.car = car;
    }

    public double read() throws InterruptedException {
        double val = Double.NEGATIVE_INFINITY;
        while (canRead()) {
            synchronized (car) {
                while (canRead() && !set) {
                    car.wait();
                }
                if (canRead()) {
                    val = car.getSpeed(current);
                    System.out.println("Read: " + val + " from position " + current);
                    set = false;
                    current++;
                }
                car.notifyAll();
            }
        }
        System.out.println("End read");
        return val;
    }

    public void write() throws InterruptedException {
        while (canWrite()) {
            synchronized (car) {
                Random r = new Random();
                while (canWrite() && set) {
                    car.wait();
                }
                if (canWrite()) {
                    double val = r.nextDouble() * 10;
                    car.setSpeed(current, val);
                    System.out.println("Write: " + val + " on position " + current);
                    set = true;
                }
                car.notifyAll();
            }
        }
        System.out.println("End write");
    }

    public boolean canRead() {
        return current < car.getSpeed().length;
    }

    public boolean canWrite() {
        return current < car.getSpeed().length;
    }
}
