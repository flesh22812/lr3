package com.example.lr3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarSerializationOperations {

    public static void serializeCars(List<Car> cars, String fileName)
            throws IOException,ClassNotFoundException{
        try(FileOutputStream fos = new FileOutputStream(fileName)) {
            for (Car car : cars) {
                CarIOUtils.serializeCar(car, fos);
            }
        }
    }

    public static List<Car> deserializeCars(String fileName)
            throws  IOException,ClassNotFoundException {
        List<Car> cars = new ArrayList<>();
        try(FileInputStream fis = new FileInputStream(fileName)) {
            while (fis.available() != 0) {
                Car car = CarIOUtils.deserializeCar(fis);
                cars.add(car);
            }
        }
        catch(FileNotFoundException ex){
            throw new IOException(ex.getMessage());
        }
        return cars;
    }
}
