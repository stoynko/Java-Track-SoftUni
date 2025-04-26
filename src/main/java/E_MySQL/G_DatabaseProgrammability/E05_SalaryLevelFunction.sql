-- Write a function ufn_get_salary_level that receives salary of an employee and returns the level of the salary.
-- •	If salary is < 30000 return "Low"
-- •	If salary is between 30000 and 50000 (inclusive) return "Average"
-- •	If salary is > 50000 return "High"
-- Submit your query statement as Run skeleton, run queries & check DB in Judge.

CREATE FUNCTION ufn_get_salary_level(salary_param INT) RETURNS VARCHAR(7)
    DETERMINISTIC
BEGIN
RETURN CASE
           WHEN salary_param < 30000 THEN 'Low'
           WHEN salary_param BETWEEN 30000 AND 50000 THEN 'Average'
           WHEN salary_param > 50000 THEN 'High'
    END;
END