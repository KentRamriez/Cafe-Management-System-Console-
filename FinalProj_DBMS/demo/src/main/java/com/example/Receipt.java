package com.example;

import java.util.List;

public class Receipt {
    private List<Order> orders;

    public Receipt(List<Order> orders) {
        this.orders = orders;
    }

    public void print() {
        System.out.println("\nReceipt:");
        double total = 0.0;

        for (Order order : orders) {
            int orderId = order.getId();
            int menuItemId = order.getMenuItemId();
            String menuItemName = order.getMenuItemName();
            double price = order.getPrice();
            int quantity = order.getQuantity();

            System.out.printf("Order ID: %d, Menu Item: %s, Price: %.2f, Quantity: %d%n", orderId, menuItemName, price, quantity);
            total += price * quantity;
        }

        System.out.printf("Total Amount: %.2f%n", total);
    }
}