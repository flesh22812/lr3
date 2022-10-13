package com.example.lr3;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.List;

public interface ICar {
    List<Car> difPrice(List<Car> cars);

    void write(Writer out) throws IOException;

    void output(OutputStream out) throws IOException;
    String getName();
    double getPrice();
}
