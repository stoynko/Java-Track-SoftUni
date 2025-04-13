-- Find the max salary for each department. Filter those which have max salaries not in the range 30000 and 70000.
-- Sort result by department_id in increasing order.

SELECT department_id,
       MAX(salary) AS max_salary
FROM employees
GROUP BY department_id
HAVING max_salary NOT BETWEEN 30000 AND 70000
ORDER BY department_id