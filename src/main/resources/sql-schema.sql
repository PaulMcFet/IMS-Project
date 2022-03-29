drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

SHOW Tables;


CREATE TABLE Item (
    ProductID BIGINT AUTO_INCREMENT,
    ItemName VARCHAR(64) NOT NULL,
    Price FLOAT(4,2),
    PRIMARY KEY(ProductID)
);

CREATE TABLE customers (
    CustomerID BIGINT AUTO_INCREMENT,
    forename VARCHAR(64) NOT NULL,
    surname VARCHAR(64) NOT NULL,
    PRIMARY KEY(CustomerID)
    );

CREATE TABLE Orders (
	OrderID BIGINT auto_increment,
	CustomerID BIGINT,
    ProductID BIGINT,
	FOREIGN KEY(CustomerID) REFERENCES customer(CustomerID),
	FOREIGN KEY(ProductID) REFERENCES Item(ProductID), 	
    PRIMARY KEY(OrderID)
);

#Test Data
INSERT INTO Item(ItemName, Price)
VALUES("Elden Ring", 54.99);

#Test Data
INSERT INTO customer(forename, surname)
VALUES("Fred", "Smith");

#DROP TABLE customers;      
#DROP TABLE Item;
#DROP TABLE Orders;
SELECT * FROM customers;
SELECT * FROM Orders;
SELECT * FROM game;
    
    