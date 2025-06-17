/* The car_rental Database needs to hold information about cities, rental_companies, cars, lessors and renters.
Your task is to create a database called car_rental. Then you will have to create several tables.
    •	cities – contains information about the cities.
    •	rental_companies – contains information about the rental_companies.
        o	Each rental_company has a city, a car and lessors.
    •	cars – contains information about the cars.
    •	lessors – contains information about the lessors.
        o	Each lessor has renters.
    •	renters – contains information about the renters.
        o	Each renter has an lessor.
    •	lessors_rental_companies – a many to many mapping table between the lessors and the rental_companies.
    •	lessors_renters - a many to many mapping table between the lessors and the renters.

    ┌───────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                               cities                                                  │
    ├───────────────┬──────────────────────────────────────────────────────────────┬────────────────────────┤
    │ Column Name   │ Data Type                                                    │        Constraints     │
    ├───────────────┼──────────────────────────────────────────────────────────────┼────────────────────────┤
    │ id            │ Integer, from 1 to 2,147,483,647.                            │ Primary Key            │
    │               │                                                              │ AUTO_INCREMENT         │
    ├───────────────┼──────────────────────────────────────────────────────────────┼────────────────────────┤
    │ name          │ A string containing a maximum of 40 characters.              │ NULL is NOT permitted. │
    │               │ Unicode is NOT needed.                                       │ UNIQUE values.         │
    └───────────────┴──────────────────────────────────────────────────────────────┴────────────────────────┘

    ┌───────────────────────────────────────────────────────────────────────────────────────┐
    │                                         cars                                          │
    ├──────────────┬───────────────────────────────────────────┬────────────────────────────┤
    │ Column Name  │ Data Type                                 │ Constraints                │
    ├──────────────┼───────────────────────────────────────────┼────────────────────────────┤
    │ id           │ Integer, from 1 to 2,147,483,647.         │ Primary Key                │
    │              │                                           │ AUTO_INCREMENT             │
    ├──────────────┼───────────────────────────────────────────┼────────────────────────────┤
    │ brand        │ A string containing a maximum of          │ NULL is NOT permitted.     │
    │              │ 20 characters. Unicode is NOT needed.     │                            │
    ├──────────────┼───────────────────────────────────────────┼────────────────────────────┤
    │ model        │ A string containing a maximum of          │ NULL is NOT permitted.     │
    │              │ 20 characters. Unicode is NOT needed.     │ UNIQUE values.             │
    └──────────────┴───────────────────────────────────────────┴────────────────────────────┘

    ┌──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                              lessors                                                                     │
    ├───────────────────────┬─────────────────────────────────────────────────────────────────────────────┬────────────────────────────────────┤
    │ Column Name           │  Data Type                                                                  │ Constraints                        │
    ├───────────────────────┼─────────────────────────────────────────────────────────────────────────────┼────────────────────────────────────┤
    │ id                    │ Integer, from 1 to 2,147,483,647.                                           │ Primary Key                        │
    │                       │                                                                             │ AUTO_INCREMENT                     │
    ├───────────────────────┼─────────────────────────────────────────────────────────────────────────────┼────────────────────────────────────┤
    │ first_name            │ A string containing a maximum of 40 characters. Unicode is NOT needed.      │ NULL is NOT permitted.             │
    ├───────────────────────┼─────────────────────────────────────────────────────────────────────────────┼────────────────────────────────────┤
    │ last_name             │ A string containing a maximum of 40 characters. Unicode is NOT needed.      │ NULL is NOT permitted.             │
    │                       │ Unicode is NOT needed.                                                      │ UNIQUE values.                     │
    ├───────────────────────┼─────────────────────────────────────────────────────────────────────────────┼────────────────────────────────────┤
    │ company_employee_from │ The DATE when the license was acquired.                                     │ NULL is NOT permitted.             │
    └───────────────────────┴─────────────────────────────────────────────────────────────────────────────┴────────────────────────────────────┘

    ┌─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                      rental_companies                                                       │
    ├───────────────────────┬───────────────────────────────────────────────────────────────────┬─────────────────────────────────┤
    │ Column Name           │ Data Type                                                         │ Constraints                     │
    ├───────────────────────┼───────────────────────────────────────────────────────────────────┼─────────────────────────────────┤
    │ id                    │ Integer, from 1 to 2,147,483,647.                                 │ Primary Key                     │
    │                       │                                                                   │ AUTO_INCREMENT                  │
    ├───────────────────────┼───────────────────────────────────────────────────────────────────┼─────────────────────────────────┤
    │ name                  │ A string containing a maximum of 40 characters.                   │ NULL is NOT permitted.          │
    │                       │ Unicode is NOT needed.                                            │ UNIQUE values.                  │
    ├───────────────────────┼───────────────────────────────────────────────────────────────────┼─────────────────────────────────┤
    │ cross_border_usage    │ It can be true or false.                                          │ NULL is NOT permitted.          │
    ├───────────────────────┼───────────────────────────────────────────────────────────────────┼─────────────────────────────────┤
    │ price_per_day         │ DECIMAL, up to 10 digits, 2 of which are after the decimal point. │ NULL is permitted.              │
    ├───────────────────────┼───────────────────────────────────────────────────────────────────┼─────────────────────────────────┤
    │ car_id                │ Integer, from 1 to 2,147,483,647.                                 │ Relationship with table cars.   │
    │                       │                                                                   │ NULL is NOT permitted.          │
    ├───────────────────────┼───────────────────────────────────────────────────────────────────┼─────────────────────────────────┤
    │ city_id               │ Integer, from 1 to 2,147,483,647.                                 │ Relationship with table cities. │
    │                       │                                                                   │ NULL is NOT permitted.          │
    └───────────────────────┴───────────────────────────────────────────────────────────────────┴─────────────────────────────────┘

    ┌───────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                     renters                                                       │
    ├───────────────┬───────────────────────────────────────────────────────────────────────────┬───────────────────────┤
    │ Column Name   │ Data Type                                                                 │ Constraints           │
    ├───────────────┼───────────────────────────────────────────────────────────────────────────┼───────────────────────┤
    │ id            │ Integer, from 1 to 2,147,483,647.                                         │ Primary Key           │
    │               │                                                                           │ AUTO_INCREMENT        │
    ├───────────────┼───────────────────────────────────────────────────────────────────────────┼───────────────────────┤
    │ first_name    │ A string containing a maximum of 40 characters. Unicode is NOT needed.    │ NULL is NOT permitted.│
    ├───────────────┼───────────────────────────────────────────────────────────────────────────┼───────────────────────┤
    │ last_name     │ A string containing a maximum of 40 characters. Unicode is NOT needed.    │ NULL is NOT permitted.│
    │               │                                                                           │ UNIQUE values.        │
    ├───────────────┼───────────────────────────────────────────────────────────────────────────┼───────────────────────┤
    │ age           │ Integer, from 1 to 2,147,483,647.                                         │ NULL is permitted.    │
    ├───────────────┼───────────────────────────────────────────────────────────────────────────┼───────────────────────┤
    │ phone_number  │ A string containing a maximum of 20 characters. Unicode is NOT needed.    │ NULL is permitted.    │
    │               │                                                                           │ UNIQUE values.        │
    └───────────────┴───────────────────────────────────────────────────────────────────────────┴───────────────────────┘

    ┌───────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                            lessors_rental_companies                                           │
    ├──────────────────────┬──────────────────────────────────┬─────────────────────────────────────────────────────┤
    │ Column Name          │ Data Type                        │ Constraints                                         │
    ├──────────────────────┼──────────────────────────────────┼─────────────────────────────────────────────────────┤
    │ lessor_id            │ Integer, from 1 to 2,147,483,647.│ Relationship with table lessors. NULL is permitted. │
    ├──────────────────────┼──────────────────────────────────┼─────────────────────────────────────────────────────┤
    │ rental_company_id    │ Integer, from 1 to 2,147,483,647.│ Relationship with table rental_companies.           │
    │                      │                                  │ NULL is NOT permitted.                              │
    └──────────────────────┴──────────────────────────────────┴─────────────────────────────────────────────────────┘

    ┌─────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                         lessors_renters                                         │
    ├──────────────┬──────────────────────────────────┬───────────────────────────────────────────────┤
    │ Column Name  │ Data Type                        │ Constraints                                   │
    ├──────────────┼──────────────────────────────────┼───────────────────────────────────────────────┤
    │ lessor_id    │ Integer, from 1 to 2,147,483,647.│ Relationship with table lessors.              │
    │              │                                  │ NULL is NOT permitted.                        │
    ├──────────────┼──────────────────────────────────┼───────────────────────────────────────────────┤
    │ renter_id    │ Integer, from 1 to 2,147,483,647.│ Relationship with table renters.              │
    │              │                                  │ NULL is NOT permitted.                        │
    └──────────────┴──────────────────────────────────┴───────────────────────────────────────────────┘
*/

CREATE TABLE cities(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE cars (
    id INT PRIMARY KEY AUTO_INCREMENT,
    brand VARCHAR(20) NOT NULL,
    model VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE lessors(
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(40) NOT NULL,
    last_name VARCHAR(40) NOT NULL UNIQUE,
    company_employee_from DATE NOT NULL
);

CREATE TABLE rental_companies(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL UNIQUE,
    cross_border_usage BOOLEAN NOT NULL,
    price_per_day DECIMAL (10, 2),
    car_id INT NOT NULL,
    city_id INT NOT NULL,
    FOREIGN KEY (car_id) REFERENCES cars(id),
    FOREIGN KEY (city_id) REFERENCES cities(id)
);

CREATE TABLE renters (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(40) NOT NULL,
    last_name VARCHAR(40) NOT NULL UNIQUE,
    age INT,
    phone_number VARCHAR(20) UNIQUE
);

CREATE TABLE lessors_rental_companies(
    lessor_id INT,
    rental_company_id INT NOT NULL,
    FOREIGN KEY (lessor_id) REFERENCES lessors(id),
    FOREIGN KEY (rental_company_id) REFERENCES rental_companies(id)
);

CREATE TABLE lessors_renters(
    lessor_id INT NOT NULL,
    renter_id INT NOT NULL,
    FOREIGN KEY (lessor_id) REFERENCES lessors(id),
    FOREIGN KEY (renter_id) REFERENCES renters(id)
);