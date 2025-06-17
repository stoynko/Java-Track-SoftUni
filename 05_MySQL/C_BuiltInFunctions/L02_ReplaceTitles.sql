-- Write a SQL query to find books which titles start with "The" and replace the substring with 3 asterisks.
-- Retrieve data about the updated titles. Order the result by id.
-- Submit your query statements as Prepare DB & run queries.

SELECT INSERT(bks.title, 1, 3, '***') AS 'Title'
FROM books AS bks
WHERE SUBSTRING(bks.title, 1, 3) = 'The';