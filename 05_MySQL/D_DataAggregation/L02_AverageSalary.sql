-- Write a query to calculate the average salary in each department.
-- Order the information by department_id. Round the salary result to two digits after the decimal point.
-- Submit your queries with the MySQL prepare DB & run queries strategy.

SELECT emp.department_id,
       ROUND(AVG(emp.salary), 2) AS 'Average Salary'
FROM employees AS emp
GROUP BY emp.department_id
ORDER BY emp.department_id;