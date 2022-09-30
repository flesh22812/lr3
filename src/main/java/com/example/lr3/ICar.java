package com.example.lr3;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

public interface ICar {
    Double DifPrice(Car car2);

    void write(Writer out) throws IOException;

    void output(OutputStream out) throws IOException;
}
