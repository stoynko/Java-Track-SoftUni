-- Find the third highest salary in each department if there is such.
-- Sort result by department_id in increasing order.

SELECT emp.department_id, (
    SELECT DISTINCT salary
    FROM employees
    WHERE department_id = emp.department_id
    ORDER BY salary DESC
    LIMIT 1 OFFSET 2 ) AS third_highest_salary
FROM employees AS emp
GROUP BY emp.department_id
HAVING third_highest_salary IS NOT NULL
ORDER BY emp.department_id;