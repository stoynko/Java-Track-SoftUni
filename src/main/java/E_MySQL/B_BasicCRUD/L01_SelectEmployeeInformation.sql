-- Write a query to select all employees and retrieve information about their id, first_name, last_name and job_title ordered by id.

SELECT emp.id,
       emp.first_name,
       emp.last_name,
       emp.job_title
FROM `employees` AS emp
ORDER BY emp.id;