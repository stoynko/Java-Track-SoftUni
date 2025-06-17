-- Write a stored procedure usp_raise_salary_by_id(id) that raises a given employee's salary (by id as parameter) by 5%.
-- Consider that you cannot promote an employee that doesn't exist – if that happens, no changes to the database should be made.
-- Submit your queries using the "MySQL Run Skeleton, run queries and check DB" strategy.

CREATE PROCEDURE usp_raise_salary_by_id(id INT)
BEGIN
    DECLARE employee_exists INT DEFAULT 0;
    START TRANSACTION;
    SELECT COUNT(*) INTO employee_exists
    FROM employees AS e
    WHERE e.employee_id = id;

    IF (employee_exists = 0) THEN
        ROLLBACK;
    ELSE
        UPDATE employees
        SET salary = salary * 1.05
        WHERE employee_id = id;
        COMMIT;
    END IF;
END