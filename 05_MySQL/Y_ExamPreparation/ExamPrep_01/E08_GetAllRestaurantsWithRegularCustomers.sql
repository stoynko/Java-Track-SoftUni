-- Extract from the foods_friends database the restaurant id and name.
-- Filter only those restaurants that have regular customers and vegan offerings and are contained in HIGH-priority orders.
-- Make sure there are no duplicate rows in the resulting table.
-- Order the results ascending by restaurant id.
-- Required Columns
-- •	id (restaurant)
-- •	name (restaurant)

SELECT r.id,
       r.name
FROM restaurants AS r
         JOIN orders o on r.id = o.restaurant_id
         JOIN offerings o2 on r.id = o2.restaurant_id
         JOIN customers c on o.customer_id = c.id
WHERE o2.vegan IS TRUE AND c.regular IS TRUE AND o.priority = 'HIGH'
GROUP BY r.id, r.name
ORDER BY r.id;