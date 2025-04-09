-- Write SQL query to find the first name, last name and salary of each employee. Sort the information by id.
-- Submit your query statements as Prepare DB & run queries.

SELECT emp.first_name,
       emp.last_name,
       emp.salary
FROM employees AS emp
ORDER BY emp.employee_id;