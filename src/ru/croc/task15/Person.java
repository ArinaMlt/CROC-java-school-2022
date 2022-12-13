package ru.croc.task15;

import java.util.Comparator;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        if (age > 123 || name.isEmpty()) {
            throw new IllegalArgumentException("Введены неверные данные");
        }
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (" + age + ") ";
    }

    public static final Comparator<Person> COMPARE = (p1, p2) -> {
        if (p1.getAge() == p2.getAge())
            return p1.getName().compareTo(p2.getName());
        else {
            if (p1.getAge() < p2.getAge())
                return 1;
            else
                return -1;
        }
    };

}
