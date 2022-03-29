drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

SHOW Tables;


CREATE TABLE game (
    ProductID BIGINT AUTO_INCREMENT,
    GameTitle VARCHAR(64) NOT NULL,
    Price FLOAT(4,2),
    PRIMARY KEY(ProductID)
);

CREATE TABLE customer (
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
	FOREIGN KEY(ProductID) REFERENCES game(ProductID), 	
    PRIMARY KEY(OrderID)
);

#Test Data
INSERT INTO game(Game_title, Price)
VALUES("Elden Ring", 54.99);

#Test Data
INSERT INTO customer(forename, surname)
VALUES("William", "Smith");

#Test Data
DELETE FROM customer
WHERE CustomerID = 1;

#DROP TABLE Game;

SELECT * FROM customer;
SELECT * FROM Orders;
SELECT * FROM game;
    
    