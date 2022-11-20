package com.example.lr3;

import com.example.lr3.interfaces.ICar;
import com.example.lr3.lab.ForthLab;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.example.lr3.lab.FifthLab.launchThreadOperations;
import static com.example.lr3.lab.SixthLab.launchPatternOperations;


@SpringBootApplication
public class Lr3Application {

    public static void main(String[] args) throws Ex {
        //      SpringApplication.run(Lr3Application.class, args);
        Car lada = new Car();
        Car bmw = new Car("bmw", 1500000.0, new double[]{200.0, 230.0});
        System.out.println(lada);
        System.out.println(bmw);
        System.out.println("Проверка equals 1 и 2 машин: " + bmw.equals(lada));
        System.out.println("Проверка equals 1 и 1 машин: " + lada.equals(lada));

        System.out.println("hashcode 1 машины: " + lada.hashCode());
        System.out.println("hashcode 2 машины: " + bmw.hashCode());
        List<ICar> cars = new ArrayList<>();
        ICar tr = new Truck();
        cars.add(tr);
        cars.add(tr);
        cars.add(tr);
        cars.add(lada);

        cars.add(bmw);

        Scanner in = new Scanner(System.in);
        int num = 0;
        while (num != 9) {
            System.out.println("""
                    Введите пункт меню:
                    1.Добавить машину
                    2.Вывести список машин
                    3.Сломать программу
                    4.4 ЛР
                    8.Сломать программу2
                    5.5 ЛР
                    6.6 ЛР
                    9.Завершение работы""");
            num = in.nextInt();
            switch (num) {
                case 1 -> {

                    cars.add(new Car(cars.size()));


                }
                case 2 -> {
                    List<Car> carsType = new ArrayList<>();
                    for (ICar iCar : cars) {

                        if (iCar.getClass().equals(Car.class)) {//!iCar.getName().contains("Truck")) {
                            carsType.add((Car) iCar);
                        }
                    }

                    int j = 0;
                    for (int i = 1; i < carsType.size(); i++) {


                        if (!carsType.get(i).difPrice(carsType).equals(carsType.get(i - 1).difPrice(carsType))) {
                            j++;
                            System.out.println("Массив " + j + ": " + carsType.get(i).difPrice(carsType));
                        }
                    }
                    System.out.println();
                    System.out.println();
                    System.out.println();

                    for (ICar car : cars) {
                        System.out.println(car);
                    }

                }


                case 3 -> {

                    double price;
                    price = 10.0;
                    if (price < 100.0) throw new Ex("Цена не может быть меньше 100.");
                    else {
                        price = 10000000.0;
                        Car broken = new Car("broken", price, new double[]{200.0, 230.0});
                        System.out.println(broken);
                    }
                }
                case 4 -> {
                    ForthLab.launchIoUtilsOperations(cars);
                }
                case 8 -> {
                    try {
                        System.out.println(cars.get(5));
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(e.getMessage() + "  Нет машины с индексом 5");
                    }

                }
                case 5 -> {
                    launchThreadOperations();
                }
                case 6 -> {
                    launchPatternOperations();
                }
            }

        }
    }
}


