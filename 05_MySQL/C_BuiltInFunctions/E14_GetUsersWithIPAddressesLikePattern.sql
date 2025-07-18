-- Find the user_name and the ip_address for each user, sorted by user_name alphabetically.
-- Display only the rows, where the ip_address matches the pattern: "___.1%.%.___".
-- Submit your query statements as Prepare DB & run queries.

SELECT user_name, ip_address FROM users
WHERE ip_address LIKE ('___.1%.%.___')
ORDER BY user_name;

-- Variation 02

SELECT user_name, ip_address FROM users
WHERE ip_address REGEXP ('^[0-9]{3}\\.1[0-9]*\\.[0-9]*\\.[0-9]{3}$')
ORDER BY user_name;