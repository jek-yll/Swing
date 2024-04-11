CREATE DATABASE IF NOT EXISTS bloodgroupbdd;

USE bloodgroupbdd;

CREATE TABLE Person (
    id int PRIMARY KEY auto_increment,
    name VARCHAR(100) NOT NULL,
    gender VARCHAR(10) NOT NULL,
    age INTEGER NOT NULL,
    blood_group VARCHAR(5),
    contact_no VARCHAR(20),
    qualification VARCHAR(100),
    start_date DATE,
    address TEXT,
    image TEXT
);