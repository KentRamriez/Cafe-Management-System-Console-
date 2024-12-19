package com.example;
import java.sql.*;
import java.util.Scanner;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Cafe";
    private static final String USER = "Kinetics";
    private static final String PASS = "Loe";
    private Connection connection;

    public void connect() {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Disconnected from the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewMenu() {
        String query = "SELECT * FROM menu WHERE available = 1";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            System.out.println("\nMenu:");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ". " + rs.getString("name") + " - $" + rs.getDouble("price") + " | " + rs.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addOrder(Scanner scanner) {
        System.out.print("Enter menu item ID to order: ");
        int itemId = scanner.nextInt();
        scanner.nextLine();

        String insertOrder = "INSERT INTO orders (menu_item_id) VALUES (?)";
        try (PreparedStatement pstmt = connection.prepareStatement(insertOrder, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, itemId);
            pstmt.executeUpdate();

            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int orderId = generatedKeys.getInt(1);
                System.out.println("Order added successfully. Order ID: " + orderId);
                printReceipt(orderId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void printReceipt(int orderId) {
        String query = "SELECT o.id, m.name, m.price FROM orders o JOIN menu m ON o.menu_item_id = m.id WHERE o.id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, orderId);
            ResultSet rs = pstmt.executeQuery();
            System.out.println("\nReceipt:");
            while (rs.next()) {
                System.out.println("Order ID: " + rs.getInt("id"));
                System.out.println("Item: " + rs.getString(" name"));
                System.out.println("Price: $" + rs.getDouble("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void stockItems(Scanner scanner) {
        System.out.print("Enter menu item ID to stock: ");
        int itemId = scanner.nextInt();
        scanner.nextLine();
    
        System.out.print("Enter quantity to stock: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        String updateStock = "UPDATE menu SET stock = stock + ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(updateStock)) {
            pstmt.setInt(1, quantity);
            pstmt.setInt(2, itemId);
            int rowsAffected = pstmt.executeUpdate();
    
            if (rowsAffected > 0) {
                System.out.println("Successfully stocked " + quantity + " of item ID " + itemId + ".");
            } else {
                System.out.println("Item ID " + itemId + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewTransactions() {
        String query = "SELECT o.id AS order_id, m.name, m.price FROM orders o JOIN menu m ON o.menu_item_id = m.id";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            System.out.println("\nTransactions:");
            while (rs.next()) {
                System.out.println("Order ID: " + rs.getInt("order_id") + ", Item: " + rs.getString("name") + ", Price: $" + rs.getDouble("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}