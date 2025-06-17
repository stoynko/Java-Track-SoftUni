-- Extract from the foods_friends database id, first_name and last_name of all customers with no orders.
-- Order the results by the customer's id in ascending order.
-- Required Columns
-- •	id (customer)
-- •	first_name (customer)
-- •	last_name (customer)

SELECT  c.id,
        c.first_name,
        c.last_name
FROM customers AS c
         LEFT JOIN orders AS o ON c.id = o.customer_id
WHERE o.id IS NULL
ORDER BY c.id;
