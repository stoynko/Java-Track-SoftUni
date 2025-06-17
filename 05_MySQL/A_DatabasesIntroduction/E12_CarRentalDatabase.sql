-- Using SQL queries create car_rental database with the following entities:

--    •	categories (id, category, daily_rate, weekly_rate, monthly_rate, weekend_rate)
--    •	cars (id, plate_number, make, model, car_year, category_id, doors, picture, car_condition, available)
--    •	employees (id, first_name, last_name, title, notes)
--    •	customers (id, driver_licence_number, full_name, address, city, zip_code, notes)
--    •	rental_orders (id, employee_id, customer_id, car_id, car_condition, tank_level, kilometrage_start, kilometrage_end,
--        total_kilometrage, start_date, end_date, total_days, rate_applied, tax_rate, order_status, notes)

--Set most appropriate data types for each column. Set primary key to each table. Populate each table with 3 records.
--Make sure the columns that are present in 2 tables would be of the same data type.
--Consider which fields are always required and which are optional.
--Submit your CREATE TABLE and INSERT statements as Run queries & check DB.

CREATE TABLE categories (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    category VARCHAR(50),
    daily_rate DECIMAL(10,2),
    weekly_rate DECIMAL(10, 2),
    monthly_rate DECIMAL(10, 2),
    weekend_rate DECIMAL(10,2)
);

CREATE TABLE cars (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    plate_number VARCHAR(20) NOT NULL,
    make VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    car_year YEAR,
    category_id INT NOT NULL,
    doors TINYINT,
    picture BLOB,
    car_condition VARCHAR(50) NOT NULL,
    available BOOL NOT NULL
);

CREATE TABLE employees (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    title VARCHAR(50),
    notes TEXT
);

CREATE TABLE customers (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    driver_licence_number VARCHAR(20) NOT NULL,
    full_name VARCHAR(100) NOT NULL,
    address VARCHAR(50) NOT NULL,
    city VARCHAR(50) NOT NULL,
    zip_code INT,
    notes TEXT
);

CREATE TABLE rental_orders (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    employee_id INT NOT NULL,
    customer_id INT NOT NULL,
    car_id INT NOT NULL,
    car_condition VARCHAR(50),
    tank_level TINYINT,
    kilometrage_start INT NOT NULL,
    kilometrage_end INT NOT NULL,
    total_kilometrage INT NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    total_days INT NOT NULL,
    rate_applied DECIMAL(10,2),
    tax_rate DECIMAL (10,2),
    order_status BOOL,
    notes TEXT
);

INSERT INTO categories (id, category, daily_rate, weekly_rate, monthly_rate, weekend_rate) VALUES
    (1, 'Economy', 29.99, 189.99, 749.99, 59.99),
    (2, 'SUV', 49.99, 319.99, 1249.99, 89.99),
    (3, 'Luxury', 99.99, 649.99, 2499.00, 149.99);

INSERT INTO cars (id, plate_number, make, model, car_year, category_id, doors, picture, car_condition, available) VALUES
    (1, 'BG1234AB', 'Toyota', 'Yaris', 2020, 1, 4, 'Photo', 'Excellent', true),
    (2, 'CA5678CD', 'BMW', 'X5', 2022, 2, 5, 'Photo', 'Good', false),
    (3, 'PB9012EF', 'Mercedes', 'S-Class', 2021, 3, 4, 'Photo', 'Excellent', true);

INSERT INTO employees (first_name, last_name, title, notes) VALUES
    ('Alice', 'Smith', 'Rental Manager', 'Manages front desk'),
    ('Bob', 'Johnson', 'Technician', 'Handles vehicle inspections'),
    ('Clara', 'Davis', 'Sales Rep', 'Specializes in corporate clients');

INSERT INTO customers (driver_licence_number, full_name, address, city, zip_code, notes) VALUES
    ('AB1234567', 'John Taylor', '123 Main St', 'New York', '10001', 'Repeat customer'),
    ('CD2345678', 'Emma Williams', '456 Oak Ave', 'San Diego', '92101', 'New customer'),
    ('EF3456789', 'Liam Anderson', '789 Pine Rd', 'Chicago', '60601', 'Needs GPS units');

INSERT INTO rental_orders (employee_id, customer_id, car_id, car_condition, tank_level, kilometrage_start, kilometrage_end, total_kilometrage, start_date, end_date, total_days, rate_applied, tax_rate, order_status, notes) VALUES
    (1, 1, 1, 'Excellent', 100, 10500, 10750, 250, '2024-03-01', '2024-03-05', 5, 29.99, 8.00, true, 'N/A'),
    (2, 2, 2, 'Good', 75, 5020, 5230, 210, '2024-02-15', '2024-02-20', 6, 49.99, 8.00, false, 'Returned with scratch'),
    (3, 3, 3, 'Excellent', 90, 2000, 2200, 200, '2024-04-01', '2024-04-06', 6, 99.99, 8.00, true, 'N/A');