package com.example.lr3.lab;

import com.example.lr3.Car;
import com.example.lr3.factory.CarFactory;
import com.example.lr3.factory.CarUnmodif;
import com.example.lr3.factory.TruckFactory;
import com.example.lr3.interfaces.ICar;
import com.example.lr3.interfaces.ICarFactory;

import java.util.Iterator;
import java.util.Scanner;

public class SixthLab {
    private static void printPatternOperationsInfo(){
        System.out.println("\n Меню функций ввода/вывода." +
                "\n 1 - Iterator" +
                "\n 2 - Decorator" +
                "\n 3 - Factory" +
                "\n 0 - Exit");
    }

    public static void launchPatternOperations()  {
        Scanner inputScanner = new Scanner(System.in);
        boolean continueIoOperations = true;

        ICarFactory carFactory = new CarFactory();
        ICarFactory truckFactory = new TruckFactory();

        ICarFactory CarFactory = carFactory;

        ICar car = CarFactory.createInstance();
        System.out.println();
        System.out.println(car);

        while(continueIoOperations){
            printPatternOperationsInfo();
            String choice = inputScanner.nextLine();
            switch (choice) {
                case "1" -> {
                    System.out.println(car);
                    launchCarIterator(car);
                }
                case "2" -> {
                    System.out.println(car);
                    launchCarDecorator(car);
                }
                case "3" -> {
                    CarFactory = truckFactory;
                    car = CarFactory.createInstance("truck", new double[]{100.0, 113.0, 115.0, 130.0, 140.0, 150.0}, 100000);
                    System.out.println(car);
                    CarFactory = carFactory;
                    car = CarFactory.createInstance("car", new double[]{130.0, 154.0, 132.0, 135.0, 160.0, 170.0}, 300000);
                    System.out.println(car);
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

    public static void launchCarIterator(ICar car){
        Iterator<Double> carIterator = car.iterator();
        System.out.println("for cycle");
        for(double speed : car){
            System.out.println(speed);
        }
        System.out.println("\nwhile cycle");
        while(carIterator.hasNext()){
            System.out.println(carIterator.next());
        }
    }

    public static void launchCarDecorator(ICar car){
        ICar immutableCar = new CarUnmodif(car);
        try{
            System.out.println("Попытка задать цену");
            immutableCar.setPrice(20000.0);
        }
        catch(UnsupportedOperationException ex){
            System.out.println(ex.getMessage());
        }

        try{
            System.out.println("Попытка задать имя");
            immutableCar.setName("Immutable");
        }
        catch(UnsupportedOperationException ex){
            System.out.println(ex.getMessage());
        }

        try{
            System.out.println("Попытка задать скорость");
            immutableCar.setSpeed(0,54);
        }
        catch(UnsupportedOperationException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("Итоговая машина " +car);
    }
}

