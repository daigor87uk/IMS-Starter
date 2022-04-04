drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `Name` VARCHAR(40) DEFAULT NULL,
    `price` float(11) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
    `OrderNumber` INT(11) NOT NULL AUTO_INCREMENT,
    `CustomerID` INT(11) NOT NULL,
	 PRIMARY KEY (`OrderNumber`),
     FOREIGN KEY (`CustomerID`) REFERENCES customers(id)
);

CREATE TABLE IF NOT EXISTS `ims`.`orders_items` (
	`OrderNumber` INT(11) NOT NULL,
    `id` INT(11) NOT NULL,
    FOREIGN KEY (`OrderNumber`) REFERENCES orders(OrderNumber),
    FOREIGN KEY (`id`) REFERENCES items(id)
);