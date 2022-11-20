package com.example.lr3.threads;

public class CarWriteRunnableThread implements Runnable {

    private final CarSynchronizer carSync;

    public CarWriteRunnableThread(CarSynchronizer carSync){
        this.carSync = carSync;
    }

    @Override
    public void run() {
        try {
            carSync.write();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }
}
