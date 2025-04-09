-- Write a SQL query to find first and last names about those employees that does not have a manager.
-- Submit your query statements as Prepare DB & run queries.

SELECT emp.first_name,
       emp.last_name
FROM employees AS emp
WHERE emp.manager_id IS NULL;