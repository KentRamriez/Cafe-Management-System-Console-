# Cafe Management System

## Overview

The Cafe Management System is a Java-based application designed to help manage cafe operations, including viewing the menu, placing orders, managing stock items, and viewing transactions. This project aims to provide a simple and efficient way to handle cafe-related tasks.

## Features

- **View Menu**: Display the list of available menu items with their details.
- **Add Order**: Place orders for menu items.
- **Stock Items**: Manage the stock of menu items.
- **View Transactions**: Review past transactions and orders.
- **Receipt Generation**: Print a detailed receipt for each order.

## Technologies Used

- Java
- JDBC (Java Database Connectivity) for database interactions
- MySQL for the database
- Maven for dependency management

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- MySQL Server
- Maven

### Setup Instructions

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/cafe-management-system.git
   cd cafe-management-system
   ```

2. **Configure the Database**:
   - Create a MySQL database named `Cafe`.
   - Run the SQL script provided in the `sql` directory to set up the necessary tables and initial data.

3. **Update Database Configuration**:
   - Update the database connection settings in the `DatabaseManager` class to match your MySQL configuration (username, password, etc.).

4. **Build the Project**:
   ```bash
   mvn clean install
   ```

5. **Run the Application**:
   ```bash
   mvn exec:java -Dexec.mainClass="com.example.CafeMain"
   ```

## Usage

- Upon running the application, you will be presented with a menu of options.
- Choose an option by entering the corresponding number and follow the prompts.
- You can view the menu, add orders, manage stock, and view transactions.
- The application will generate a receipt for each order placed.
