-- Now create bigger database called soft_uni. You will use database in the future tasks. It should hold information about:

--    • towns (id, name)
--    • addresses (id, address_text, town_id)
--    • departments (id, name)
--    • employees (id, first_name, middle_name, last_name, job_title, department_id, hire_date, salary, address_id)
-- Id columns are auto incremented starting from 1 and increased by 1 (1, 2, 3, 4…).
-- Make sure you use appropriate data types for each column. Add primary and foreign keys as constraints for each table.
-- Use only SQL queries. Consider which fields are always required and which are optional.
-- Do not submit creation of database only the insert statements.

-- Use the SoftUni database and insert some data using SQL queries.

INSERT INTO towns (name) VALUES
    ('Sofia'),
    ('Plovdiv'),
    ('Varna'),
    ('Burgas');

INSERT INTO addresses (address_text, town_id) VALUES
    ('Filip Avramov str.', 1),
    ('Vasil Aprilov Blvd', 2),
    ('Vasil Levski Blvd', 3),
    ('Aleksandrovka str.', 4);

INSERT INTO departments (name)  VALUES
    ('Engineering'),
    ('Sales'),
    ('Marketing'),
    ('Software Development'),
    ('Quality Assurance');

INSERT INTO employees (first_name, middle_name, last_name, job_title, department_id, hire_date, salary, address_id) VALUES
    ('Ivan', 'Ivanov', 'Ivanov', '.NET Developer', 4, '2013-02-01', 3500, 1),
    ('Petar', 'Petrov', 'Petrov', 'Senior Engineer', 1, '2004-03-02', 4000, 2),
    ('Maria', 'Petrova', 'Ivanova', 'Intern', 5, '2016-08-28', 525.25, 3),
    ('Georgi', 'Terziev', 'Ivanov', 'CEO', 2, '2007-12-09', 3000, 4),
    ('Peter', 'Pan', 'Pan', 'Intern', 3, '2016-08-28', 599.88, 4);