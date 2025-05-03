/* The task involved designing and managing a relational database for a fictional restaurant management system called Foods Friends.
The system tracks restaurants, their offerings, customer orders, and the connection between them.
You have been tasked to create the tables in the database by the following models:

   ┌──────────────────────────────────────────────────────────────────────────────────────────────┐
   │                                         Restaurants                                          │
   ├───────────────┬────────────────────────────────────────────────┬─────────────────────────────┤
   │ Column Name   │                   Data Type                    │         Constraints         │
   │───────────────│────────────────────────────────────────────────│─────────────────────────────│
   │ id            │ INTEGER (1 to 2,147,483,647)                   │ PRIMARY KEY, AUTO INCREMENT │
   │───────────────┼────────────────────────────────────────────────┼─────────────────────────────│
   │ name          │ A string containing a maximum of 40 characters.│ NULL is NOT permitted.      │
   │               │  Unicode is NOT needed.                        │ UNIQUE values.              │
   │───────────────┼────────────────────────────────────────────────┼─────────────────────────────│
   │ type          │ A string containing a maximum of 40 characters.│ NULL is NOT permitted.      │
   │               │ Unicode is NOT needed.                         │                             │
   │───────────────┼────────────────────────────────────────────────┼─────────────────────────────│
   │ non_stop      │ It can be true or false.                       │ NULL is NOT permitted.      │
   └───────────────┴────────────────────────────────────────────────┴─────────────────────────────┘

   ┌───────────────────────────────────────────────────────────────────────────────────────────────────┐
   │                                             Offerings                                             │
   ├───────────────┬─────────────────────────────────────────────────────┬─────────────────────────────┤
   │ Column Name   │                      Data Type                      │         Constraints         │
   ├───────────────┼─────────────────────────────────────────────────────┼─────────────────────────────┤
   │ id            │ Integer, from 1 to 2,147,483,647.                   │ Primary Key AUTO_INCREMENT  │
   ├───────────────┼─────────────────────────────────────────────────────┼─────────────────────────────┤
   │ name          │ A string containing a maximum of 40 characters.     │ NULL is NOT permitted.      │
   │               │ Unicode is NOT needed.                              │ UNIQUE values.              │
   ├───────────────┼─────────────────────────────────────────────────────┼─────────────────────────────┤
   │ price         │ DECIMAL, up to 19 digits,                           │ NULL is NOT permitted.      │
   │               │  2 of which are after the decimal point.            │                             │
   ├───────────────┼─────────────────────────────────────────────────────┼─────────────────────────────┤
   │ vegan         │ It can be true or false.                            │ NULL is NOT permitted.      │
   ├───────────────┼─────────────────────────────────────────────────────┼─────────────────────────────┤
   │ restaurant_id │ Integer, from 1 to 2,147,483,647.                   │ Relationship with table     │
   │               │                                                     │ restaurants.                │
   │               │                                                     │ NULL is NOT permitted.      │
   └───────────────┴─────────────────────────────────────────────────────┴─────────────────────────────┘
   ┌───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
   │                                                     Customers                                                             │
   ├───────────────┬────────────────────────────────────────────────────────────────────────────┬──────────────────────────────┤
   │ Column Name   │                                Data Type                                   │         Constraints          │
   ├───────────────┼────────────────────────────────────────────────────────────────────────────┼──────────────────────────────┤
   │ id            │ Integer, from 1 to 2,147,483,647.                                          │ Primary Key AUTO_INCREMENT   │
   ├───────────────┼────────────────────────────────────────────────────────────────────────────┼──────────────────────────────┤
   │ first_name    │ A string containing a maximum of 40 characters.                            │ NULL is NOT permitted.       │
   │               │ Unicode is NOT needed.                                                     │                              │
   ├───────────────┼────────────────────────────────────────────────────────────────────────────┼──────────────────────────────┤
   │ last_name     │ A string containing a maximum of 40 characters.                            │ NULL is NOT permitted.       │
   │               │ Unicode is NOT needed.                                                     │                              │
   ├───────────────┼────────────────────────────────────────────────────────────────────────────┼──────────────────────────────┤
   │ phone_number  │ A string containing a maximum of 20 characters.                            │ NULL is NOT permitted.       │
   │               │ Unicode is NOT needed.                                                     │ UNIQUE values.               │
   ├───────────────┼────────────────────────────────────────────────────────────────────────────┼──────────────────────────────┤
   │ regular       │ It can be true or false.                                                   │ NULL is NOT permitted        │
   └───────────────┴────────────────────────────────────────────────────────────────────────────┴──────────────────────────────┘
    •	The combination of the first name and the last name of the customer must be UNIQUE across all customers.

   ┌───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
   │                                                        Orders                                                             │
   ├───────────────┬────────────────────────────────────────────────────────────────────────────┬──────────────────────────────┤
   │ Column Name   │                                Data Type                                   │         Constraints          │
   ├───────────────┼────────────────────────────────────────────────────────────────────────────┼──────────────────────────────┤
   │ id            │ Integer, from 1 to 2,147,483,647.                                          │ Primary Key                  │
   │               │                                                                            │ AUTO_INCREMENT               │
   ├───────────────┼────────────────────────────────────────────────────────────────────────────┼──────────────────────────────┤
   │ number        │ A string containing a maximum of 10 characters.                            │ NULL is NOT permitted.       │
   │               │  Unicode is NOT needed.                                                    │ UNIQUE values.               │
   ├───────────────┼────────────────────────────────────────────────────────────────────────────┼──────────────────────────────┤
   │ priority      │ A string containing a maximum of 10 characters.                            │ NULL is NOT permitted.       │
   │               │ Unicode is NOT needed.                                                     │                              │
   ├───────────────┼────────────────────────────────────────────────────────────────────────────┼──────────────────────────────┤
   │ customer_id   │ Integer, from 1 to 2,147,483,647.                                          │ Relationship with table      │
   │               │                                                                            │ customers.                   │
   │               │                                                                            │ NULL is NOT permitted        │
   ├───────────────┼────────────────────────────────────────────────────────────────────────────┼──────────────────────────────┤
   │ restaurant_id │ Integer, from 1 to 2,147,483,647.                                          │ Relationship with table      │
   │               │                                                                            │ restaurants.                 │
   │               │                                                                            │ NULL is NOT permitted        │
   └───────────────┴────────────────────────────────────────────────────────────────────────────┴──────────────────────────────┘

   ┌───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
   │                                                     Orders_offerings                                                      │
   ├───────────────┬────────────────────────────────────────────────────────────────────────────┬──────────────────────────────┤
   │  Column Name  │                                Data Type                                   │         Constraints          │
   ├───────────────┼────────────────────────────────────────────────────────────────────────────┼──────────────────────────────┤
   │ order_id      │ Integer, from 1 to 2,147,483,647.                                          │ Relationship with table      │
   │               │                                                                            │ orders.                      │
   │               │                                                                            │ NULL is NOT permitted.       │
   ├───────────────┼────────────────────────────────────────────────────────────────────────────┼──────────────────────────────┤
   │ offering_id   │ Integer, from 1 to 2,147,483,647.                                          │ Relationship with table      │
   │               │                                                                            │ offerings.                   │
   │               │                                                                            │ NULL is NOT permitted.       │
   ├───────────────┼────────────────────────────────────────────────────────────────────────────┼──────────────────────────────┤
   │ restaurant_id │ Integer, from 1 to 2,147,483,647.                                          │ Relationship with table      │
   │               │                                                                            │ restaurants.                 │
   │               │                                                                            │ NULL is NOT permitted.       │
   └───────────────┴────────────────────────────────────────────────────────────────────────────┴──────────────────────────────┘

   Primary Key:
    •	The primary key should be a composite key consisting of both order_id and offering_id.
        This ensures that the same order cannot contain the same offering more than once.

   Submit your solutions to the Judge for the first task. Submit only SQL table creation statements.
   Do not submit CREATE SCHEMA and USE statements. You will also be given a data.sql file.
   It will contain a dataset with random data which you will need to store in your local database.
   This data will be given to you so you will not have to think of data and lose essential time in the process.
   The data is in the form of INSERT statement queries.
 */

CREATE TABLE restaurants(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(40) CHARACTER SET ASCII NOT NULL UNIQUE,
    type VARCHAR(20) CHARACTER SET ASCII NOT NULL,
    non_stop BOOL NOT NULL
);

CREATE TABLE offerings(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(40) CHARACTER SET ASCII NOT NULL UNIQUE,
    price DECIMAL(19, 2) NOT NULL,
    vegan BOOL NOT NULL,
    restaurant_id INT NOT NULL,
    CONSTRAINT fk_offerings_restaurant_id_restaurants_id
        FOREIGN KEY (restaurant_id)
            REFERENCES restaurants(id)
);


CREATE TABLE customers(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(40) CHARACTER SET ASCII NOT NULL,
    last_name VARCHAR(40) CHARACTER SET ASCII NOT NULL,
    phone_number VARCHAR(20) CHARACTER SET ASCII NOT NULL UNIQUE,
    regular BOOL NOT NULL,
    UNIQUE(first_name, last_name)
);

CREATE TABLE orders(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    number VARCHAR(10) CHARACTER SET ASCII NOT NULL UNIQUE,
    priority VARCHAR(10) CHARACTER SET ASCII NOT NULL,
    customer_id INT NOT NULL,
    restaurant_id INT NOT NULL,
    CONSTRAINT fk_orders_customer_id_customers_id
        FOREIGN KEY (customer_id)
            REFERENCES customers(id),
    CONSTRAINT fk_orders_restaurant_id_restaurants_id
        FOREIGN KEY (restaurant_id)
            REFERENCES restaurants(id)
);

CREATE TABLE orders_offerings(
    order_id INT NOT NULL,
    offering_id INT NOT NULL,
    restaurant_id INT NOT NULL,
    PRIMARY KEY (order_id, offering_id),
    CONSTRAINT fk_order_id_orders
        FOREIGN KEY (order_id)
            REFERENCES orders(id),
    CONSTRAINT fk_offering_id_offerings
        FOREIGN KEY (offering_id)
            REFERENCES offerings(id),
    CONSTRAINT fk_orders_offerings_restaurant_id_restaurants_id
        FOREIGN KEY (restaurant_id)
            REFERENCES restaurants(id)
);
