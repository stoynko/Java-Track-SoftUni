-- Write SQL query to find all department names. Sort the information by id.
-- Submit your query statements as Prepare DB & run queries.

SELECT dep.name
FROM departments AS dep
ORDER BY dep.department_id;