-- Create a user-defined function with the name udf_get_offerings_average_price_per_restaurant
-- (restaurant_name VARCHAR(40)) that receives a restaurant_name and returns the average price of offerings offered in this
-- restaurant. Round the result to the second decimal place.
-- Required Columns
-- •	restaurant_name
-- •	average_offering_price

CREATE FUNCTION udf_get_offerings_average_price_per_restaurant(restaurant_name VARCHAR(40)) RETURNS DECIMAL(19,2)
DETERMINISTIC
    BEGIN
    RETURN (SELECT DISTINCT ROUND(AVG(o.price), 2)
        FROM offerings AS o
            JOIN restaurants AS r ON o.restaurant_id = r.id
        WHERE r.name = restaurant_name
        GROUP BY r.name);
    END