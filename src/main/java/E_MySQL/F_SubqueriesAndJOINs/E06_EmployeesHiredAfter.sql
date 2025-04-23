-- Write a query that selects:
-- •	first_name
-- •	last_name
-- •	hire_date
-- •	dept_name
-- Filter only employees hired after 1/1/1999 and from either the "Sales" or the "Finance" departments.
-- Sort the result by hire_date (ascending).

SELECT e.first_name,
       e.last_name,
       e.hire_date,
       d.name
FROM employees as e
         JOIN departments AS d
              ON e.department_id = d.department_id
WHERE d.department_id IN (3, 10)
  AND e.hire_date > 01-01-1999
ORDER BY e.hire_date;