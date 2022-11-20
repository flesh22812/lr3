package com.example.lr3.interfaces;

import com.example.lr3.Car;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.Writer;
import java.util.List;
import java.util.Iterator;
public interface ICar extends Iterable<Double>, Serializable {
    List<Car> difPrice(List<Car> cars);

    void write(Writer out) throws IOException;

    void output(OutputStream out) throws IOException;
    String getName();
    double getPrice();

    void setSpeed(int i, double value);
    void setPrice(double value);
    double[]  getSpeed();
    double getSpeed(int index);
    void setName(String value);
}
