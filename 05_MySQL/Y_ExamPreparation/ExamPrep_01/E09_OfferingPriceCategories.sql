-- From the database extract the offering name and price_category of the offering.
-- If the offering costs 10 or less the user must see "cheap", if the offering's price is between 10 (exclusive) and
-- 25 (inclusive) it should display "affordable". If the price is more than 25 the offering must be categorized as "expensive".
-- Order the results descending by offering's price, then by the offering name in ascending order.
-- Required Columns
-- •	name (offering)
-- •	price_category

SELECT off.name,
       CASE
           WHEN off.price <= 10 THEN 'cheap'
           WHEN off.price > 10 AND off.price <= 25 THEN 'affordable'
           WHEN off.price > 25 THEN 'expensive'
           END AS 'price_category'
FROM offerings AS off
ORDER BY off.price DESC, off.name;