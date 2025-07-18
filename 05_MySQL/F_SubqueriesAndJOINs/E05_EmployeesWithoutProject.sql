-- Write a query that selects:
-- •	employee_id
-- •	first_name
-- Filter only employees without a project.
-- Return the first 3 rows sorted by employee_id in descending order.

SELECT e.employee_id,
       e.first_name
FROM employees as e
         LEFT JOIN employees_projects as ep
             ON e.employee_id = ep.employee_id
WHERE ep.project_id IS NULL
ORDER BY e.employee_id DESC
    LIMIT 3;

-- Variation 02

SELECT e.employee_id,
       e.first_name
FROM employees as e
WHERE e.employee_id NOT IN (
    SELECT employee_id FROM employees_projects
)
ORDER BY e.employee_id DESC
    LIMIT 3;