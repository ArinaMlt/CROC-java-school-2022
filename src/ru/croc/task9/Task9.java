package ru.croc.task9;
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

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите входные данные для программы: ");
        String password = scanner.nextLine();
        System.out.println("");
        System.out.print("Введите хэш: ");
        String hash = scanner.nextLine();

        EnumerationRunnable er1 = new EnumerationRunnable(password, hash);
        Thread t1 = new Thread(er1);
        Thread t2 = new Thread(new EnumerationRunnable("ccccccc", hash));
        Thread t3 = new Thread(new EnumerationRunnable("fffffff", hash));

        Thread t4 = new Thread(new EnumerationRunnable("jjjjjjj", hash));
        Thread t5 = new Thread(new EnumerationRunnable("mmmmmmm", hash));
        Thread t6 = new Thread(new EnumerationRunnable("sssssss", hash));
        Thread t7 = new Thread(new EnumerationRunnable("wwwwwww", hash));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();

    }
}
