-- Write a SQL query to sort all records in the еmployees table by the following criteria:
-- •	First by salary in decreasing order
-- •	Then by first name alphabetically
-- •	Then by last name descending
-- •	Then by middle name alphabetically
-- Sort the information by id. Submit your query statements as Prepare DB & run queries.

SELECT * FROM employees AS emp
ORDER BY emp.salary DESC, emp.first_name, emp.last_name DESC, emp.middle_name, emp.employee_id;