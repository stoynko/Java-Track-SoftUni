-- Count the salaries of all employees who don't have a manager.

SELECT COUNT(*)
FROM employees
WHERE manager_id IS NULL;