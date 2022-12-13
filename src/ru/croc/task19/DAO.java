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
    public void findAllOrdersofCourier(String id) {
        try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {
            final Statement statement = conn.createStatement();
            try (ResultSet result = statement
                    .executeQuery(
                            "select time, courier.name from orders join courier on COURIERNUMBER=EMPLOYEENUMBER  where login='"
                                    + id + "'")) {
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

    public void findByCourier(int id) {
        try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {
            final Statement statement = conn.createStatement();
            try (ResultSet result = statement
                    .executeQuery("select login,time,product from orders where couriernumber=" + id + "")) {
                while (result.next()) {
                    System.out.println("Name: " + result.getString("login"));
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
