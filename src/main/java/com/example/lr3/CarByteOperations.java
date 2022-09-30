package com.example.lr3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarByteOperations {
 

        public static void byteOutputCars(List<Car> cars, String fileName) throws IOException {
            try(FileOutputStream fos = new FileOutputStream(fileName)){
                for( Car car: cars){
                    CarIOUtils.outputCar(car,fos);
                }
            }
        }

        public static List<Car> byteInputCars(String fileName)
                throws IOException{
            List<Car> cars = new ArrayList<>();
            try(FileInputStream fis = new FileInputStream(fileName)){
                while(fis.available() != 0){
                    Car car = CarIOUtils.inputCar(fis);
                    cars.add(car);
                }
            }
            catch(FileNotFoundException ex){
                throw new IOException(ex.getMessage());
            }
            return cars;
        }

    }
