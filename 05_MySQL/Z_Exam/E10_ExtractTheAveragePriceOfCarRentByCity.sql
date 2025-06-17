/*Create a user defined function with the name udf_average_ price_by_city (name VARCHAR(40))
that receives a city name and returns the average price per day for all rental companies in a given city.
Required Columns:
    •	name (city)
    •	average_price_per_day (average_price_per_day)
Note: Submit only the body of the function. Do not include any delimiters (e.g., DELIMITER $$) */

DELIMITER $$
CREATE FUNCTION udf_average_price_by_city(city_name VARCHAR(40)) RETURNS DECIMAL(10,2)
    DETERMINISTIC
BEGIN
    RETURN (SELECT AVG(rc.price_per_day)
            FROM rental_companies AS rc
                     JOIN cities AS c ON c.id = rc.city_id
            WHERE c.name = city_name);
END$$