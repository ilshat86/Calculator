package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Digit digit = new Digit();
        Roman roman = new Roman();
        System.out.println("Введите пример. Значения и операторы разделять пробелом. Напрммер 1 + 1 или I + X");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] substr;
        substr = input.split(" ");
        if (substr.length==3){
            int result = 0;
            int int1 = 0;
            int int2 = 0;
            String strValue1 = substr[0];
            String operator = substr[1];
            String strValue2 = substr[2];
            Boolean isDigitvalue1 = digit.isNumeric(strValue1);
            Boolean isDigitvalue2 = digit.isNumeric(strValue2);
            if (isDigitvalue1==isDigitvalue2) {
                if (isDigitvalue1==true) {
                    int1 = Integer.parseInt(strValue1);
                    int2 = Integer.parseInt(strValue2);
                }
                else
                    {
                    int1 = Roman.romanToArabic(strValue1);
                    int2 = Roman.romanToArabic(strValue2);
                    }
                if (!(Digit.checkInput(int1) & Digit.checkInput(int2))) {
                    throw new IllegalArgumentException("Пример введен неверно, указаны значение не входящие в интервал от 1 до 10");
                }
                result = doCalculat(int1, int2, operator);
                if (isDigitvalue1) {
                    System.out.println(result);}
                else {
                    System.out.println(Roman.arabicToRoman(result));
                    }

            }
            else {
                throw new IllegalArgumentException("Пример введен неверно, должны быть только арабские или римские цифры!");
            }
        }
        else {
            System.out.println("Пример введен неверно!");
        }
    }

    private static int doCalculat(int a, int b, String operator) {
        int result =0;
        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "/":
                result = a / b;
                break;
            case "*":
                result = a * b;
                break;
            default:
                throw new InputMismatchException("Указан неправильные арифметический оператор");
        }

        return result;
    }

}
