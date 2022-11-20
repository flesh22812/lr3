package com.example.lr3;

import com.example.lr3.interfaces.ICar;
import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.util.*;
import java.util.random.RandomGenerator;


@Setter
@Getter

public class Truck implements ICar, Serializable {
    String name;
    double price;
    double[] speed;

    public Truck(String name, double price, double[] speed) {
        this.name = name;
        this.price = price;
        this.speed = speed;

    }

    public Truck() {
        name = "Truck1";
        price = 800000.0;
        speed = new double[]{50.0, 100.0};
    }

    public Truck(int number) {
        name = "Truck" + number;
        price = RandomGenerator.of("L64X256MixRandom").nextInt(600000, 700001);
        speed = new double[]{40.0, 80.0};
    }


    @Override
    public String toString() {
        return "Truck(name= " + this.name + ", price=" + this.price + ")";
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

    private boolean checkArray(int index) {
        return index >= 0 && index < speed.length;
    }

    @Override
    public List<Car> difPrice(List<Car> cars) {
        return null;
    }

    @Override
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

    @Override
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
    public void setSpeed(int i, double value) {
        if (checkArray(i)) speed[i] = value;
    }

    @Override
    public double getSpeed(int index) {
        return speed[index];
    }

    @Override
    public Iterator<Double> iterator() {
        return null;
    }
}