package com.example.lr3.factory;

import com.example.lr3.Truck;
import com.example.lr3.interfaces.ICar;
import com.example.lr3.interfaces.ICarFactory;


public class TruckFactory implements ICarFactory {
    @Override
    public ICar createInstance() {
        return new Truck();
    }

    @Override
    public ICar createInstance(String name, double[] price, double speed)
    {
        return new Truck(name,speed,price);
    }
}
