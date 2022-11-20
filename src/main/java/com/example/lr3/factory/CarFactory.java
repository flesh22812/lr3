package com.example.lr3.factory;

import com.example.lr3.Car;
import com.example.lr3.interfaces.ICar;
import com.example.lr3.interfaces.ICarFactory;


public class CarFactory implements ICarFactory {
    @Override
    public ICar createInstance() {
        return new Car();
    }



    @Override
    public ICar createInstance(String name, double[] speed, double price)
    {
        return new Car(name,price,speed);
    }
}
