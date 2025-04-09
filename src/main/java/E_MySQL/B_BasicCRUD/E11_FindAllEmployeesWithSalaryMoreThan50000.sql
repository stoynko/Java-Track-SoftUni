-- Write a SQL query to find first name, last name and salary of those employees who has salary more than 50000.
-- Order them in decreasing order by salary. Submit your query statements as Prepare DB & run queries.

SELECT emp.first_name,
       emp.last_name,
       emp.salary
FROM employees AS emp
WHERE emp.salary > 50000
ORDER BY emp.salary DESC;