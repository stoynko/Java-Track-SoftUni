-- Write SQL query to find first and last names about 5 best paid Employees ordered descending by their salary.
-- Submit your query statements as Prepare DB & run queries.

SELECT emp.first_name,
       emp.last_name
FROM employees AS emp
ORDER BY emp.salary DESC
    LIMIT 5;