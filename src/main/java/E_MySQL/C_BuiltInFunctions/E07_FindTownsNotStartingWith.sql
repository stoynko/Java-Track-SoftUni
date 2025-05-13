-- Write a SQL query to find all towns that do not start with letters R, B or D (case insensitively).
-- Order them alphabetically by name. Submit your query statements as Prepare DB & run queries.

SELECT * FROM towns
WHERE LEFT(name, 1) NOT IN ('R', 'B', 'D')
ORDER BY name;
