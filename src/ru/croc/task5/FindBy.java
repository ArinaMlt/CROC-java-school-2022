package ru.croc.task5;

import ru.croc.task4.Annotation;
import ru.croc.task4.Circle;
import ru.croc.task4.Figure;
import ru.croc.task4.Rectangle;

public final class FindBy {
    private FindBy() {
    }

    /**
     * 1) выбор аннотации по координатам точки (x, y);
     * В массиве аннотаций требуется найти первую,
     * фигура которой содержит точку с заданными координатами.
     * 
     * @return аннотация с заданными координатами / null - если нет в массиве.
     */

    public static Annotation point(int x, int y, Annotation... annotations) {
        for (int i = 0; i < annotations.length; i++) {
            Figure figure = annotations[i].getFigure();
            int[] coordinates = figure.getCoordinates();
            if (figure instanceof Circle) {
                int x1 = coordinates[0];
                int y1 = coordinates[1];
                int r = coordinates[2];
                double d = Math.sqrt(Math.pow((x1 - x), 2) + Math.pow((y1 - y), 2));
                // если длина гипотенузы меньше длины радису, то точка принадлжеит кругу
                if (d < r) {
                    return annotations[i];
                } 
            } else {
                if (figure instanceof Rectangle) {
                    int x1 = coordinates[0];
                    int y1 = coordinates[1];
                    int x2 = coordinates[2];
                    int y2 = coordinates[3];
                    if ((x >= x1) && (x <= x2) && (y >= y1) && (y <= y2)) {
                        return annotations[i];
                    }
                }
            }
        }
        return null;
    }

    /**
     * 2) выбор аннотации по шаблону подписи;
     * В массиве аннотаций требуется найти первую,
     * подпись которой содержит заданную подстроку.
     * 
     * @return аннтация по шаблону / null - если нет в массиве.
     */

    public static Annotation label(Annotation[] annotations, String label) {
        for (int i = 0; i < annotations.length; i++) {
            if (annotations[i].getName().contains(label)) {
                return annotations[i];
            }
        }
        return null;
    }
}
