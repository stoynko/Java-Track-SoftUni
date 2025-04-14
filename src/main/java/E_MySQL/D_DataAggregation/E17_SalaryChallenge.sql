-- Write a query that returns:
-- •	first_name
-- •	last_name
-- •	department_id
-- for all employees who have salary higher than the average salary of their respective departments.
-- Select only the first 10 rows. Order by department_id, employee_id.

SELECT emp.first_name,
       emp.last_name,
       emp.department_id
FROM employees AS emp
WHERE salary > (SELECT AVG(salary) FROM employees
                WHERE department_id = emp.department_id)
ORDER BY department_id, employee_id
    LIMIT 10;