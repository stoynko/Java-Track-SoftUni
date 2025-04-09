-- Write a SQL query to create a view v_employees_salaries with first name, last name and salary for each employee.
-- Submit your query statements as Run skeleton, run queries & check DB.

CREATE VIEW `v_employees_salaries` AS
SELECT
    emp.first_name,
    emp.last_name,
    emp.salary
FROM employees AS emp;