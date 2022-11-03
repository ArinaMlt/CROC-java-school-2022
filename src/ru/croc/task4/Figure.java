package ru.croc.task4;

public class Figure {
    private String name;
    {
        name = "Figure";
    }
    private int[] coordinates;

    public Figure(String name, int... coordinates) {
        this.name = name;
        this.coordinates = new int[coordinates.length];
        for (int i = 0; i < coordinates.length; i++) {
            this.coordinates[i] = coordinates[i];
        }
    }

    public String getName() {
        return this.name;
    }

    public int[] getCoordinates() {
        return this.coordinates;
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
}
