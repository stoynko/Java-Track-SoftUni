-- Write a query to retrieve information about SoftUni camp's transportation organization.
-- Get information about the drivers (name and id) and their vehicle type.
-- Submit your queries using the "MySQL prepare DB and Run Queries" strategy.

SELECT vehicles.driver_id,
       vehicles.vehicle_type,
       CONCAT(campers.first_name, ' ', campers.last_name) AS 'driver_name'
FROM vehicles
         JOIN campers ON campers.id = vehicles.driver_id