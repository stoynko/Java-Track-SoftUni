-- Write a SQL query to find books which titles start with "The".
-- Order the result by id. Submit your query statements as Prepare DB & run queries.

SELECT title AS 'Title'
FROM books
WHERE SUBSTRING(title, 1, 3) = 'The';