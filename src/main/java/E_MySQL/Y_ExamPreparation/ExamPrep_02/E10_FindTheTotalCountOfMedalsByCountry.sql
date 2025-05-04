-- Create a user-defined function with the name udf_total_medals_count_by_country (name VARCHAR(40))
-- that receives a country_name and returns the total number of medals won by all athletes competing
-- for that country.
-- Required Columns
-- •	country_name
-- •	count_of_medals

CREATE FUNCTION udf_total_medals_count_by_country(name VARCHAR(40)) RETURNS INT
DETERMINISTIC
    BEGIN
    RETURN ( SELECT COUNT(*)
        FROM countries AS c
            JOIN athletes a on c.id = a.country_id
            LEFT JOIN disciplines_athletes_medals dam on a.id = dam.athlete_id
        WHERE c.name = name
        GROUP BY c.name);
END