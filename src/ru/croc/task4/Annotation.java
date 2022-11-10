package ru.croc.task4;

public class Annotation {
    private String name;
    private Figure figure;

    public Annotation(Figure figure, String name) {
        this.figure = figure;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Figure getFigure() {
        return figure;
    }

    @Override
    public String toString() {
        return figure + ": " + name;
    }
}
