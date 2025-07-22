package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/mydatabase",
                    "myuser",
                    "mypassword"
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver not found!");
        }

//        System.out.println(getOrders());
        Integer id = scanner.nextInt();
        System.out.println(getOrderById(id));

    }

    public static List<Order> getOrders() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from orders order by id");

        List<Order> orders = new ArrayList<>();

        while (resultSet.next()) {
            var orderDto = new Order(
                    resultSet.getInt("id"),
                    resultSet.getString("order_number"),
                    resultSet.getInt("quantity")
            );
            orders.add(orderDto);
        }

        return orders;
    }

    public static Order getOrderById(Integer id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("select * from orders where id = ?");
        ps.setInt(1, id);
        var rs = ps.executeQuery();
        rs.next();

        return new Order(
                rs.getInt("id"),
                rs.getString("order_number"),
                rs.getInt("quantity")
        );
    }
}
