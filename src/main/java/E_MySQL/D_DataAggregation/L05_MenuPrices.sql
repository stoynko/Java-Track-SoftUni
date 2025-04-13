-- Write a query to retrieve information about the prices of each category.
-- The output should consist of:
-- •	Category_id
-- •	Average Price
-- •	Cheapest Product
-- •	Most Expensive Product
-- See the examples for more information. Round the results to 2 digits after the decimal point.
-- Submit your queries with the MySQL prepare DB & run queries strategy.

SELECT prdt.category_id,
       ROUND(AVG(prdt.price), 2),
       MIN(prdt.price),
       MAX(prdt.price)
FROM products AS prdt
GROUP BY prdt.category_id