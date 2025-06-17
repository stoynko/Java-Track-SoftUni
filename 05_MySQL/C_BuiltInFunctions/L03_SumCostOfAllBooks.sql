-- Write a SQL query to sum prices of all books. Format the output to 2 digits after decimal point.
-- Submit your query statements as Prepare DB & run queries.

SELECT ROUND(SUM(bks.cost), 2)
FROM books AS bks;