-- Create a table deleted_employees(employee_id PK, first_name,last_name,middle_name,job_title,deparment_id,salary) that will hold information
-- about fired(deleted) employees from the employees table. Add a trigger to employees table that inserts the corresponding information in deleted_employees.
-- Submit your queries using the "MySQL Run Skeleton, run queries and check DB" strategy.

CREATE TABLE deleted_employees
(
    employee_id   INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name    VARCHAR(50),
    last_name     VARCHAR(50),
    middle_name   VARCHAR(50),
    job_title     VARCHAR(50),
    department_id INT,
    salary        DECIMAL(19, 4)
);

CREATE TRIGGER delete_employees_trigger
    AFTER DELETE
    ON employees
    FOR EACH ROW
    INSERT INTO deleted_employees(first_name, last_name, middle_name, job_title, department_id, salary)
    VALUES (old.first_name, old.last_name, old.middle_name, old.job_title, old.department_id, old.salary);