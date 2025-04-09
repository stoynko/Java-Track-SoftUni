-- Find the 30 biggest countries by population from Europe. Display the country name and population.
-- Sort the results by population (from biggest to smallest), then by country alphabetically.
-- Submit your query statements as Prepare DB & run queries.

SELECT
    cnt.country_name,
    cnt.population
FROM countries as cnt
WHERE cnt.continent_code = 'EU'
ORDER BY cnt.population DESC, cnt.country_name
    LIMIT 30;