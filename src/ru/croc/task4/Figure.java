package ru.croc.task4;

public class Figure implements Movable{
    private String name;
    {
        name = "Figure";
    }
    private int[] coordinates;

    public Figure(String name, int... coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    public String getName() {
        return this.name;
    }

    public int[] getCoordinates() {
        return this.coordinates;
    }

    public void setCoordinates(int... coordinates){
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        String s = "";
        int[] coordinates = getCoordinates();
        for (int i = 0; i < this.coordinates.length; i++) {
            s = s + coordinates[i] + ", ";
        }
        return name + " (" + s.substring(0, s.length() - 2) + ")";
    }

    /**
     * Перемещение фигуры выбранной аннотации на смещение (dx, dy);
     * 
     */
    @Override
    public void move(int dx, int dy) {
        //
    }
}
