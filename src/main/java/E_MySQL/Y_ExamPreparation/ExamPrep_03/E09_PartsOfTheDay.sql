/*From the database extract the flight_code and departure. Morning is from 5AM to 11:59AM, Afternoon is from 12PM to 4:59PM,
Evening is from 5PM to 8:59PM and Night is from 9PM to 4:59AM.
Order the results descending by flight_code.
Required Columns:
    •	flight_code
    •	departure
    •	day_part (Morning is from 5AM to 11:59AM, Afternoon is from 12PM to 4:59PM, Evening is from 5PM to 8:59PM and Night is from 9PM to 4:59AM) */

SELECT flight_code,
       departure,
       CASE
            WHEN HOUR (departure) >= 0 AND HOUR(departure) < 5 THEN 'Night'
            WHEN HOUR(departure) >= 5 AND HOUR(departure) < 12 THEN 'Morning'
            WHEN HOUR(departure) >= 12 AND HOUR(departure) < 17 THEN 'Afternoon'
            WHEN HOUR(departure) >= 17 AND HOUR(departure) < 21 THEN 'Evening'
            ELSE 'Night'
END
AS 'day_part'
    FROM flights
ORDER BY flight_code DESC;