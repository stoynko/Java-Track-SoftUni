-- Find all countries that hold the letter 'A' in their name at least 3 times (case insensitively), sorted by ISO code.
-- Display the country name and the ISO code. Submit your query statements as Prepare DB & run queries.

SELECT cnt.country_name,
       cnt.iso_code
FROM countries AS cnt
WHERE cnt.country_name LIKE ('%A%A%A%')
ORDER BY cnt.iso_code;