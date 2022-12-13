package ru.croc.task17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

/**
 * Вы разрабатываете бэкенд интернет-магазина. Магазин уже функционирует и
 * принимает заказы.
 * Информация о заказах регистрируется в Excel-таблице вручную.
 * В нее внесены данные за все время существования магазина.
 * Заказчик выгрузил и передал вам эту таблицу в виде CSV-файла.
 *
 * Формат файла
 * <номер_заказа:integer>,<логин_пользователя:string>,
 * <артикул_товара:string>,<название_товара:string>,<цена_в_рублях:integer>
 *
 */
public class Task17 {
    public static void main(String[] args) throws Exception {

        String path = "/Users/arina/Downloads/CodeProjects/CROC-java-school-2022/src/ru/croc/task17/17.csv";
        BufferedReader csvReader = new BufferedReader(new FileReader(args[0]));
        BufferedReader csvReader2 = new BufferedReader(new FileReader(args[0]));

        String row;
        String[] data;
        int number;
        String login;
        String vendorсode;
        String product;
        int price;

        try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {

            final Statement statement = conn.createStatement();

            statement.execute("DROP TABLE IF EXISTS orders;");
            statement.execute("DROP TABLE IF EXISTS product;");
            statement.execute("DROP TABLE IF EXISTS products;");

            statement.execute("create table product(" +
                    "vendorсode varchar(255) PRIMARY KEY, " +
                    "product varchar(255) NOT NULL," +
                    "price integer)");

            statement.execute("create table orders(" +
                    "number integer, " +
                    "login varchar(255) NOT NULL," +
                    "product varchar(255) not null," +
                    "FOREIGN KEY (product) REFERENCES product(vendorсode))");

            while ((row = csvReader.readLine()) != null) {
                data = row.split(",");
                number = Integer.valueOf(data[0]);
                login = data[1];
                vendorсode = data[2];
                product = data[3];
                price = Integer.valueOf(data[4]);

                System.out.println(number + ", " + login + ", " + vendorсode + ", " + product + ", " + price);

                try {
                    statement.execute("INSERT INTO product (vendorсode, product, price)\n" +
                            "VALUES ('" + vendorсode + "','" + product + "'," + price + ")\n");
                } catch (SQLException e) {
                    System.out.println("уже существует");
                }
            }
            csvReader.close();

            while ((row = csvReader2.readLine()) != null) {
                data = row.split(",");
                number = Integer.valueOf(data[0]);
                login = data[1];
                vendorсode = data[2];
                product = data[3];
                price = Integer.valueOf(data[4]);
                System.out.println(number + ", " + login + ", " + vendorсode + ", " + product + ", " + price);

                statement.execute("INSERT INTO orders (number, login, product)\n" +
                        "VALUES (" + number + ",'" + login + "','" + vendorсode + "')\n");
            }
            csvReader.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
