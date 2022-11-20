package com.example.lr3.threads;

public class CarReadRunnableThread implements Runnable {

    private final CarSynchronizer carSync;

    public CarReadRunnableThread(CarSynchronizer carSync){
        this.carSync = carSync;
    }

    @Override
    public void run() {
        try {
            carSync.read();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }
}
