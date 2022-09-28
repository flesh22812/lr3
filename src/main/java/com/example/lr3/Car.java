package com.example.lr3;

import lombok.*;

import java.util.Arrays;
import java.util.Objects;
import java.util.random.RandomGenerator;

@Setter
@Getter
@Data


@EqualsAndHashCode
public class Car implements ICar {
    String name;
    double price;
    double[] speed;

    public Car(String name, double price, double[] speed) {
        this.name = name;
        this.price = price;
        this.speed = speed;

    }

    public Car() {
        name = "Lada";
        price = 700000;
        speed = new double[]{120.0, 150.0};
    }
    public Car(int number) {
        name = "Car "+number;
        price = RandomGenerator.getDefault().nextDouble(500000,2000000);
        speed = new double[]{120.0, 150.0};
    }



    public Double DifPrice(Car car1) {

        return Math.abs(car1.getPrice() - price);
    }
    @Override
    public String toString()  {
        return "Car(name= " + this.name + ", price=" + this.price + ")";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null ||  obj.getClass() != Car.class ) return false;
        Car that = (Car) obj;
        return Double.compare(that.price, price) == 0
                && Arrays.equals(speed, that.speed)
                && name.equals(that.getName());
    }
    @Override
    public int hashCode() {
        int result = Objects.hash(price,name);
        result = 10 * result + Arrays.hashCode(speed);
        return result;
    }

}

