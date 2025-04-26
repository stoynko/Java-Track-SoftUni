-- Write a stored procedure usp_get_employees_from_town that accepts town_name as parameter and return the employees first and last name that live in the given town.
-- The result should be sorted by first_name then by last_name alphabetically and id ascending.
-- Submit your query statement as Run skeleton, run queries & check DB in Judge.

CREATE PROCEDURE usp_get_employees_from_town(town_name_param VARCHAR(15))
BEGIN
    SELECT e.first_name,
           e.last_name
    FROM employees AS e
            JOIN addresses AS a ON e.address_id = a.address_id
            JOIN towns AS t ON a.town_id = t.town_id
    WHERE t.name = town_name_param
    ORDER BY e.first_name, e.last_name, e.employee_id;
END