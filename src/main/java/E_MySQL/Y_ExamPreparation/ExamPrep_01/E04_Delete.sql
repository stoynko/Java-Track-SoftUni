-- Delete all restaurants which contain the word "fast" in their name or type.

DELETE FROM restaurants
WHERE name LIKE '%fast%' OR type LIKE '%fast%';