-- Write a stored procedure usp_get_employees_by_salary_level that receive as parameter level of salary
-- (low, average or high) and print the names of all employees that have given level of salary.
-- The result should be sorted by first_name then by last_name both in descending order.
-- Submit your query statement as Run skeleton, run queries & check DB in Judge.

CREATE PROCEDURE usp_get_employees_by_salary_level(salary_param VARCHAR(7))
BEGIN
    IF salary_param = 'low' THEN SELECT first_name, last_name
                                 FROM employees
                                 WHERE salary < 30000
                                 ORDER BY first_name DESC, last_name DESC;
ELSEIF salary_param = 'average' THEN SELECT first_name, last_name
                                     FROM employees
                                     WHERE salary BETWEEN 30000 AND 50000
                                     ORDER BY first_name DESC, last_name DESC;
ELSEIF salary_param = 'high' THEN SELECT first_name, last_name
                                  FROM employees
                                  WHERE salary > 50000
                                  ORDER BY first_name DESC, last_name DESC;
END IF;
END

-- Variation 02

DELIMITER $$
CREATE FUNCTION ufn_get_salary_level(salary_param INT) RETURNS VARCHAR(10)
    DETERMINISTIC
BEGIN
RETURN CASE
           WHEN salary_param < 30000 THEN 'low'
           WHEN salary_param BETWEEN 30000 AND 50000 THEN 'average'
           WHEN salary_param > 50000 THEN 'high'
    END;
END$$

DELIMITER $$
CREATE PROCEDURE usp_get_employees_by_salary_level(salary_param VARCHAR(7))
BEGIN
SELECT first_name,
       last_name
FROM employees
WHERE ufn_get_salary_level(e.salary) = salary_param
ORDER BY first_name DESC, last_name DESC;
END$$