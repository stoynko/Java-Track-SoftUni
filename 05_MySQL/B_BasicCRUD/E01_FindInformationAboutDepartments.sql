--Write a SQL query to find all available information about the departments. Sort the information by id.
-- Submit your query statements as Prepare DB & run queries.

SELECT dep.department_id,
       dep.name,
       dep.manager_id
FROM departments AS dep
ORDER BY dep.department_id;