-- Write a function ufn_count_employees_by_town(town_name) that accepts town_name as parameter and returns the count of employees who live in that town.
-- Submit your queries using the "MySQL Run Skeleton, run queries and check DB" strategy.

CREATE FUNCTION ufn_count_employees_by_town(town_name VARCHAR(50)) RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE result INT;
    SET @result := (SELECT COUNT(*) FROM employees AS e
                    JOIN addresses AS addr ON e.address_id = addr.address_id
                    JOIN towns AS t ON addr.town_id = t.town_id
                    WHERE t.name = town_name);
RETURN @result
END$$