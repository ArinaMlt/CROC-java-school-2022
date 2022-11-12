package ru.croc.task4;

/*
 * Окружности определяются координатами центра и радиусом.
 * 
 */
public class Circle extends Figure {

    public Circle(int x1, int y1, int r) {
        super("Circle", x1, y1, r);
    }

    @Override
    public String toString() {
        int[] i = getCoordinates();
        return getName() + " (" + i[0] + ", " + i[1] + ") " + i[2];
    }

    /**
     * Перемещение фигуры выбранной аннотации на смещение (dx, dy);
     */
    @Override
    public void move(int dx, int dy) {
        int[] arr = getCoordinates();
        setCoordinates(arr[0] + dx, arr[1] + dy, arr[2]);
    }

    /**
     * принадлежит точка фигуре
     */
    @Override
    public boolean point(int x, int y) {
        int[] coordinates = getCoordinates();

        int x1 = coordinates[0];
        int y1 = coordinates[1];
        int r = coordinates[2];
        double d = Math.sqrt(Math.pow((x1 - x), 2) + Math.pow((y1 - y), 2));
        // если длина гипотенузы меньше длины радису, то точка принадлежит кругу
        if (d < r) {
            return true;
        }
        return false;
    }
}
