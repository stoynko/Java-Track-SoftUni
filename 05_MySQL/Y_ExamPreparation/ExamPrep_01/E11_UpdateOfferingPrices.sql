-- Create a stored procedure udp_update_prices which accepts the following parameters:
-- •	restaurant_type VARCHAR(40)
-- Due to the rising costs for electricity update the information in column price from the offerings table by increasing the offerings price by 5.00.
-- Do it only for the restaurants that work non-stop

CREATE PROCEDURE udp_update_prices(restaurant_type VARCHAR(40))
    BEGIN
    UPDATE restaurants AS r
        JOIN offerings AS o on r.id = o.restaurant_id
        SET o.price = o.price + 5
    WHERE non_stop IS TRUE;
END