--  Using SQL query create table "people" with columns:
--   •	id – unique number for every person there will be no more than 231-1people. (Auto incremented)
--   •	name – full name of the person will be no more than 200 Unicode characters. (Not null)
--   •	picture – image with size up to 2 MB. (Allow nulls)
--   •	height –  In meters. Real number precise up to 2 digits after floating point. (Allow nulls)
--   •	weight –  In kilograms. Real number precise up to 2 digits after floating point. (Allow nulls)
--   •	gender – Possible states are m or f. (Not null)
--   •	birthdate – (Not null)
--   •	biography – detailed biography of the person it can contain max allowed Unicode characters. (Allow nulls)

-- Make id primary key. Populate the table with 5 records.
-- Submit your CREATE and INSERT statements in Judge as Run queries & check DB.

CREATE TABLE people(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL,
    picture BLOB,
    height DOUBLE(10,2),
    weight DOUBLE(10,2),
    gender CHAR(1) NOT NULL,
    birthdate DATE NOT NULL,
    biography TEXT);

INSERT INTO people (id, name, picture, height, weight, gender, birthdate, biography) VALUES
    (1, 'Ivan', 'PROFILE_PHOTO', 1.97, 90.50, 'm', '1980-10-02', 'BIOGRAPHY'),
    (2, 'Georgi', 'PROFILE_PHOTO', 1.75, 75.30, 'm', '2001-12-10', 'BIOGRAPHY'),
    (3, 'Petar', 'PROFILE_PHOTO', 1.82, 79.90, 'm', '1998-07-03', 'BIOGRAPHY'),
    (4, 'Mariya', 'PROFILE_PHOTO', 1.60, 55.10, 'f', '1993-05-07', 'BIOGRAPHY'),
    (5, 'Gergana', 'PROFILE_PHOTO', 1.70, 61.30, 'f', '1995-04-09', 'BIOGRAPHY');