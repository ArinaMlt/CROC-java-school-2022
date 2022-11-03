package ru.croc.task4;

public class Annotation {
    private String name;
    private Figure figure;

    Annotation(Figure figure, String name) {
        this.figure = figure;
        this.name = name;
    }

    @Override
    public String toString() {
        return figure + ": " + name;
    }
}
