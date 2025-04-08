-- Update all employees' salaries whose job_title is "Manager" by adding 100.
-- Retrieve information about salaries from table employees.

UPDATE employees SET `salary` = `salary` + 100
WHERE `job_title` = 'Manager';
SELECT emp.salary FROM employees AS emp;