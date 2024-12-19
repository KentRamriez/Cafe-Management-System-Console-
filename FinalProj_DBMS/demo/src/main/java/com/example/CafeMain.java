package com.example;

import java.util.Scanner;

public class CafeMain {
    private static final DatabaseManager dbManager = new DatabaseManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        dbManager.connect();

        while (true) {
            System.out.println("\n1. View Menu");
            System.out.println("2. Add Order");
            System.out.println("3. Stock Items");
            System.out.println("4. View Transactions");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    dbManager.viewMenu();
                    break;
                case 2:
                    dbManager.addOrder(scanner);
                    break;
                case 3:
                    dbManager.stockItems(scanner);
                    break;
                case 4:
                    dbManager.viewTransactions();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    dbManager.disconnect();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}