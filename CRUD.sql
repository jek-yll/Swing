Drop database if exists employee_manager_bdd;
create database if not exists employee_manager_bdd;

use employee_manager_bdd;

CREATE TABLE Department (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE Employee (
    id INT PRIMARY KEY AUTO_INCREMENT,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    role_emp VARCHAR(50) NOT NULL,
    department_id INT ,
    FOREIGN KEY (department_id) REFERENCES Department(id)
);

INSERT INTO Department (name) VALUES
('HR'),
('Finance'),
('IT');

INSERT INTO Employee (firstname, lastname, department_id, role_emp) VALUES
('John', 'Doe', 1, "RH"),
('Alice', 'Smith', 1, "EMPLOYEE"),
('Bob', 'Johnson', 1, "MANAGER");