-- Get information about the hiking routes – starting point and ending point, and their leaders – name and id.
-- Submit your queries using the "MySQL prepare DB and Run Queries" strategy.

SELECT starting_point AS 'route_starting_point',
        end_point AS 'route_ending_point',
        leader_id,
        CONCAT(campers.first_name, ' ', campers.last_name)
FROM routes
         JOIN campers ON leader_id = campers.id