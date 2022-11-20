package com.example.lr3.lab;

import com.example.lr3.Car;
import com.example.lr3.interfaces.ICar;
import com.example.lr3.threads.*;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static com.example.lr3.CarIOUtils.synchronizedCar;

public class FifthLab {
    public static void printThreadOperationsInfo(){
        System.out.println("\n Меню функций ввода/вывода." +
                "\n 1 - Thread async read-write" +
                "\n 2 - Thread sync read-write" +
                "\n 3 - Synchronized Car" +
                "\n 0 - Exit");
    }

    public static void launchThreadOperations(){
        Scanner inputScanner = new Scanner(System.in);
        boolean continueIoOperations = true;

        while(continueIoOperations){
            printThreadOperationsInfo();
            String choice = inputScanner.nextLine();
            switch (choice) {
                case "1" -> {
                    try {
                        launchAsyncThreads();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                case "2" -> {
                    try {
                        launchSyncThreads();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                case "3" -> {
                    try {
                        launchSynchronizer();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                case "0" -> {
                    continueIoOperations = false;
                }
                default -> {
                    System.out.println("Нераспознанная команда,попробуйте заново . . .");
                }
            }
        }
    }

    static void launchAsyncThreads() throws InterruptedException {
        ICar car = new Car();

        CarWriteThread carWriter = new CarWriteThread(car);
        carWriter.setPriority(Thread.MAX_PRIORITY);
        carWriter.start();

        CarReadThread carReader = new CarReadThread(car);
        carReader.setPriority(Thread.MIN_PRIORITY);
        carReader.start();

        carReader.join();
        carWriter.join();
    }

    static void launchSyncThreads() throws InterruptedException {
        ICar car = new Car();
        CarSynchronizer carSync = new CarSynchronizer(car);

        CarWriteRunnableThread writer = new CarWriteRunnableThread(carSync);
        CarReadRunnableThread reader = new CarReadRunnableThread(carSync);

        Thread carWriter = new Thread (writer);
        Thread carReader = new Thread(reader);

        carWriter.start();
        carReader.start();

        carReader.join();
        carWriter.join();
    }

    static void launchSynchronizer() throws InterruptedException{

        ICar car = new Car();
        ICar syncCar = synchronizedCar(car);
        System.out.println("DEFAULT Speed value: " + Arrays.toString(car.getSpeed()));
        Thread writerThread = new Thread( () -> {
            Random r = new Random();
            int length = syncCar.getSpeed().length;
            for(int i = 0 ; i < length/2 ; i++){
                double elem = r.nextDouble() * 10;
                syncCar.setSpeed(i, elem);
                System.out.println("Write 1: " + elem + " on " + i);
            }

                System.out.println("Speed value: " + Arrays.toString(syncCar.getSpeed()));

        });

        Thread writerThread2 = new Thread( () -> {
            Random r = new Random();
            int length = syncCar.getSpeed().length;
            for(int i = length/2 ; i < length ; i++){
                double elem = r.nextDouble() * 10;
                syncCar.setSpeed(i, elem);
                System.out.println("Write 2 : " + elem + " on " + i);
            }
            System.out.println("Speed value: " + Arrays.toString(syncCar.getSpeed()));
        });

        writerThread.start();
        writerThread2.start();

        Thread readerThread = new Thread (() -> {
            for(int i = 0 ; i < syncCar.getSpeed().length; i++){
                double elem = syncCar.getSpeed(i);
                System.out.println("Read: " + elem + " from " + i);
            }
            System.out.println("Speed value: " + Arrays.toString(syncCar.getSpeed()));
        });


        readerThread.start();

        writerThread.join();
        writerThread2.join();
        readerThread.join();
    }
}
