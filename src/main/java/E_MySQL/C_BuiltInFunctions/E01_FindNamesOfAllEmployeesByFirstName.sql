-- Write a SQL query to find first and last names of all employees whose first name starts with "Sa" (case insensitively).
-- Order the information by id. Submit your query statements as Prepare DB & run queries.

SELECT first_name,
       last_name
FROM employees
WHERE first_name LIKE 'Sa%'
ORDER BY employee_id;