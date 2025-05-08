/*Create a user defined function with the name udf_count_flights_from_country(country VARCHAR(50)) that receives a country name
and returns the total number of flights departing from that country.
Required Columns
    •	flights_count (udf_count_flights_from_country) */

CREATE FUNCTION udf_count_flights_from_country(country VARCHAR (50)) RETURNS INT
    DETERMINISTIC
BEGIN
RETURN (SELECT COUNT(*)
        FROM flights
                 JOIN countries c on flights.departure_country = c.id
        WHERE c.name = country);
END