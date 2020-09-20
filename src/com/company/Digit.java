package com.company;

import java.text.NumberFormat;
import java.text.ParsePosition;

public class Digit {
    public static boolean isNumeric(String str)
    {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
    }
    public static boolean checkInput(int a)
    {
        return a > 0 & a <= 10;
    }
}
