/*A flight has been delayed. Your task is to find the flight and change the delay status to true and the departure time by 30 minutes.
Create a stored procedure udp_delay_flight which accepts the following parameters:
    •	code VARCHAR(50) */

CREATE PROCEDURE udp_delay_flight(code VARCHAR (50))
BEGIN
UPDATE flights
SET has_delay = true,
    departure = ADDTIME(departure, '00:30:00')
WHERE flight_code = code;
END