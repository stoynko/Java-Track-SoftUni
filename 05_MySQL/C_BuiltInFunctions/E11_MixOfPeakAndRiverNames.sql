-- Combine all peak names with all river names, so that the last letter of each peak name is the same as the first letter of its corresponding river name.
-- Display the peak name, the river name, and the obtained mix(converted to lower case). Sort the results by the obtained mix alphabetically.
-- Submit your query statements as Prepare DB & run queries.

SELECT pk.peak_name,
       rvr.river_name,
       LOWER(CONCAT(pk.peak_name, SUBSTRING(rvr.river_name, 2))) AS mix
FROM peaks AS pk, rivers as rvr
WHERE RIGHT(pk.peak_name, 1) = LEFT (rvr.river_name, 1)
ORDER BY mix;