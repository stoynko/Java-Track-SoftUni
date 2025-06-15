/* Extract from the car_rental database, info (full_name and age) about the youngest renters whose first name contains the letter 'a'.
Order the results by id of the renter in ascending order.
Required Columns:
    •	full_name (first_name + " " + last_name)
    •	age */

SELECT CONCAT(r.first_name, ' ', r.last_name) AS 'full_name',  r.age
FROM renters AS r
WHERE r.first_name LIKE '%a%' AND r.age = (SELECT MIN(age) FROM renters)
ORDER BY r.id;