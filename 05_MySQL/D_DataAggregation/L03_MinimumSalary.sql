-- Write a query to retrieve information about the departments grouped by department_id with minimum salary higher than 800.
-- Round the salary result to two digits after the decimal point.
-- Submit your queries with the MySQL prepare DB & run queries strategy.

SELECT emp.department_id,
       ROUND(MIN(emp.salary), 2) AS 'Min Salary'
FROM employees AS emp
GROUP BY emp.department_id
HAVING `Min Salary` > 800;