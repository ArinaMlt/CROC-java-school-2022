package ru.croc.task4;
/**
 * Прямоугольники определяются координатами левого нижнего и правого верхнего углов.
 * 
 */
public class Rectangle extends Figure {

    public Rectangle(int x1, int y1, int x2, int y2) {
        super("Rectangle", x1, y1, x2, y2);
    }

    @Override
    public String toString() {
        int[] i = super.getCoordinates();
        return super.getName() + " (" + i[0] + ", " + i[1] + "), " + "(" + i[2] + ", " + i[3] + ")";
    }
}
