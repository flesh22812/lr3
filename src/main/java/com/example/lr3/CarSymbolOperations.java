package com.example.lr3;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CarSymbolOperations {

    public static void writeCars(List<Car> cars, String fileName) throws IOException {
        try (BufferedWriter br = new BufferedWriter(
                new FileWriter(fileName))) {
            for (Car car : cars) {
                CarIOUtils.writeCar(car, br);
            }
        }
    }

    public static List<Car> readCars(String fileName) throws IOException {
        List<Car> cars = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new FileReader(fileName))) {
            boolean notIsEndOfFile = true;
            while (notIsEndOfFile) {
                Car car;
                try {
                    car = CarIOUtils.readCar(br);
                    cars.add(car);
                } catch (Ex ex) {
                    notIsEndOfFile = false;

                }
            }
        } catch (FileNotFoundException ex) {
            throw new IOException(ex.getMessage());
        }
        return cars;
    }
}
