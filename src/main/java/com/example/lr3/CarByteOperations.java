package com.example.lr3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarByteOperations {
 

        public static void byteOutputCars(List<ICar> cars, String fileName) throws IOException {
            try(FileOutputStream fos = new FileOutputStream(fileName)){
                for( ICar car: cars){
                    CarIOUtils.outputCar(car,fos);
                }
            }
        }

        public static List<ICar> byteInputCars(String fileName)
                throws IOException{
            List<ICar> cars = new ArrayList<>();
            try(FileInputStream fis = new FileInputStream(fileName)){
                while(fis.available() != 0){
                    ICar car = CarIOUtils.inputCar(fis);
                    cars.add(car);
                }
            }
            catch(FileNotFoundException ex){
                throw new IOException(ex.getMessage());
            }
            return cars;
        }

    }
