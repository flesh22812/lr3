package com.example.lr3.threads;

import com.example.lr3.Ex;
import lombok.SneakyThrows;

import java.util.Iterator;

public class CarIterator implements Iterator<Double> {

    private int current = 0;
    private final double[] speed;

    public CarIterator(double[] speed){
        this.speed = speed;
    }

    @Override
    public boolean hasNext() {
        return current < speed.length;
    }

    @SneakyThrows
    @Override
    public Double next() {
        if(!hasNext())
            throw new Ex(Ex.NO_ELEMENT);

        double element = speed[current];
        current++;
        return element;
    }
}
