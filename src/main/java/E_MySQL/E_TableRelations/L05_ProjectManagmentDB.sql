-- Write a query to create a project management db according to the following E/R Diagram:

CREATE DATABASE project_management_db;
USE project_management_db;

CREATE TABLE employees (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(30),
    last_name VARCHAR(30),
    project_id INT
);

CREATE TABLE projects(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    client_id INT,
    project_lead_id INT
);

CREATE TABLE clients(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    client_name VARCHAR(100)
);

ALTER TABLE projects
    ADD CONSTRAINT fk_client_id
        FOREIGN KEY (client_id)
            REFERENCES clients(id);

ALTER TABLE projects
    ADD CONSTRAINT fk_project_lead_id
        FOREIGN KEY (project_lead_id)
            REFERENCES employees(id);

ALTER TABLE employees
    ADD CONSTRAINT fk_project_id
        FOREIGN KEY (project_id)
            REFERENCES projects(id);