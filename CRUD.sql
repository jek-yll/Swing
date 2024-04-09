create database if not exists crudbdswing;

use crudbdswing;

CREATE TABLE Contact (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    number VARCHAR(20) NOT NULL
);