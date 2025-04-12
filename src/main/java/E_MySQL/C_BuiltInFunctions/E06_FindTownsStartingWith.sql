-- Write a SQL query to find all towns that start with letters M, K, B or E (case insensitively).
-- Order them alphabetically by town name. Submit your query statements as Prepare DB & run queries.

SELECT * FROM towns
WHERE LEFT(towns.name, 1) IN ('M', 'K', 'B', 'E')
ORDER BY towns.name;