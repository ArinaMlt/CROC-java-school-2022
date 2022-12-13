package ru.croc.task18;

import java.util.List;

public class Order {
    private int number;
    private String login;

    public List<Product> getProducts() {
        return products;
    }

    private List<Product> products;


    public Order(int number, String login, List<Product> products) {
        this.number = number;
        this.login = login;
        this.products = products;
    }

    public int getNumber() {
        return number;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public String toString() {
        return "Order{" +
                "number=" + number +
                ", login='" + login + '\'' +
                ", products=" + products +
                '}';
    }
}
