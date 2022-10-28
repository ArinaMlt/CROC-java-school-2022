package ru.croc.task3;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Программа вычисляет площадь треугольника по координатам его вершин
 */


public class Task3 {

    //вспомогательный класс для задания координат вершин
    static class Point {
        double x;
        double y;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Point a = new Point();
//        System.out.print("Input point A.x: ");
        a.x = scanner.nextDouble();
//        System.out.print("Input point A.y: ");
        a.y = scanner.nextDouble();

        Point b = new Point();
//        System.out.print("Input point B.x: ");
        b.x = scanner.nextDouble();
//        System.out.print("Input point B.y: ");
        b.y = scanner.nextDouble();

        Point c = new Point();
//        System.out.print("Input point C.x: ");
        c.x = scanner.nextDouble();
//        System.out.print("Input point C.y: ");
        c.y = scanner.nextDouble();


        triangleArea(a, b, c);
    }

    static void triangleArea(Point a, Point b, Point c) {
        double ab, bc, ac;
        ab = Math.sqrt((b.x - a.x) * (b.x - a.x) + (b.y - a.y) * (b.y - a.y));
        bc = Math.sqrt((c.x - b.x) * (c.x - b.x) + (c.y - b.y) * (c.y - b.y));
        ac = Math.sqrt((c.x - a.x) * (c.x - a.x) + (c.y - a.y) * (c.y - a.y));

        double pp = (ab + bc + ac) / 2;
        double sqr = Math.sqrt(pp * (pp - ab) * (pp - bc) * (pp - ac));
        DecimalFormat df = new DecimalFormat("#.#");
        String result = df.format(sqr);
        System.out.print("Площадь треугольника: " + result);

    }
}
