-- Find information about the email providers of all users. Display the user_name and the email provider.
-- Sort the results by email provider alphabetically, then by username. Submit your query statements as Prepare DB & run queries.

SELECT user_name,
       SUBSTR(email, LOCATE('@', email) + 1) AS email_provider
FROM users
ORDER BY email_provider, user_name;