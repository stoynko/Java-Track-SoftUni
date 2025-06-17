/* You will have to insert records of data into the renters table.
For all renters which age is under 20 years (age < 20), insert data in the renters table with the following values:
    •	first_name – set it to the first name of the renter but reversed and lowercase.
    •	last_name – set it to the last name of the renter but reversed and lowercase.
    •	age – set it to the age of the renter plus the first digit of his/her phone_number.
    •	phone_number – set it to "1+" and phone_number. */

INSERT INTO renters (first_name, last_name, age, phone_number)
SELECT LOWER(REVERSE(r.first_name)),
       LOWER(REVERSE(r.last_name)),
       r.age + LEFT(r.phone_number, 1),
       CONCAT('1+', '', r.phone_number)
FROM renters AS r
WHERE age < 20;