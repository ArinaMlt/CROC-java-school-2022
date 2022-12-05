package ru.croc.task13;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private List<Film> views;

    public int getId() {
        return id;
    }

    public List<Film> getViews() {
        return new ArrayList<>(this.views);
    }

    public User(int id, List<Film> views) {
        this.id = id;
        this.views = views;
    }

    @Override
    public String toString() {
        return "id: " + id + ": " + views;
    }

}
