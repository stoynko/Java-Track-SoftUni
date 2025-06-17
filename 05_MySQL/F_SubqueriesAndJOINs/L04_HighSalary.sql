-- Write a query to count the number of employees who receive salary higher than the average.
-- Submit your queries using the "MySQL prepare DB and Run Queries" strategy.

SELECT COUNT(*) AS 'count'
FROM employees
WHERE salary > (
    SELECT AVG(salary) FROM employees);
