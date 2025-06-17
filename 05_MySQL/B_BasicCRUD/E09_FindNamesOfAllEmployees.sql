-- Write a SQL query to find the full name of all employees whose salary is 25000, 14000, 12500 or 23600.
-- Full Name is combination of first, middle and last name (separated with single space) and they should be in one column called "Full Name".
-- Submit your query statements as Prepare DB & run queries.

SELECT CONCAT(emp.first_name, ' ', emp.middle_name, ' ', emp.last_name) AS 'Full Name'
FROM employees AS emp
WHERE emp.salary IN (25000, 14000, 12500, 23600);