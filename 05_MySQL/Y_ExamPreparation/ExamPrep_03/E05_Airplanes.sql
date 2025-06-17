/* Extract from the airlines_db, info about the airplanes.
Order the results by cost in descending order and then by id in descending.
Required Columns:
    •	id
    •	model
    •	passengers_capacity
    •	tank_capacity
    •	cost */

SELECT id, model, passengers_capacity, tank_capacity, cost
FROM airplanes
ORDER BY cost DESC, id DESC;