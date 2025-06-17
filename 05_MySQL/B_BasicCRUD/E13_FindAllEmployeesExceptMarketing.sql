-- Write a SQL query to find the first and last names of all employees whose department ID is different from 4.
-- Submit your query statements as Prepare DB & run queries.

SELECT emp.first_name,
       emp.last_name
FROM employees AS emp
WHERE NOT emp.department_id = 4;