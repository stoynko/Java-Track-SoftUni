-- Write a SQL query to find the first and last names of all employees whose job titles does not contain "engineer".
-- Order the information by id. Submit your query statements as Prepare DB & run queries.

SELECT
    emp.first_name,
    emp.last_name
FROM employees AS emp
WHERE emp.job_title NOT LIKE '%engineer%';