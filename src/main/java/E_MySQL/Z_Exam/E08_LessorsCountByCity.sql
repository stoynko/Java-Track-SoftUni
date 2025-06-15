/* Extract from the car_rental database the city name, and the total count of all lessors who worked in rental companies in each city.
Only the cities where there are rental companies with lessors should be displayed.
(If the count of lessors in some cities is 0 (lessors_count = 0) do not print this city.)
Order the results descending by a lessors_count.
Required Columns:
    •	name (city)
    •	lessors_count */

SELECT c.name, COUNT(DISTINCT l.id) AS 'lessors_count'
FROM cities AS c
         JOIN rental_companies AS rc ON c.id = rc.city_id
         JOIN lessors_rental_companies AS lrc ON rc.id = lrc.rental_company_id
         JOIN lessors AS l ON l.id = lrc.lessor_id
GROUP BY c.name
HAVING lessors_count > 0
ORDER BY lessors_count DESC