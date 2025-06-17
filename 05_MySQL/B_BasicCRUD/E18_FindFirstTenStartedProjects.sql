-- Write a SQL query to find first 10 started projects.
-- Select all information about them and sort them by start date, then by name. Sort the information by id.
-- Submit your query statements as Prepare DB & run queries.

SELECT * FROM projects AS prj
ORDER BY prj.start_date, prj.name, prj.project_id
    LIMIT 10;