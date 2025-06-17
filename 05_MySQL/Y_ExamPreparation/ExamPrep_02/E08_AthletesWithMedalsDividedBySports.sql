-- Extract from the summer_olympics database the id, first_name , last_name,
-- medals_count and the sport (in which medals were won), of the top ten athletes who have won medals.
-- Order the results descending by medals_count, then by first_name in ascending order.
-- Required Columns
-- •	id (athlete)
-- •	first_name (athlete)
-- •	last_name (athlete)
-- •	medals_count (total medals won by a single athlete)
-- •	sport

SELECT a.id,
    a.first_name,
    a.last_name,
    COUNT(dam.athlete_id) AS 'medals_count',
    s.name
FROM athletes AS a
    JOIN disciplines_athletes_medals dam on a.id = dam.athlete_id
    JOIN disciplines d on dam.discipline_id = d.id
    JOIN sports s on d.sport_id = s.id
GROUP BY a.id, a.first_name, a.last_name, s.name
ORDER BY medals_count DESC, a.first_name
    LIMIT 10;