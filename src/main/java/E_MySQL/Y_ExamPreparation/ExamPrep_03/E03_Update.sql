/* There was a mistake at the Armenian airport with the airplanes.
You must change the airplanes for all flights that departure from Armenia.
Raise the airplane_id by 1 for all flights flying from Armenia.*/

UPDATE flights
SET airplane_id = airplane_id + 1
WHERE departure_country = 22;