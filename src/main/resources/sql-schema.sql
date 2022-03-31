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
    `description` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
    `OrderNumber` INT(11) NOT NULL AUTO_INCREMENT,
    `ItemName` VARCHAR(40) DEFAULT NULL,
    `description` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`OrderNumber`)
);