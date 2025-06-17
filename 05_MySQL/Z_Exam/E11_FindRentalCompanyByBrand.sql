/* Create a stored procedure udp_find_rental_company_by_car which accepts the following parameters:
    •	brand (VARCHAR(20))
Extract name and price_per_day from rental_companies for all rental companiess that offer the desired car brand.
Order the results descending by price_per_day. */

CREATE PROCEDURE udp_find_rental_company_by_car(brand VARCHAR(20))
BEGIN
    SELECT rc.name, rc.price_per_day
    FROM rental_companies AS rc
             JOIN cars AS c ON rc.car_id = c.id
    WHERE c.brand = brand
    ORDER BY price_per_day DESC;
END