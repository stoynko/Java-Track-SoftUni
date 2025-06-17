-- Write a stored procedure usp_get_towns_starting_with that accept string as parameter and returns all town names starting with that string.
-- The result should be sorted by town_name alphabetically. Submit your query statement as Run skeleton, run queries & check DB in Judge.

CREATE PROCEDURE usp_get_towns_starting_with(string_param VARCHAR(5))
BEGIN
    SELECT name
    FROM towns
    WHERE name LIKE CONCAT(string_param, '%')
    ORDER BY name;
END