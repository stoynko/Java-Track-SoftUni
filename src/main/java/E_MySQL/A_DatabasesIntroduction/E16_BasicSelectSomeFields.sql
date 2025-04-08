-- Modify queries from previous problem to show only some of the columns. For table:
--    •	towns – name
--    •	departments – name
--    •	employees – first_name, last_name, job_title, salary

Keep the ordering from the previous problem. Submit your query statements as Prepare DB & Run queries. */

SELECT `name` FROM `towns` ORDER BY `name`;
SELECT `name` FROM `departments` ORDER BY `name`;
SELECT `first_name`, `last_name`, `job_title`, `salary` FROM employees ORDER BY `salary` DESC;