package com.example.lr3.interfaces;

import com.example.lr3.Car;
import com.example.lr3.Ex;

public interface ICarFactory {
    ICar createInstance();


    ICar createInstance(String name, double[] speed, double price);

}
