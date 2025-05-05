/* You have been tasked to create the tables in the database by the following models:
  ┌────────────────────────────────────────────────────────────────────────────────────────────────────────┐
  │                                                Countries                                               │
  ├───────────────┬─────────────────────────────────────────────────┬──────────────────────────────────────┤
  │  Column Name  │                   Data Type                     │              Constraints             │
  ├───────────────┼─────────────────────────────────────────────────┼──────────────────────────────────────┤
  │ id            │ Integer, from 1 to 2,147,483,647.               │ Primary Key                          │
  │               │                                                 │ AUTO_INCREMENT                       │
  ├───────────────┼─────────────────────────────────────────────────┼──────────────────────────────────────┤
  │ name          │ A string containing a maximum of 30 characters. │ NULL is NOT permitted.               │
  │               │ Unicode is NOT needed.                          │ UNIQUE values.                       │
  ├───────────────┼─────────────────────────────────────────────────┼──────────────────────────────────────┤
  │ description   │ A very long string field                        │                                      │
  ├───────────────┼─────────────────────────────────────────────────┼──────────────────────────────────────┤
  │ currency      │ A string containing a maximum of 5 characters.  │ NULL is NOT permitted                │
  │               │ Unicode is NOT needed.                          │                                      │
  └───────────────┴─────────────────────────────────────────────────┴──────────────────────────────────────┘
  ┌─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
  │                                                       Airplanes                                                         │
  ├─────────────────────┬──────────────────────────────────────────────────────────────────┬────────────────────────────────┤
  │    Column Name      │                         Data Type                                │          Constraints           │
  ├─────────────────────┼──────────────────────────────────────────────────────────────────┼────────────────────────────────┤
  │ id                  │ Integer, from 1 to 2,147,483,647.                                │ Primary Key                    │
  │                     │                                                                  │ AUTO_INCREMENT                 │
  ├─────────────────────┼──────────────────────────────────────────────────────────────────┼────────────────────────────────┤
  │ model               │ A string containing a maximum of 50 characters.                  │ NULL is NOT permitted.         │
  │                     │ Unicode is NOT needed.                                           │ UNIQUE values.                 │
  ├─────────────────────┼──────────────────────────────────────────────────────────────────┼────────────────────────────────┤
  │ passengers_capacity │ Integer, from 1 to 2,147,483,647.                                │ NULL is NOT permitted.         │
  │                     │ NULL is NOT permitted.                                           │                                │
  ├─────────────────────┼──────────────────────────────────────────────────────────────────┼────────────────────────────────┤
  │ tank_capacity       │ DECIMAL, up to 19 digits, 2 of which are after the decimal point.│ NULL is NOT permitted.         │
  ├─────────────────────┼──────────────────────────────────────────────────────────────────┼────────────────────────────────┤
  │ cost                │ DECIMAL, up to 19 digits, 2 of which are after the decimal point.│ NULL is NOT permitted.         │
  └─────────────────────┴──────────────────────────────────────────────────────────────────┴────────────────────────────────┘
  ┌─────────────────────────────────────────────────────────────────────────────────────────────────────────┐
  │                                               Passengers                                                │
  ├───────────────┬────────────────────────────────────────────────────┬────────────────────────────────────┤
  │ Column Name   │ Data Type                                          │ Constraints                        │
  ├───────────────┼────────────────────────────────────────────────────┼────────────────────────────────────┤
  │ id            │ Integer, from 1 to 2,147,483,647.                  │ Primary Key                        │
  │               │                                                    │ AUTO_INCREMENT                     │
  ├───────────────┼────────────────────────────────────────────────────┼────────────────────────────────────┤
  │ first_name    │ A string containing a maximum of 30 characters.    │ NULL is NOT permitted.             │
  │               │ Unicode is NOT needed.                             │                                    │
  ├───────────────┼────────────────────────────────────────────────────┼────────────────────────────────────┤
  │ last_name     │ A string containing a maximum of 30 characters.    │ NULL is NOT permitted.             │
  │               │ Unicode is NOT needed.                             │                                    │
  ├───────────────┼────────────────────────────────────────────────────┼────────────────────────────────────┤
  │ country_id    │ Integer, from 1 to 2,147,483,647.                  │ Relationship with table countries. │
  │               │                                                    │ NULL is NOT permitted.             │
  └───────────────┴────────────────────────────────────────────────────┴────────────────────────────────────┘
  ┌─────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
  │                                                    Flights                                                  │
  ├─────────────────────┬───────────────────────────────────────────────────┬───────────────────────────────────┤
  │     Column Name     │                   Data Type                       │            Constraints            │
  ├─────────────────────┼───────────────────────────────────────────────────┼───────────────────────────────────┤
  │ id                  │ Integer, from 1 to 2,147,483,647.                 │ Primary Key                       │
  │                     │                                                   │ AUTO_INCREMENT                    │
  ├─────────────────────┼───────────────────────────────────────────────────┼───────────────────────────────────┤
  │ flight_code         │ A string containing a maximum of 30 characters.   │ NULL is NOT permitted.            │
  │                     │ Unicode is NOT needed.                            │ UNIQUE values.                    │
  ├─────────────────────┼───────────────────────────────────────────────────┼───────────────────────────────────┤
  │ departure_country   │ Integer, from 1 to 2,147,483,647.                 │ Relationship with table countries.│
  │                     │                                                   │ NULL is NOT permitted.            │
  ├─────────────────────┼───────────────────────────────────────────────────┼───────────────────────────────────┤
  │ destination_country │ Integer, from 1 to 2,147,483,647.                 │ Relationship with table countries.│
  │                     │                                                   │ NULL is NOT permitted.            │
  ├─────────────────────┼───────────────────────────────────────────────────┼───────────────────────────────────┤
  │ airplane_id         │ Integer, from 1 to 2,147,483,647.                 │ Relationship with table airplanes.│
  │                     │                                                   │ NULL is NOT permitted.            │
  ├─────────────────────┼───────────────────────────────────────────────────┼───────────────────────────────────┤
  │ has_delay           │ Can be true or false.                             │                                   │
  ├─────────────────────┼───────────────────────────────────────────────────┼───────────────────────────────────┤
  │ departure           │ The date and time of the departure.               │                                   │
  └─────────────────────┴───────────────────────────────────────────────────┴───────────────────────────────────┘
  ┌──────────────────────────────────────────────────────────────────────────────────────────┐
  │                                     flights_passengers                                   │
  ├───────────────┬─────────────────────────────────────┬────────────────────────────────────┤
  │  Column Name  │              Data Type              │            Constraints             │
  ├───────────────┼─────────────────────────────────────┼────────────────────────────────────┤
  │ flight_id     │ Integer, from 1 to 2,147,483,647.   │ Relationship with table flights.   │
  ├───────────────┼─────────────────────────────────────┼────────────────────────────────────┤
  │ passenger_id  │ Integer, from 1 to 2,147,483,647.   │ Relationship with table passengers.│
  └───────────────┴─────────────────────────────────────┴────────────────────────────────────┘

Submit your solutions in Judge on the first task. Submit all SQL table creation statements. You will also be given a data.sql file.
It will contain a dataset with random data which you will need to store in your local database.
This data will be given to you so you will not have to think of data and lose essential time in the process.
The data is in the form of INSERT statement queries. */