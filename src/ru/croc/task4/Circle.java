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
    public boolean point(int x, int y, Circle circle){

        return false;
    }
}
