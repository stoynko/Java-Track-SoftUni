-- Make the whole name UPPERCASE of any offering containing the word "Pizza".

UPDATE offerings
SET name = UPPER(name)
WHERE name like '%Pizza%';