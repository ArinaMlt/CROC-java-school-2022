package ru.croc.task19;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Task19 {
        public static void main(String[] args) {
                try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {
                        final Statement statement = conn.createStatement();

                        statement.execute("DROP TABLE IF EXISTS orders;");
                        statement.execute("DROP TABLE IF EXISTS product;");
                        statement.execute("DROP TABLE IF EXISTS products;");
                        statement.execute("DROP TABLE IF EXISTS courier;");

                        statement.execute("create table product(" +
                                        "vendorсode varchar(255) PRIMARY KEY, " +
                                        "product varchar(255) NOT NULL," +
                                        "price integer)");

                        statement.execute("create table courier(" +
                                        "employeeNumber integer PRIMARY KEY, " +
                                        "lastName varchar(255) NOT NULL," +
                                        "name varchar(255) NOT NULL)");

                        statement.execute("create table orders(" +
                                        "number integer, " +
                                        "login varchar(255) NOT NULL," +
                                        "product varchar(255) not null," +
                                        "couriernumber integer," +
                                        "time varchar(255) not null," +
                                        "FOREIGN KEY (couriernumber) REFERENCES courier(employeeNumber)," +
                                        "FOREIGN KEY (product) REFERENCES product(vendorсode))");

                        try {
                                statement.execute("INSERT INTO product (vendorсode, product, price)\n" +
                                                "VALUES ('Т1','Монитор',500)\n");
                                statement.execute("INSERT INTO product (vendorсode, product, price)\n" +
                                                "VALUES ('Т2','Мышь',50)\n");
                                statement.execute("INSERT INTO product (vendorсode, product, price)\n" +
                                                "VALUES ('Т3','Клавиатура',100)\n");
                                statement.execute("INSERT INTO product (vendorсode, product, price)\n" +
                                                "VALUES ('Т4','Видеокарта',200)\n");

                                statement.execute("INSERT INTO courier (employeeNumber, lastName, name)\n" +
                                                "VALUES (1,'Ivanov','Ivan')\n");
                                statement.execute("INSERT INTO courier (employeeNumber, lastName, name)\n" +
                                                "VALUES (2,'Petrov','Petr')\n");
                                statement.execute("INSERT INTO courier (employeeNumber, lastName, name)\n" +
                                                "VALUES (3,'Popova','Anna')\n");

                                statement.execute("INSERT INTO orders (number, login, product, couriernumber, time)\n" +
                                                "VALUES (1,'vasya','Т1',1,'15.12.2022 12:15')\n");
                                statement.execute("INSERT INTO orders (number, login, product, couriernumber, time)\n" +
                                                "VALUES (2,'petya','Т3',2,'16.12.2022 13:16')\n");
                                statement.execute("INSERT INTO orders (number, login, product, couriernumber, time)\n" +
                                                "VALUES (3,'nikita','Т4',2,'17.12.2022 14:17')\n");
                                statement.execute("INSERT INTO orders (number, login, product, couriernumber, time)\n" +
                                                "VALUES (4,'olga','Т4',3,'18.12.2022 13:34')\n");
                                statement.execute("INSERT INTO orders (number, login, product, couriernumber, time)\n" +
                                                "VALUES (2,'petya','Т1',3,'19.12.2022 11:12')\n");
                                statement.execute("INSERT INTO orders (number, login, product, couriernumber, time)\n" +
                                                "VALUES (4,'olga','Т2',3,'20.12.2022 22:03')\n");

                        } catch (SQLException e) {
                                System.out.println("уже существует");
                        }

                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
                DAO dao = new DAO();
                dao.findAllOrdersofCourier("olga");
                dao.findByCourier(3);
        }
}
