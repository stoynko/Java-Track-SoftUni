-- Write a query to create two tables – mountains and peaks and link their fields properly.
-- Tables should have:
-- -	Mountains:
-- •	id
-- •	name
-- -	Peaks:
-- •	id
-- •	name
-- •	mountain_id
-- Check your solutions using the "Run Queries and Check DB" strategy.

CREATE TABLE mountains (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE peaks(
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    mountain_id INT,
    CONSTRAINT fk_peaks_mountain_id
        FOREIGN KEY (mountain_id) REFERENCES mountains(id));