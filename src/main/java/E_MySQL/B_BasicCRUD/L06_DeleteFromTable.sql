-- Write a query to delete all employees from the "employees" table who are in department 2 or 1.
-- Then select all from table `employees` and order the information by id.

DELETE FROM `employees` AS emp
WHERE emp.department_id IN (1, 2);

SELECT * FROM employees AS emp
ORDER BY emp.id;