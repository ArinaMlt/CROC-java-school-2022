package ru.croc.task18;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task18 {
    public static void main(String[] args) throws SQLException {
        String productCode = "Т2";
        DAO dao = new DAO();

        System.out.println(dao.findProduct(productCode));

        Product product = new Product("Т6", "test", 100);
        System.out.println(dao.createProduct(product));

        product = new Product("Т7", "test4", 50);
        System.out.println(dao.updateProduct(product));

        dao.deleteProduct("Т7");

        String userLogin = "vasya";
        List<Product> products = new ArrayList<>(Arrays.asList(
                new Product("Т9", "test9", 900),
                new Product("Т10", "test10", 110),
                new Product("Т11", "test11", 920)));

        System.out.println(dao.createOrder(userLogin, products));

    }
}
