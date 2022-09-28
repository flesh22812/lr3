package com.example.lr3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;


@SpringBootApplication
public class Lr3Application {

    public static void main(String[] args) throws Ex {
        //      SpringApplication.run(Lr3Application.class, args);
        Car lada = new Car();
        Car bmw = new Car("bmw", 1500000, new double[]{200.0, 230.0});
        System.out.println(lada);
        System.out.println(bmw);
        System.out.println("Проверка equals 1 и 2 машин: " + bmw.equals(lada));
        System.out.println("Проверка equals 1 и 1 машин: " + lada.equals(lada));
        System.out.println("Разность цен: " + bmw.DifPrice(lada));
        System.out.println("hashcode 1 машины: " + lada.hashCode());
        System.out.println("hashcode 2 машины: " + bmw.hashCode());
        Car[] cars = new Car[6];
        int i = 0;
        cars[i] = lada;
        i++;
        cars[i] = bmw;
        i++;
        Scanner in = new Scanner(System.in);
        int num = 0;
        while (num != 9) {
            System.out.println("""
                    Введите пункт меню:
                    1.Добавить машину
                    2.Вывести список машин
                    3.Сломать программу
                    9.Завершение работы""");
            num = in.nextInt();
            switch (num) {
                case 1 -> {
                    cars[i] = new Car(i);
                    i++;

                }
                case 2 -> {

                    for (Car car : cars) {
                        try {
                            System.out.println(car);
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println(e.getMessage() + "Номер машины вне массива");
                        } catch (NullPointerException e) {
                            System.out.println(e.getMessage() + "Номер машины за пределами массива");
                        }

                    }

                }
                case 3 -> {

                    int price;
                    price = 10;
                    if (price < 100) throw new Ex("Цена не может быть меньше 100.");
                    else {
                        price = 10000000;
                        Car broken = new Car("broken", price, new double[]{200.0, 230.0});
                        System.out.println(broken);
                    }
                }

            }


        }
    }
}


