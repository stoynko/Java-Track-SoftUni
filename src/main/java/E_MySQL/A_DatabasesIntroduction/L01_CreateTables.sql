-- Table "employees":
-- •	id – INT, primary key, AUTO_INCREMENT;
-- •	first_name – VARCHAR, NOT NULL;
-- •	last_name – VARCHAR, NOT NULL;
-- Create the "categories" and "products" tables analogically:
-- Table "categories":
-- •	id – INT, primary key, AUTO_INCREMENT;
-- •	name – VARCHAR, NOT NULL;
-- Table "products":
-- •	id –  INT, primary key, AUTO_INCREMENT;
-- •	name – VARCHAR, NOT NULL;
-- •	category_id – INT, NOT NULL – it is not a foreign key for now.

CREATE TABLE `employees` (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NULL,
    last_name  VARCHAR(50) NULL
);

CREATE TABLE `products` (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    category_id INT NOT NULL
);

create table `categories` (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

