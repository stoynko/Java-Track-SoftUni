/* Write a query that returns: the lessor`s first_name and last_name, the count of the renters they have and the city name where the company is located.
Filter only lessors who have more than one renter.
Order by renters_count in descending order, then by lessor's first_name ascending.
Required Columns:
    •	first_name (lessor)
    •	last_name (lessor)
    •	renters_count (count of the renters)
    •	city (name) */

SELECT l.first_name, l.last_name, COUNT(*) AS 'renters_count', c.name
FROM lessors AS l
         JOIN lessors_renters AS lr ON l.id = lr.lessor_id
         JOIN lessors_rental_companies AS lrc ON l.id = lrc.lessor_id
         JOIN rental_companies AS rc ON lrc.rental_company_id = rc.id
         JOIN cities AS c ON rc.city_id = c.id
GROUP BY l.first_name, l.last_name, c.name
HAVING renters_count > 1
ORDER BY renters_count DESC, l.first_name