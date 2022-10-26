package ru.croc.task3;

/**
 * Программа вычисляет площадь треугольника по координатам его вершин
 */

//вспомогательный класс для задания координат вершин
public class Task3 {
    static class Point {
        double x;
        double y;
    }

    public static void main(String[] args) {
        Point a = new Point();
        a.x = -5.0;
        a.y = -15.0;

        Point b = new Point();
        b.x = -20.0;
        b.y = -8.0;

        Point c = new Point();
        c.x = -110.0;
        c.y = -213.0;

        triangleArea(a, b, c);
    }

    static void triangleArea(Point a, Point b, Point c) {
        double ab, bc, ac;
        ab = Math.sqrt((b.x - a.x) * (b.x - a.x) + (b.y - a.y) * (b.y - a.y));
        bc = Math.sqrt((c.x - b.x) * (c.x - b.x) + (c.y - b.y) * (c.y - b.y));
        ac = Math.sqrt((c.x - a.x) * (c.x - a.x) + (c.y - a.y) * (c.y - a.y));

        double pp = (ab + bc + ac) / 2;
        double sqr = Math.sqrt(pp * (pp - ab) * (pp - bc) * (pp - ac));
        System.out.printf("%.1f", sqr);

    }
}
