package com.example.lr3;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ForthLab {


    private static final String SERIALIZED_FILE_NAME = "serialized.bin";
    private static final String BYTE_FILE_NAME = "cars.bin";
    private static final String SYMBOLIC_FILE_NAME = "cars.txt";

    public static void launchIoUtilsOperations(List<Car> cars) {
        Scanner inputScanner = new Scanner(System.in);
        boolean continueIoOperations = true;

        while (continueIoOperations) {
            printIOUtilsinfo();
            String choice = inputScanner.nextLine();
            switch (choice) {
                case "1" -> {
                    try {
                        CarByteOperations.byteOutputCars(cars, BYTE_FILE_NAME);
                        System.out.println(" Информация записана в байтовом виде в файл " + BYTE_FILE_NAME);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                case "2" -> {
                    try {
                        List<Car> byteInputCars = CarByteOperations.byteInputCars(BYTE_FILE_NAME);
                        printCarsInfo(byteInputCars);
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                case "3" -> {
                    try {
                        CarSymbolOperations.writeCars(cars, SYMBOLIC_FILE_NAME);
                        System.out.println(" Информация записана в текстовом виде в файл " + SYMBOLIC_FILE_NAME);
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                case "4" -> {
                    try {
                        List<Car> symbolReadCars = CarSymbolOperations.readCars(SYMBOLIC_FILE_NAME);
                        printCarsInfo(symbolReadCars);
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                case "5" -> {
                    try {
                        CarSerializationOperations.serializeCars(cars, SERIALIZED_FILE_NAME);
                        System.out.println(" Информация записана в сериализованном виде в файл " + SERIALIZED_FILE_NAME);
                    } catch (IOException | ClassNotFoundException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                case "6" -> {
                    try {
                        List<Car> deserializedCars = CarSerializationOperations.deserializeCars(SERIALIZED_FILE_NAME);
                        printCarsInfo(deserializedCars);
                    } catch (IOException | ClassNotFoundException ex) {
                        System.out.println(ex.getMessage());
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

    private static void printIOUtilsinfo() {
        System.out.println("\n Меню функций ввода/вывода." +
                "\n 1 - Байтовый вывод в файл " + BYTE_FILE_NAME +
                "\n 2 - Байтовый ввод из файла " + BYTE_FILE_NAME +
                "\n 3 - Символьный вывод в файл " + SYMBOLIC_FILE_NAME +
                "\n 4 - Символьный ввод из файла " + SYMBOLIC_FILE_NAME +
                "\n 5 - Сериализация объекта в файл " + SERIALIZED_FILE_NAME +
                "\n 6 - Десериализация объекта из файла " + SERIALIZED_FILE_NAME +
                "\n 0 - Выход");
    }

    public static void printCarsInfo(List<Car> cars) {
        try {
            for (Car car : cars) {
                System.out.println(car.name + ", Цена: " + car.price);
            }
        } catch (Exception ex) {
            System.out.println("Ошибка получения машины");
        }
    }
}
