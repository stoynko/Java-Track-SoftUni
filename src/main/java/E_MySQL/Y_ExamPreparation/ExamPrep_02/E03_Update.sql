-- Remove the word "weight" from any discipline containing it.

UPDATE disciplines
SET name = LEFT(name, CHARACTER_LENGTH(name) - CHARACTER_LENGTH('weight'))
WHERE name LIKE '%weight%';