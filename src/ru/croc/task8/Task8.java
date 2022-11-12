package ru.croc.task8;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * утилита, которая могла бы печатать ценники в читаемом виде.
 * 
 * (Напишите простую программу, которая предлагала бы пользователю ввести число
 * в консоль
 * и выводила его обратно в отформатированном виде.)
 */
public class Task8 {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        System.out.print("Enter a double: ");
        Double prize = Scanner.nextDouble();

        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.KOREA);

        System.out.println("Result: " + format.format(prize));

    }
}
