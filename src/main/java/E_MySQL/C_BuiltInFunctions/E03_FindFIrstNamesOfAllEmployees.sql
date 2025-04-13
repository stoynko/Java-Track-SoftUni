-- Write a SQL query to find the first names of all employees in the departments with ID 3 or 10 and whose hire year is between 1995 and 2005 inclusively.
-- Order the information by id. Submit your query statements as Prepare DB & run queries.


SELECT emp.first_name
FROM employees AS emp
WHERE emp.department_id IN (3, 10) AND
    YEAR(emp.hire_date) BETWEEN 1995 AND 2005;

-- Variation 02

SELECT emp.first_name
FROM employees AS emp
WHERE emp.department_id IN (3, 10) AND
      emp.hire_date BETWEEN '1995-01-01 00:00:00' AND '2005-12-31 00:00:00';