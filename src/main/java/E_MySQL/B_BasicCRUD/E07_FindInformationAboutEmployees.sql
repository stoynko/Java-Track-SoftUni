-- Write a SQL query to find all information about the employees whose job title is "Sales Representative".
-- Sort the information by id. Submit your query statements as Prepare DB & run queries.

SELECT * FROM employees
WHERE employees.job_title = 'Sales Representative';