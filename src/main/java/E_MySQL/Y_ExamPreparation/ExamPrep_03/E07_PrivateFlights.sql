/* Some passengers don’t have a booked flight but want to travel in private.
Write a query that returns:  flight_code, full_name and country for all passengers that don’t have a booked flight.
To find their private flight_code you must take the first 2 letters of their last name in upper case followed by their country id.
Order by country_id in ascending order.
Required Columns:
    •	flight_code (first 2 characters from last name + country_id)
    •	full_name (first_name + " " + last_name)
    •	country_id */

SELECT CONCAT(UPPER(LEFT(p.last_name, 2)), p.country_id) AS 'flight_code',
       CONCAT(p.first_name, ' ', p.last_name)  AS 'full_name',
       p.country_id AS 'country_id'
FROM passengers AS p
         LEFT JOIN flights_passengers fp on p.id = fp.passenger_id
WHERE fp.flight_id IS NULL
ORDER BY p.country_id;