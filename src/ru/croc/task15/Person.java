package ru.croc.task15;

import java.util.Comparator;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
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

    public static final Comparator<Person> COMPARE = new Comparator<Person>() {
        @Override
        public int compare(Person p1, Person p2) {
            if (p1.getAge() == p2.getAge())
                return p1.getName().compareTo(p2.getName());
            else {
                if (p1.getAge() < p2.getAge())
                    return 1;
                else
                    return -1;
            }
        }
    };

}
