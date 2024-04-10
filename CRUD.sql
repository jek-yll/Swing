create database if not exists cruddbswing;

use crudbdswing;

CREATE TABLE contact (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    number VARCHAR(20) NOT NULL
);