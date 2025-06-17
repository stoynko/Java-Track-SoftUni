/* You will have to insert records of data into the airplanes table.
The new data will be based on passengers with id equal or less than 5. Insert data in the airplanes table with the following values:
    •	model – set it to the first name of the passenger but reversed followed by '797'.
    •	passengers_capacity – set it to the number of characters of the passenger's last name multiplied by 17.
    •	tank_capacity – set it to the id of the passengers multiplied by 790.
    •	cost – set it to the number of characters of passenger's first name multiplied by 50.6 */

INSERT INTO airplanes (model, passengers_capacity, tank_capacity, cost)
SELECT CONCAT(REVERSE(first_name), '797'),
       CHARACTER_LENGTH(last_name) * 17,
       id * 790,
       CHARACTER_LENGTH(first_name) * 50.6
FROM passengers
WHERE id <= 5;