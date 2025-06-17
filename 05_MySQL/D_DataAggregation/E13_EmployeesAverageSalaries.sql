-- Select all high paid employees who earn more than 30000 into a new table.
-- Then delete all high paid employees who have manager_id = 42 from the new table.
-- Then increase the salaries of all high paid employees with department_id = 1 with 5000 in the new table.
-- Finally, select the average salaries in each department from the new table. Sort result by department_id in increasing order.

CREATE TABLE highest_paid_employees AS
SELECT * FROM employees
WHERE salary > 30000;

DELETE FROM highest_paid_employees
WHERE manager_id = 42;

UPDATE highest_paid_employees
SET salary = salary + 5000
WHERE department_id = 1;

SELECT department_id,
       AVG(salary) AS avg_salary
FROM highest_paid_employees
GROUP BY department_id
ORDER BY department_id