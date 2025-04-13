-- Write a query to count the number of employees in each department by id.
-- Order the information by deparment_id, then by Number of employees.
-- Submit your queries with the MySQL prepare DB & run queries strategy.

SELECT emp.department_id,
       COUNT(emp.id) AS 'Number of employees'
FROM employees AS emp
GROUP BY emp.department_id
ORDER BY 'Number of employees';