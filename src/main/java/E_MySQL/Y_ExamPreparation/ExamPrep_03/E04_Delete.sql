-- Delete all flights that don't have passengers.

DELETE
FROM flights
WHERE id NOT IN (SELECT DISTINCT flight_id FROM flights_passengers)