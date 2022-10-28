package ru.croc.task2;

import java.util.Scanner;

/**
 *
 * Програма считет сумму арифметической прогрессии
 */
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //начальный аргумент
        int a = scanner.nextInt();

        //разность арифметической прогрессии
        int b = scanner.nextInt();

        //кол-во членов погрессии
        int c = scanner.nextInt();

        progression(a,b,c);

    }

    static void progression(int a, int b, int c){
        //сумма арифметической прогрессии
        int sum = 0;

        for(int i = 0; i < c; i++){
            sum = sum + a;
            a = a + b;
        }
        System.out.println("Sum: " + sum);
    }
}
