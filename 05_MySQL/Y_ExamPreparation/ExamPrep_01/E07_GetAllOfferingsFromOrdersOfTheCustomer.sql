-- Extract from the database id and name of all non-vegan offerings from all orders made by customer "Sofia Sanchez".
-- Order by offering id in ascending order.
-- Required Columns
-- •	id (offering)
-- •	name (offering)

SELECT o.id,
       o.name
FROM offerings AS o
         JOIN restaurants As r ON o.restaurant_id = r.id
         JOIN orders AS ord ON r.id = ord.restaurant_id
WHERE o.vegan IS FALSE AND ord.customer_id = 25;