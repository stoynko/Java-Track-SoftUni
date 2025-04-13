-- Write a SQL query to create view v_employees_hired_after_2000 with the first and the last name of all employees hired after 2000 year.
-- Select all from the created view. Submit your queries as Run skeleton, run queries & check DB.


CREATE OR REPLACE VIEW v_employees_hired_after_2000 AS
SELECT emp.first_name,
       emp.last_name
FROM employees AS emp
WHERE YEAR(emp.hire_date) > 2000;

SELECT * FROM v_employees_hired_after_2000;

-- Variation 02

CREATE OR REPLACE VIEW v_employees_hired_after_2000 AS
SELECT emp.first_name,
       emp.last_name
FROM employees AS emp
WHERE emp.hire_date > '2000-01-01 00:00:00';

SELECT * FROM v_employees_hired_after_2000;