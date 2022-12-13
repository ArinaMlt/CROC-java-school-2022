package ru.croc.task18;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    /**
     * @param productCode Поиск в базе данных товара с указанным артикулом.
     * @return Если соответствующего товара в базе данных нет, метод возвращает
     *         null.
     * @throws SQLException
     */
    Product findProduct(String productCode) throws SQLException {
        int price = 0;
        String name = null;
        String code = null;

        try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {
            final Statement statement = conn.createStatement();
            try (ResultSet result = statement
                    .executeQuery("select * from product where vendorсode = '" + productCode + "'")) {
                while (result.next()) {
                    code = result.getString("vendorсode");
                    price = result.getInt("PRICE");
                    name = result.getString("product");
                }
                if (code == null)
                    return null;
                else
                    return new Product(code, name, price);

            } catch (SQLException e) {
                System.out.println(e);
                return null;
            }

        }
    };

    /**
     * Создание нового товара. Если в базе данных существует товар с переданным
     * артикулом,
     * метод выбрасывает исключение.
     * 
     * @param product
     * @return
     * @throws SQLException
     */
    Product createProduct(Product product) throws SQLException {
        String code = product.getCode();
        String name = product.getName();
        int price = product.getPrice();

        try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {
            final Statement statement = conn.createStatement();
            try {
                statement.execute("INSERT INTO product (vendorсode, product, price)\n" +
                        "VALUES ('" + code + "','" + name + "'," + price + ")\n");
            } catch (SQLException e) {
                throw new SQLException();
            }
        }
        return product;
    };

    /**
     * Изменение информации о товаре. Название и цена товара в базе данных
     * заменяется на значения,
     * указанные в полях параметра product.
     * 
     * @param product Артикул товара, данные которого должны быть изменены, также
     *                задается полем объекта product.
     * @return
     */
    Product updateProduct(Product product) {
        String code = product.getCode();
        String name = product.getName();
        int price = product.getPrice();

        try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {
            final Statement statement = conn.createStatement();
            try {
                statement.executeUpdate("Update product set product='" + name + "' , price=" + price
                        + " where vendorсode='" + code + "'  ");
            } catch (SQLException e) {
                throw new SQLException();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    };

    /**
     * Удаление товара и всех упоминаний о нем в заказах.
     * 
     * @param productCode
     */
    void deleteProduct(String productCode) {

        try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {
            final Statement statement = conn.createStatement();
            try {
                statement.executeUpdate("Delete from product where vendorсode='" + productCode + "'");
            } catch (SQLException e) {
                throw new SQLException();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    };

    /**
     * Создание заказа.
     * 
     * @param userLogin - Для указанного пользователя в базе данных создается новый
     *                  заказ с заданным списком товаров.
     * @param products
     * @return
     */
    Order createOrder(String userLogin, List<Product> products) {
        int number = 0;
        String login = null;
        String product = null;
        List<Product> allProducts = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {
            final Statement statement = conn.createStatement();
            try (ResultSet result = statement
                    .executeQuery("select * from orders where login ='" + userLogin + "'")) {
                System.out.println(result);

                while (result.next()) {
                    number = result.getInt("number");
                    login = result.getString("login");
                    product = result.getString("product");
                    System.out.println(number + ", " + login + ", " + product);
                    Product prod = findProduct(product);
                    if (prod != null) {
                        allProducts.add(prod);
                    }
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
            System.out.println(number);
            if (number != 0) {
                String code;
                for (Product p : products) {
                    code = p.getCode();
                    createProduct(p);
                    allProducts.add(p);
                    System.out.println("code: " + code);
                    try {
                        statement.execute("INSERT INTO orders (number, login, product)\n" +
                                "VALUES (" + number + ",'" + login + "','" + code + "')\n");
                    } catch (SQLException e) {
                        System.out.println(e);
                        throw new SQLException();
                    }
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return new Order(number, login, allProducts);
    };

}
