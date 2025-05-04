-- From the database extract the full_name and age_group of the athletes.
-- If the athlete is 18 years of age or younger user must see "Teenager", if it is between 18 (exclusive) and 25 years (inclusive) of age it should display "Young adult".
-- If it is equal to or more than 26 of age ->"Adult".
-- Order the results descending by athlete's age, then by first_name in ascending order.
-- Required Columns
-- •	full_name (first_name + " " + last_name)
-- •	age_group

SELECT CONCAT(a.first_name, ' ', a.last_name) AS 'full_name',
    CASE
        WHEN a.age <= 18 THEN 'Teenager'
        WHEN a.age > 18 AND a.age <= 25 THEN 'Young adult'
        WHEN a.age >= 26 THEN 'Adult'
    END AS 'age_group'
FROM athletes AS a
ORDER BY a.age DESC, a.first_name