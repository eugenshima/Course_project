package com.example.salaryclient.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checking {
    public static boolean checkInt(String str) {
        int i = 0;
        if(!Character.isDigit(str.charAt(i))) { // возвращает истинну если с потока ввода можно считать целое число
            return false; // считывает целое число с потока ввода и сохраняем в переменную
        } else {
            return false;
        }
    }
    public static boolean CheckLenght(String str) {
        int len = str.length();
        if(len != 9) {
            return false;
        } else { return true; }
    }
}
