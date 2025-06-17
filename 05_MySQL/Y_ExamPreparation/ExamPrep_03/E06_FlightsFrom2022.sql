/* Write a query that returns: flight_code, departure_country, airplane_id and departure from table flights.
Filter flights only from the 2022 year. Order the results ascending by airplane_id then by flight_code and show only the first 20 results.
Required Columns:
    •	flight_code
    •	departure_country
    •	airiplane_id
    •	departure */

SELECT flight_code,
       departure_country,
       airplane_id,
       departure
FROM flights
WHERE YEAR (departure) = '2022'
ORDER BY airplane_id, flight_code
    LIMIT 20;