-- Write a SQL query to find first and last names of all employees whose last name contains "ei" (case insensitively).
-- Order the information by id. Submit your query statements as Prepare DB & run queries.

SELECT emp.first_name,
       emp.last_name
FROM employees AS emp
WHERE emp.last_name LIKE '%ei%'
ORDER BY emp.employee_id;