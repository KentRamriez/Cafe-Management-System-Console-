IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'Cafe')
CREATE DATABASE Cafe;

USE Cafe;

IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'menu')
CREATE TABLE menu (
id INT IDENTITY(1,1) PRIMARY KEY,
name NVARCHAR(100) NOT NULL,
description NVARCHAR(255),
category NVARCHAR(50),
price DECIMAL(10, 2) NOT NULL,
available BIT NOT NULL DEFAULT 1,
image_url NVARCHAR(255),
stock INT NOT NULL DEFAULT 0
);

IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'orders')
CREATE TABLE orders (
id INT IDENTITY(1,1) PRIMARY KEY,
menu_item_id INT,
FOREIGN KEY (menu_item_id) REFERENCES menu(id)
);

IF NOT EXISTS (SELECT * FROM menu)
INSERT INTO menu (name, description, category, price, available, image_url) VALUES
('Coffee', 'Freshly brewed coffee', 'Beverage', 2.50, 1, 'http://example.com/images/coffee.jpg'),
('Tea', 'Aromatic herbal tea', 'Beverage', 1.75, 1, 'http://example.com/images/tea.jpg'),
('Sandwich', 'Delicious ham and cheese sandwich', 'Food', 5.00, 1, 'http://example.com/images/sandwich.jpg'),
('Cake', 'Chocolate cake with cream', 'Dessert', 3.00, 1, 'http://example.com/images/cake.jpg'),
('Juice', 'Freshly squeezed orange juice', 'Beverage', 3.00, 1, 'http://example.com/images/juice.jpg'),
('Pasta', 'Creamy Alfredo pasta', 'Food', 7.00, 1, 'http://example.com/images/pasta.jpg');
