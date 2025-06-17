/* You will have to insert data records into the offerings table.
For all offerings, whose name starts with "Grill…", insert data into the offerings table with the following values:
    •	name – set it to the name of the offering followed by a white space and then "costs:". e.g.(name+" costs:")
    •	price – keep the same value.
    •	vegan – keep the same value.
    •	restaurant_id – keep the same value. */

INSERT INTO offerings (name, price, vegan, restaurant_id)
SELECT CONCAT(name, ' ', 'costs:'),
       price,
       vegan,
       restaurant_id
FROM offerings
WHERE name LIKE 'Grill%';