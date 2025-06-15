/* Due to the additional insurance for driving in foreign countries, a price increase is required.
Increase the price_per_day of each rental company, which is located in London and offers cross-border usage, by 30. */

UPDATE rental_companies
SET price_per_day = price_per_day + 30
WHERE city_id = 5 AND cross_border_usage = TRUE