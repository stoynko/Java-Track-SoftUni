-- Find information about the email providers of all users. Display the user_name and the email provider.
-- Sort the results by email provider alphabetically, then by username. Submit your query statements as Prepare DB & run queries.

SELECT user.user_name,
       SUBSTR(user.email, LOCATE('@', user.email) + 1) AS `email provider`
FROM users AS `user`
ORDER BY `email provider`, user.user_name;