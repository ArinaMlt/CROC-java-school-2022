package ru.croc.task13;

public class Film {
    private Integer id;
    private String name;

    public Film(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return id + ", " + name;
    }
}
