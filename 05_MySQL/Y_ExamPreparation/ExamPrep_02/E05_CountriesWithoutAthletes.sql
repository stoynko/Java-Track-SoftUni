-- Write a query that returns the id and name from table countries.
-- Filter only the countries that do not have athletes at this Olympics.
-- Show only the first 15 (fifteen) results.
-- Order the results descending by country name.
-- Required Columns
-- •	id (country)
-- •	name (country)

SELECT c.id,
       c.name
FROM countries AS c
         LEFT JOIN athletes AS a on c.id = a.country_id
WHERE a.first_name IS NULL
ORDER BY c.name DESC
    LIMIT 15;