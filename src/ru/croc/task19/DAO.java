package ru.croc.task19;

import java.sql.*;

public class DAO {
    /**
     * Получение по id пользователя времени доставки всех его заказов вместе с
     * именами курьеров,
     * которые эти заказы выполняют.
     * 
     * @param id login пользователя
     * @return времени доставки всех его заказов вместе с именами курьеров, которые
     *         эти заказы выполняют
     */
    public void findAllOrdersofCourier(int id) {
        try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {
            final Statement statement = conn.createStatement();
            try (ResultSet result = statement
                    .executeQuery(
                            "select time, courier.name from orders join courier on COURIERNUMBER=EMPLOYEENUMBER  where userid="
                                    + id + "")) {
                while (result.next()) {
                    System.out.println("Time: " + result.getString("time"));
                    System.out.println("Courier: " + result.getString("name"));
                    System.out.println("------------------");
                }

            } catch (SQLException e) {
                System.out.println(e);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Получение по id курьера всех заказов, которые ему нужно доставить (вместе с именами получателей).
     * @param id - курьера
     */
    public void findByCourier(int id) {
        try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {
            final Statement statement = conn.createStatement();
            try (ResultSet result = statement
                    .executeQuery("select users.name,time,product from orders join users on iduser=userid where couriernumber=" + id + "")) {
                while (result.next()) {
                    System.out.println("Name: " + result.getString("name"));
                    System.out.println("Time: " + result.getString("time"));
                    System.out.println("Product: " + result.getString("product"));
                    System.out.println("------------------");
                }

            } catch (SQLException e) {
                System.out.println(e);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
