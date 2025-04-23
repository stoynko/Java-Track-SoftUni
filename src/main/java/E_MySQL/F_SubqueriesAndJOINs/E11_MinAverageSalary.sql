-- Write a query that returns the value of the lowest average salary of all departments.

SELECT AVG(e.salary) AS 'min_average_salary'
FROM employees AS e
GROUP BY department_id
ORDER BY min_average_salary
    LIMIT 1;