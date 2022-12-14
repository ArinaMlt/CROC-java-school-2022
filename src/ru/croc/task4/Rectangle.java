package ru.croc.task4;

/**
 * Прямоугольники определяются координатами левого нижнего и правого верхнего
 * углов.
 * 
 */
public class Rectangle extends Figure {

    public Rectangle(int x1, int y1, int x2, int y2) {
        super("Rectangle", x1, y1, x2, y2);
    }

    @Override
    public String toString() {
        int[] i = getCoordinates();
        return getName() + " (" + i[0] + ", " + i[1] + "), " + "(" + i[2] + ", " + i[3] + ")";
    }

    /**
     * Перемещение фигуры выбранной аннотации на смещение (dx, dy);
     */
    @Override
    public void move(int dx, int dy) {
        int[] arr = getCoordinates();
        setCoordinates(arr[0] + dx, arr[1] + dy, arr[2] + dx, arr[3] + dy);
    }

    /**
     * принадлежит точка фигуре
     */
    @Override
    public boolean point(int x, int y) {
        int coordinates[] = getCoordinates();
        int x1 = coordinates[0];
        int y1 = coordinates[1];
        int x2 = coordinates[2];
        int y2 = coordinates[3];
        if ((x >= x1) && (x <= x2) && (y >= y1) && (y <= y2)) {
            return true;
        }
        return false;
    }
}
