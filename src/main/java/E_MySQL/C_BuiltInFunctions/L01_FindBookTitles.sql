-- Write a SQL query to find books which titles start with "The".
-- Order the result by id. Submit your query statements as Prepare DB & run queries.

SELECT bks.title AS 'Title'
FROM books AS bks
WHERE SUBSTRING(bks.title, 1, 3) = 'The';