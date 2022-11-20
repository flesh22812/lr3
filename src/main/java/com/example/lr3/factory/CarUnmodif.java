package com.example.lr3.factory;

import com.example.lr3.Car;
import com.example.lr3.Ex;
import com.example.lr3.interfaces.ICar;
import com.example.lr3.threads.CarIterator;
import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.util.*;
import java.util.random.RandomGenerator;

@Setter
@Getter

public class CarUnmodif implements ICar {
    ICar car;
    public CarUnmodif(ICar car){
        this.car = car;
    }

    @Override
    public String toString() {
        return "Car(name= " + this.car.getName() + ", price=" + this.car.getPrice() + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != CarUnmodif.class) return false;
        CarUnmodif that = (CarUnmodif) obj;
        return Double.compare(that.getPrice(), car.getPrice()) == 0
                && Arrays.equals(car.getSpeed(), that.getSpeed())
                && car.getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(car.getPrice(), car.getName());
        result = 10 * result + Arrays.hashCode(car.getSpeed());
        return result;
    }

    @Override
    public void setSpeed(int i, double value) {
        throw new UnsupportedOperationException(
                " Попытка задать cкорость  = " + value
        );
    }

    @Override
    public void setPrice(double value) {
        throw new UnsupportedOperationException(
                " Попытка задать цену  = " + value
        );
    }

    @Override
    public double[] getSpeed() {
        return new double[0];
    }

    public double getSpeed(int i) {
        if (checkArray(i)) return car.getSpeed(i);
        return 0;
    }

    @Override
    public void setName(String value) {

        throw new UnsupportedOperationException(
                 " Попытка задать  имя = " + value
        );

    }

    @Override
    public List<Car> difPrice(List<Car> cars) {
        return null;
    }

    public void write(Writer out) {

    }

    private boolean checkArray(int index) {
    return  true;
    }

    public void output(OutputStream out) throws IOException {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public Iterator<Double> iterator() {
        return new CarIterator(car.getSpeed());
    }


}

