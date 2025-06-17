-- Write a query that selects:
-- •	employee_id
-- •	first_name
-- •	manager_id
-- •	manager_name
-- Filter all employees with a manager who has id equal to 3 or 7.
-- Return all rows sorted by employee first_name in ascending order.

SELECT e.employee_id,
       e.first_name,
       e.manager_id,
       emp.first_name
FROM employees AS e
         JOIN employees as emp
              ON e.manager_id = emp.employee_id
WHERE e.manager_id IN (3, 7)
ORDER BY e.first_name;