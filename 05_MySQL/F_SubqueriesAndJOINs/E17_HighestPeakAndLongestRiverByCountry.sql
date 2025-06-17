-- For each country, find the elevation of the highest peak and the length of the longest river,
-- sorted by the highest peak_elevation (from highest to lowest), then by the longest river_length
-- (from longest to smallest), then by country_name (alphabetically).
-- Display NULL when no data is available in some of the columns.
-- Limit only the first 5 rows.

SELECT c.country_name,
       MAX(p.elevation) AS 'highest_peak_elevation',
       MAX(r.length) AS 'longest_river_length'
FROM countries AS c
LEFT JOIN mountains_countries AS mc
    ON c.country_code = mc.country_code
LEFT JOIN peaks AS p
    ON mc.mountain_id = p.mountain_id
LEFT JOIN countries_rivers AS cr
    ON c.country_code = cr.country_code
LEFT JOIN rivers AS r
    ON cr.river_id = r.id
GROUP BY c.country_name
ORDER BY highest_peak_elevation DESC, longest_river_length DESC, c.country_name
LIMIT 5;