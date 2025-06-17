-- Write a stored procedure usp_raise_salaries(department_name) to raise the salary of all employees in given department as parameter by 5%.
-- Submit your queries using the "MySQL Run Skeleton, run queries and check DB" strategy.

CREATE PROCEDURE usp_raise_salaries(department_name VARCHAR(50))
BEGIN
UPDATE employees AS e
    JOIN departments AS dep ON e.department_id = dep.department_id
    SET e.salary = e.salary * 1.05
WHERE dep.name = department_name;
END