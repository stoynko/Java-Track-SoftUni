-- Write a SQL query to find the first name, last name and job title of all employees whose salary is in the range [20000, 30000].
-- Sort the information by id. Submit your query statements as Prepare DB & run queries.

SELECT emp.first_name,
       emp.last_name,
       emp.job_title
FROM employees AS emp
WHERE emp.salary BETWEEN 20000 AND 30000
ORDER BY emp.employee_id;