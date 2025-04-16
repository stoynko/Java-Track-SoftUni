-- Write a query to get information about employee_id, first_name, last_name,
-- department_id and salary for all employees who don't have a manager.
-- Submit your queries using the "MySQL prepare DB and Run Queries" strategy.

SELECT e.employee_id,
       e.first_name,
       e.last_name,
       e.department_id,
       e.salary
FROM employees AS e
WHERE e.manager_id IS NULL