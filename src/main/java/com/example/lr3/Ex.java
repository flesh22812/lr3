package com.example.lr3;

public class Ex extends Exception{

    public static String CORRECT_DATA = "Некорректно переданные данные.";
    public static String NO_ELEMENT = "Нет следующего элемента.";
    public Ex(String message){
        super(message);
    }
}
