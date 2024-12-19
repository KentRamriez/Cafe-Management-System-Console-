package com.example;

public class Order {
    private int id;
    private int menuItemId;
    private String menuItemName;
    private double price;
    private int quantity;

    public Order(int id, int menuItemId, String menuItemName, double price, int quantity) {
        this.id = id;
        this.menuItemId = menuItemId;
        this.menuItemName = menuItemName;
        this.price = price;
        this.quantity = quantity;
    }


    public int getId() {
        return id;
    }

    public int getMenuItemId() {
        return menuItemId;
    }

    public String getMenuItemName() {
        return menuItemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}