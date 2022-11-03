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
        int[] i = super.getCoordinates();
        return super.getName() + " (" + i[0] + ", " + i[1] + ") " + i[2];
    }
}
