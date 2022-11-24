package ru.croc.task9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * hash 40682260CC011947FC2D0B1A927138C5
 * пароль состоял из 7 букв латинского алфавита, и что все они были строчными.
 * 
 * Напишите программу, которая методом полного перебора
 * напомнит вам пароль.
 * 
 * Причем за наиболее короткий срок - пароль вам нужен как можно быстрее.
 * Для ускорения процесса вы решили перебор выполнять в несколько потоков.
 * 
 * Количество потоков - входные данные для программы,
 * задается первым аргументом командной строки.
 * Хеш пароля - вторым аргументом.
 * Найденный пароль печатается в стандартный поток вывода.
 * 
 * 
 */
public class Task9 {

    public static void main(String[] args) throws InterruptedException {
        // d9d7dbddc29177b121a6aa1bb09d15fd (bab)
        // D9D7DBDDC29177B121A6AA1BB09D15FD

        // (abcdefg)
        // 7AC66C0F148DE9519B8BD264312C4D64
        // 7

        // aaaaaag
        // EB1CD3F4A42A865D119B378A7C004E30
        // 7

        // ffffffd
        // 9DA6B5CFAAEAB84A524DB43622E7036F
        // 7

        // fffd
        // 8E97F5134D1C78658F1E70A6D1BEBEDE
        // 4
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите hash: ");
        String hash = scanner.nextLine();

        System.out.print("Введите количество символов в пароле: ");
        int c = scanner.nextInt();

        System.out.print("Введите количество потоков: ");
        int n = scanner.nextInt();

        char a = 97; // 'a'
        for (int i = 0; i < n; i++) {
            String s = (Character.toString(a).repeat(c));
            new EnumerationRunnable(s, hash).start();

            // System.out.println(s);
            a = (char) (a + (26 / n));
        }

    }
}
