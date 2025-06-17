-- Extract from the summer_olympics database full_name and age of the two athletes
-- with the minimum age who have won at least one medal.
-- Order the results by the athlete's id in ascending order.
-- Required Columns
-- •	full_name (first_name + " " + last_name)
-- •	age

SELECT
    CONCAT(a.first_name, ' ', a.last_name) AS 'full_name',
    age
FROM athletes AS a
    JOIN disciplines_athletes_medals dam on a.id = dam.athlete_id
ORDER BY age, a.id
    LIMIT 2;