drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

SHOW Tables;


CREATE TABLE Items (
    ProductID BIGINT AUTO_INCREMENT,
    ItemName VARCHAR(64) NOT NULL,
    Price FLOAT(5,2),
    PRIMARY KEY(ProductID)
);
#An Item can be in Zero or Many Orders

CREATE TABLE customers (
    id BIGINT AUTO_INCREMENT,
    first_name VARCHAR(64) NOT NULL,
    surname VARCHAR(64) NOT NULL,
    PRIMARY KEY(id)
    );
#A customer can have Zero or Many orders.

CREATE TABLE Orders_Items(
	OrderID BIGINT AUTO_INCREMENT,
    ProductID BIGINT,
	FOREIGN KEY(ProductID) REFERENCES Items(ProductID), 
	FOREIGN KEY(OrderID) REFERENCES Orders(OrderID),
    PRIMARY KEY(OrderID, ProductID)
);

CREATE TABLE Orders (
	OrderID BIGINT,
    id BIGINT,
	FOREIGN KEY(id) REFERENCES Customers(id),
    PRIMARY KEY(OrderID)
);
#An Order can have One or Many Items
#An order can have One Customer


#Test Data
INSERT INTO Items(ItemName, Price)
VALUES("Bobblehead", 9.99);

#Test Data
INSERT INTO customers(first_name, surname)
VALUES("Richard", "Grayson");


INSERT INTO Orders_Items(OrderID) VALUE (ProductID);

#DROP TABLE customers;      
#DROP TABLE Items;
#DROP TABLE Orders;
#DROP TABLE Orders_Items;


SELECT * FROM customers;
SELECT * FROM Orders_Items;
SELECT * FROM Items;
    
    