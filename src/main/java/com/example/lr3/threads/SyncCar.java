package com.example.lr3.threads;

import com.example.lr3.Car;
import com.example.lr3.interfaces.ICar;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;

public class SyncCar implements ICar {

    private final ICar car;

    public SyncCar(ICar car) {
        this.car = car;
    }

    @Override
    public synchronized String getName() {
        return car.getName();
    }

    @Override
    public synchronized void setName(String name) {
        car.setName(name);
    }


    @Override
    public synchronized double getPrice() {
        return car.getPrice();
    }

    @Override
    public synchronized void setSpeed(int i, double value) {
        car.setSpeed(i, value);
    }

    @Override
    public synchronized void setPrice(double speed) {
        car.setPrice(speed);
    }

    @Override
    public synchronized double[] getSpeed() {
        return car.getSpeed();
    }

    @Override
    public synchronized double getSpeed(int index) {
        return car.getSpeed(index);
    }


    @Override
    public synchronized void output(OutputStream out) throws IOException {
        car.output(out);
    }

    @Override
    public synchronized List<Car> difPrice(List<Car> cars) {
        return car.difPrice(cars);
    }

    @Override
    public synchronized void write(Writer out) throws IOException {
        car.write(out);
    }

    @Override
    public synchronized Iterator<Double> iterator() {
        return car.iterator();
    }
}
