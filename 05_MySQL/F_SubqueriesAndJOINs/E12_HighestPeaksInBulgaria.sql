-- Write a query that selects:
-- •	country_code
-- •	mountain_range
-- •	peak_name
-- •	elevation
-- Filter all peaks in Bulgaria with elevation over 2835.
-- Return all rows sorted by elevation in descending order.

SELECT c.country_code,
       m.mountain_range,
       p.peak_name,
       p.elevation
FROM countries AS c
         JOIN mountains_countries AS mc
              ON c.country_code = mc.country_code
         JOIN mountains AS m
              ON mc.mountain_id = m.id
         JOIN peaks AS p
              ON m.id = p.mountain_id
WHERE c.country_code = 'BG'
  AND p.elevation > 2835
ORDER BY p.elevation DESC;