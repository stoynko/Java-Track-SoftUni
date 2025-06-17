-- Not all athletes manage to reach the dream ladder of honour.
-- Write a query that extracts (id, first_name, last_name) from the database all athletes who have not won any medals.
-- Order by id in ascending order.
-- Required Columns
-- •	id (athlete)
-- •	first_name (athlete)
-- •	last_name (athlete)

SELECT
    a.id,
    a.first_name,
    a.last_name
FROM athletes AS a
    LEFT JOIN disciplines_athletes_medals dam on a.id = dam.athlete_id
WHERE dam.athlete_id IS NULL
ORDER BY a.id;