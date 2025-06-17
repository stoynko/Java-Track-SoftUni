-- Find all games with their corresponding part of the day and duration.
-- Parts of the day should be Morning (start time is >= 0 and < 12), Afternoon (start time is >= 12 and < 18), Evening (start time is >= 18 and < 24).
-- Duration should be Extra Short (smaller or equal to 3), Short (between 3 and 6 including), Long (between 6 and 10 including) and Extra Long in any other cases or without duration.
-- Submit your query statements as Prepare DB & run queries.

SELECT name,
    CASE
        WHEN HOUR(start) < 12 THEN 'Morning'
        WHEN HOUR(start) < 18 THEN 'Afternoon'
        WHEN HOUR(start) < 24 THEN 'Evening'
    END AS 'Part of the Day',
    CASE
        WHEN duration <= 3 THEN 'Extra Short'
        WHEN duration <= 6 THEN 'Short'
        WHEN duration <= 10 THEN 'Long'
        ELSE 'Extra Long'
    END AS 'Duration'
FROM games;