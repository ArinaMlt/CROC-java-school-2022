package ru.croc.task18;

public class Product {
    private String code;
    private String name;
    private int price;

    public Product(String code, String name, int price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }
    
    @Override
    public String toString() {
        return "Product [code=" + code + ", name=" + name + ", price=" + price + "]";
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }
    
}
