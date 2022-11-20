package com.example.lr3;

import com.example.lr3.interfaces.ICar;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarSerializationOperations {

    public static void serializeCars(List<ICar> cars, String fileName)
            throws IOException,ClassNotFoundException{
        try(FileOutputStream fos = new FileOutputStream(fileName)) {
            for (ICar car : cars) {
                CarIOUtils.serializeCar(car, fos);
            }
        }
    }

    public static List<ICar> deserializeCars(String fileName)
            throws  IOException,ClassNotFoundException {
        List<ICar> cars = new ArrayList<>();
        try(FileInputStream fis = new FileInputStream(fileName)) {
            while (fis.available() != 0) {
                ICar car = CarIOUtils.deserializeCar(fis);
                cars.add(car);
            }
        }
        catch(FileNotFoundException ex){
            throw new IOException(ex.getMessage());
        }
        return cars;
    }
}
