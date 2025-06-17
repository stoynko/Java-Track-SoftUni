-- Write a query to select all employees (id, first_name and last_name (as full_name), job_title, salary) whose salaries are higher than 1000.00, ordered by id.
-- Concatenate fields first_name and last_name into 'full_name'.

SELECT emp.id,
       CONCAT(emp.first_name, ' ', emp.last_name) AS 'full_name',
       emp.job_title,
       emp.salary
FROM employees AS emp
WHERE emp.salary > 1000;