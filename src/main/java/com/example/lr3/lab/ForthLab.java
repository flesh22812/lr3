package com.example.lr3.lab;

import com.example.lr3.CarByteOperations;
import com.example.lr3.CarSerializationOperations;
import com.example.lr3.CarSymbolOperations;
import com.example.lr3.interfaces.ICar;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ForthLab {


    private static final String SERIALIZED_FILE_NAME = "serialized.bin";
    private static final String BYTE_FILE_NAME = "cars.bin";
    private static final String SYMBOLIC_FILE_NAME = "cars.txt";

    public static void launchIoUtilsOperations(List<ICar> cars) {
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
                        List<ICar> byteInputCars = CarByteOperations.byteInputCars(BYTE_FILE_NAME);
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
                        List<ICar> symbolReadCars = CarSymbolOperations.readCars(SYMBOLIC_FILE_NAME);
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
                        List<ICar> deserializedCars = CarSerializationOperations.deserializeCars(SERIALIZED_FILE_NAME);
                        printCarsInfo(deserializedCars);
                    } catch (IOException | ClassNotFoundException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                case "7" -> {
                    try {
                        List<ICar> byteInputCars = CarByteOperations.byteInputCars(BYTE_FILE_NAME);
                        printCarsInfo(byteInputCars);
                    } catch (IOException ex) {
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

    public static void printCarsInfo(List<ICar> cars) {
        try {
            for (ICar car : cars) {
                System.out.println(car.getName() + ", Цена: " + car.getPrice());
            }
        } catch (Exception ex) {
            System.out.println("Ошибка получения машины");
        }
    }
}
