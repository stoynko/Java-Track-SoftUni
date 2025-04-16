-- Write a query to retrieve information about the managers – id, full_name, deparment_id and department_name.
-- Select the first 5 departments ordered by employee_id.
-- Submit your queries using the "MySQL prepare DB and Run Queries" strategy.

SELECT dep.manager_id AS 'employee_id',
       CONCAT(emp.first_name, ' ', emp.last_name),
       dep.department_id,
       dep.name
FROM departments as dep
         JOIN employees AS emp ON emp.employee_id = dep.manager_id
ORDER BY employee_id
    LIMIT 5;