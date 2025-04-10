-- Write a SQL query to find first and last names of all employees whose first name starts with "Sa" (case insensitively).
-- Order the information by id. Submit your query statements as Prepare DB & run queries.

SELECT emp.first_name,
       emp.last_name
FROM employees AS emp
WHERE emp.first_name LIKE 'Sa%'
ORDER BY emp.employee_id;