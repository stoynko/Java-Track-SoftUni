-- Find all countries along with information about their currency.
-- Display the country name, country code and information about its currency: either "Euro" or "Not Euro".
-- Sort the results by country name alphabetically. Submit your query statements as Prepare DB & run queries.

SELECT
    cnt.country_name,
    cnt.country_code,
    IF(cnt.currency_code = 'EUR', 'Euro', 'Not Euro') AS currency
FROM countries as cnt
ORDER BY cnt.country_name;