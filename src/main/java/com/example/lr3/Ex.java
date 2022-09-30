package com.example.lr3;

public class Ex extends Exception{
static String CORRECT_DATA = "Некорректно переданные данные.";
    public Ex(String message){
        super(message);
    }
}
