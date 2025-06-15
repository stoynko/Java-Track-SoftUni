/* Write a query that returns: id, name and brand (of the offered car for driving) from table rental_companies.
Filter only the rental companies which are without lessors. Show only the first 5 (five) results.
Order the results ascending by brand and then by rental_company id.
Required Columns:
    •	id (rental_company)
    •	name (rental_company)
    •	brand (car brand) */

SELECT rc.id, rc.name, c.brand
FROM rental_companies AS rc
         JOIN cars AS c ON rc.car_id = c.id
         LEFT JOIN lessors_rental_companies AS lrc ON rc.id = lrc.rental_company_id
WHERE lrc.lessor_id IS NULL
ORDER BY c.brand, rc.id
LIMIT 5;