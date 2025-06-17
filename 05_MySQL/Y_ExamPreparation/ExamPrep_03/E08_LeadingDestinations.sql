/* Top leading magazine "Air Above" wants to write an article about the top destinations with over 20 booked tickets.
Extract from the database, the countries that have 20 or more booked tickets for flights as a destination country by passengers.
Order the results descending by booked_tickets.
Required Columns:
    •	name (country)
    •	currency
    •	booked_tickets (number of booked tickets from passengers to the country as a destination) */

SELECT c.name,
       c.currency,
       COUNT(destination_country) AS 'booked_tickets'
FROM countries AS c
         JOIN flights f on c.id = f.destination_country
         JOIN flights_passengers fp on f.id = fp.flight_id
GROUP BY c.name, destination_country
HAVING booked_tickets >= 20
ORDER BY booked_tickets DESC;