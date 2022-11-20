package com.example.lr3;

import com.example.lr3.interfaces.ICar;
import com.example.lr3.threads.CarIterator;
import lombok.*;

import java.io.*;
import java.util.*;
import java.util.random.RandomGenerator;

@Setter
@Getter

public class Car implements ICar, Serializable {
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
        price = 700000.0;
        speed = new double[]{120.0, 150.0, 170.0, 190.0, 200.0 ,210.0};
    }

    public Car(int number) {
        name = "Car" + number;
        price = RandomGenerator.of("L64X256MixRandom").nextInt(700000, 700001);
        speed = new double[]{120.0, 150.0};
    }


    public List<Car> difPrice(List<Car> cars) {

        List<Car> list = new ArrayList<>();
        for (Car car : cars) {
            {
                if (Math.abs(car.price - price) == 0) {
                    list.add(car);
                }

            }
        }

        return list;
        //  return Math.abs(car.getPrice() - price);
    }

    @Override
    public String toString() {
        return "Car(name= " + this.name + ", price=" + this.price + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != Car.class) return false;
        Car that = (Car) obj;
        return Double.compare(that.price, price) == 0
                && Arrays.equals(speed, that.speed)
                && name.equals(that.getName());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(price, name);
        result = 10 * result + Arrays.hashCode(speed);
        return result;
    }

    @Override
    public void setSpeed(int i, double value) {
       speed[i] = value;
    }
    public double getSpeed(int i) {
        if(checkArray(i)) return speed[i];
        return 0;
    }
    public void write(Writer out) {
        PrintWriter writer = new PrintWriter(out);
        writer.printf("%s ", name);
        writer.printf("%f ", price);
        writer.printf("%d ", speed.length);
        for (double speeds : speed) {
            writer.printf("%f ", speeds);
        }
        writer.println();
    }

    private boolean checkArray(int index) {
        return index >= 0 && index < speed.length;
    }

    public void output(OutputStream out) throws IOException {
        DataOutputStream dos = new DataOutputStream(out);
        dos.writeInt(name.length());
        dos.writeChars(name);
        dos.writeDouble(price);
        dos.writeInt(speed.length);
        for (double speeds : speed) {
            dos.writeDouble(speeds);
        }
    }

    @Override
    public Iterator<Double> iterator() {
        return new CarIterator(speed);
    }



}

