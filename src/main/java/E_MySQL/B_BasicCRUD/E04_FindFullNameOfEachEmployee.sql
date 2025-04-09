-- Write SQL query to find the first, middle and last name of each employee. Sort the information by id.
-- Submit your query statements as Prepare DB & run queries.

SELECT emp.first_name,
       emp.middle_name,
       emp.last_name
FROM employees AS emp
ORDER BY emp.employee_id;