-- Write a SQL query to find all distinct job titles. Sort the result by job title alphabetically.
-- Submit your query statements as Prepare DB & run queries.

SELECT DISTINCT
    emp.job_title
FROM employees AS emp
ORDER BY emp.job_title;