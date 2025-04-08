/* Modify queries from previous problem by sorting:
    •	towns - alphabetically by name
    •	departments - alphabetically by name
    •	employees - descending by salary

Submit your query statements as Prepare DB & Run queries. */

SELECT * FROM `towns` ORDER BY `name`;
SELECT * FROM `departments` ORDER BY `name`;
SELECT * FROM `employees` ORDER BY `salary` DESC;