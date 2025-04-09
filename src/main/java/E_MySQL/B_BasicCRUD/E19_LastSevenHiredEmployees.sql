-- Write a SQL query to find last 7 hired employees.
-- Select their first, last name and their hire date.
-- Submit your query statements as Prepare DB & run queries.

SELECT
    emp.first_name,
    emp.last_name,
    emp.hire_date
FROM employees AS emp
ORDER BY emp.hire_date DESC
    LIMIT 7
