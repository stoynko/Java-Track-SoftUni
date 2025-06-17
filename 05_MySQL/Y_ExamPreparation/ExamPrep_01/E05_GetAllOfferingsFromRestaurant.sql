-- Write a query that returns the name and price from table offerings.
-- Filter only the offerings from a restaurant named "Burger Haven".
-- Order the results ascending by offering id.
-- Required Columns
-- •	name (offering)
-- •	price (offering)

SELECT name, price FROM offerings
WHERE restaurant_id = 1
ORDER BY id;