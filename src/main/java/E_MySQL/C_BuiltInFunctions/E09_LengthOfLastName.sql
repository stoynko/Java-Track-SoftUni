-- Write a SQL query to find the first and last names of all employees whose last name is exactly 5 characters long.

SELECT emp.first_name,
       emp.last_name
FROM employees AS emp
WHERE CHAR_LENGTH(emp.last_name) = 5;