/*You have been tasked to create the tables in the database by the following models:

  ┌───────────────────────────────────────────────────────────────────────────────────────────────────────────┐
  │                                              products                                                     │
  ├─────────────┬────────────────────────────────────────────────────────────────────┬────────────────────────┤
  │ Column Name │                             Data Type                              │      Constraints       │
  ├─────────────┼────────────────────────────────────────────────────────────────────┼────────────────────────┤
  │ id          │ Integer, from 1 to 2,147,483,647.                                  │ Primary Key            │
  │             │                                                                    │ AUTO_INCREMENT         │
  ├─────────────┼────────────────────────────────────────────────────────────────────┼────────────────────────┤
  │ name        │ A string containing a maximum of 30 characters.                    │ NULL is NOT permitted. │
  │             │ Unicode is NOT needed.                                             │ UNIQUE values.         │
  ├─────────────┼────────────────────────────────────────────────────────────────────┼────────────────────────┤
  │ type        │ A string containing a maximum of 30 characters.                    │ NULL is NOT permitted. │
  │             │ Unicode is NOT needed.                                             │                        │
  ├─────────────┼────────────────────────────────────────────────────────────────────┼────────────────────────┤
  │ price       │ DECIMAL, up to 10 digits, 2 of which are after the decimal point.  │ NULL is NOT permitted. │
  └─────────────┴────────────────────────────────────────────────────────────────────┴────────────────────────┘

  ┌───────────────────────────────────────────────────────────────────────────────────────────────────────────┐
  │                                                  clients                                                  │
  ├─────────────┬────────────────────────────────────────────────────────────────────┬────────────────────────┤
  │ Column Name │                             Data Type                              │      Constraints       │
  ├─────────────┼────────────────────────────────────────────────────────────────────┼────────────────────────┤
  │ id          │ Integer, from 1 to 2,147,483,647.                                  │ Primary Key            │
  │             │                                                                    │ AUTO_INCREMENT         │
  ├─────────────┼────────────────────────────────────────────────────────────────────┼────────────────────────┤
  │ first_name  │ A string containing a maximum of 50 characters.                    │ NULL is NOT permitted. │
  │             │ Unicode is NOT needed.                                             │                        │
  ├─────────────┼────────────────────────────────────────────────────────────────────┼────────────────────────┤
  │ last_name   │ A string containing a maximum of 50 characters.                    │ NULL is NOT permitted. │
  │             │ Unicode is NOT needed.                                             │                        │
  ├─────────────┼────────────────────────────────────────────────────────────────────┼────────────────────────┤
  │ birthdate   │ The birth date of the client.                                      │ NULL is NOT permitted. │
  ├─────────────┼────────────────────────────────────────────────────────────────────┼────────────────────────┤
  │ card        │ A string containing a maximum of 50 characters.                    │                        │
  │             │ Unicode is NOT needed.                                             │                        │
  ├─────────────┼────────────────────────────────────────────────────────────────────┼────────────────────────┤
  │ review      │ A very long string field                                           │                        │
  └─────────────┴────────────────────────────────────────────────────────────────────┴────────────────────────┘

  ┌───────────────────────────────────────────────────────────────────────────────────────────────────────────┐
  │                                                  tables                                                   │
  ├─────────────┬────────────────────────────────────────────────────────────────────┬────────────────────────┤
  │ Column Name │                             Data Type                              │      Constraints       │
  ├─────────────┼────────────────────────────────────────────────────────────────────┼────────────────────────┤
  │ id          │ Integer, from 1 to 2,147,483,647.                                  │ Primary Key            │
  │             │                                                                    │ AUTO_INCREMENT         │
  ├─────────────┼────────────────────────────────────────────────────────────────────┼────────────────────────┤
  │ floor       │ Integer, from 1 to 2,147,483,647.                                  │ NULL is NOT permitted. │
  ├─────────────┼────────────────────────────────────────────────────────────────────┼────────────────────────┤
  │ reserved    │ Can be true or false                                               │                        │
  ├─────────────┼────────────────────────────────────────────────────────────────────┼────────────────────────┤
  │ capacity    │ Integer, from 1 to 2,147,483,647.                                  │ NULL is NOT permitted. │
  └─────────────┴────────────────────────────────────────────────────────────────────┴────────────────────────┘

  ┌───────────────────────────────────────────────────────────────────────────────────────────────────────────┐
  │                                                 waiters                                                   │
  ├─────────────┬────────────────────────────────────────────────────────────────────┬────────────────────────┤
  │ Column Name │                             Data Type                              │      Constraints       │
  ├─────────────┼────────────────────────────────────────────────────────────────────┼────────────────────────┤
  │ id          │ Integer, from 1 to 2,147,483,647.                                  │ Primary Key            │
  │             │                                                                    │ AUTO_INCREMENT         │
  ├─────────────┼────────────────────────────────────────────────────────────────────┼────────────────────────┤
  │ first_name  │ A string containing a maximum of 50 characters.                    │ NULL is NOT permitted. │
  │             │ Unicode is NOT needed.                                             │                        │
  ├─────────────┼────────────────────────────────────────────────────────────────────┼────────────────────────┤
  │ last_name   │ A string containing a maximum of 50 characters.                    │ NULL is NOT permitted. │
  │             │ Unicode is NOT needed.                                             │                        │
  ├─────────────┼────────────────────────────────────────────────────────────────────┼────────────────────────┤
  │ email       │ A string containing a maximum of 50 characters.                    │ NULL is NOT permitted. │
  │             │ Unicode is NOT needed.                                             │                        │
  ├─────────────┼────────────────────────────────────────────────────────────────────┼────────────────────────┤
  │ phone       │ A string containing a maximum of 50 characters.                    │                        │
  │             │ Unicode is NOT needed.                                             │                        │
  ├─────────────┼────────────────────────────────────────────────────────────────────┼────────────────────────┤
  │ salary      │ DECIMAL, up to 10 digits, 2 of which are after the decimal point.  │                        │
  └─────────────┴────────────────────────────────────────────────────────────────────┴────────────────────────┘

  ┌───────────────────────────────────────────────────────────────────────────────┐
  │                                    orders                                     │
  ├──────────────┬───────────────────────────────────────┬────────────────────────┤
  │  Column Name │             Data Type                 │      Constraints       │
  ├──────────────┼───────────────────────────────────────┼────────────────────────┤
  │ id           │ Integer, from 1 to 2,147,483,647.     │ Primary Key            │
  │              │                                       │ AUTO_INCREMENT         │
  ├──────────────┼───────────────────────────────────────┼────────────────────────┤
  │ table_id     │ Integer, from 1 to 2,147,483,647.     │ NULL is NOT permitted. │
  ├──────────────┼───────────────────────────────────────┼────────────────────────┤
  │ waiter_id    │ Integer, from 1 to 2,147,483,647.     │ NULL is NOT permitted. │
  ├──────────────┼───────────────────────────────────────┼────────────────────────┤
  │ order_time   │ Time that the order has been created. │ NULL is NOT permitted. │
  ├──────────────┼───────────────────────────────────────┼────────────────────────┤
  │ payed_status │ Can be true or false.                 │                        │
  └──────────────┴───────────────────────────────────────┴────────────────────────┘

  ┌────────────────────────────────────────────────────────────────────────────────────┐
  │                                   orders_clients                                   │
  ├─────────────┬───────────────────────────────────┬──────────────────────────────────┤
  │ Column Name │             Data Type             │           Constraints            │
  ├─────────────┼───────────────────────────────────┼──────────────────────────────────┤
  │ order_id    │ Integer, from 1 to 2,147,483,647. │ Relationship with table orders.  │
  ├─────────────┼───────────────────────────────────┼──────────────────────────────────┤
  │ client_id   │ Integer, from 1 to 2,147,483,647. │ Relationship with table clients. │
  └─────────────┴───────────────────────────────────┴──────────────────────────────────┘

  ┌─────────────────────────────────────────────────────────────────────────────────────┐
  │                                   orders_products                                   │
  ├─────────────┬───────────────────────────────────┬───────────────────────────────────┤
  │ Column Name │             Data Type             │            Constraints            │
  ├─────────────┼───────────────────────────────────┼───────────────────────────────────┤
  │ order_id    │ Integer, from 1 to 2,147,483,647. │ Relationship with table orders.   │
  ├─────────────┼───────────────────────────────────┼───────────────────────────────────┤
  │ product_id  │ Integer, from 1 to 2,147,483,647. │ Relationship with table products. │
  └─────────────┴───────────────────────────────────┴───────────────────────────────────┘
*/

CREATE TABLE products(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL UNIQUE,
    type VARCHAR(30) NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);

CREATE TABLE clients (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    birthdate DATE NOT NULL,
    card VARCHAR(50) CHARACTER SET ASCII,
    review TEXT
);

CREATE TABLE tables (
    id INT AUTO_INCREMENT PRIMARY KEY,
    floor INT NOT NULL,
    reserved BOOL,
    capacity INT NOT NULL
);

CREATE TABLE waiters (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) CHARACTER SET ASCII NOT NULL,
    last_name VARCHAR(50) CHARACTER SET ASCII NOT NULL,
    email VARCHAR(50) CHARACTER SET ASCII NOT NULL,
    phone VARCHAR(50) CHARACTER SET ASCII NOT NULL,
    salary DECIMAL(10, 2)
);

CREATE TABLE orders(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    table_id INT NOT NULL,
    waiter_id INT NOT NULL,
    order_time TIME NOT NULL,
    payed_status BOOL,
    CONSTRAINT fk_table_id_tables
        FOREIGN KEY (table_id)
            REFERENCES tables(id),
    CONSTRAINT fk_waiter_id_waiters
        FOREIGN KEY (waiter_id)
            REFERENCES waiters(id)
);

CREATE TABLE orders_clients(
    order_id INT,
    client_id INT,
    CONSTRAINT fk_order_id_orders
        FOREIGN KEY (order_id)
            REFERENCES orders(id),
    CONSTRAINT fk_client_id_table_orders
        FOREIGN KEY (client_id)
            REFERENCES clients(id)
);

CREATE TABLE orders_products(
    order_id INT,
    product_id INT,
    CONSTRAINT fk_orders_products_id_orders
        FOREIGN KEY (order_id)
            REFERENCES orders(id),
    CONSTRAINT fk_product_id_products
        FOREIGN KEY (product_id)
            REFERENCES products(id)
);