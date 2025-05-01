/* You have been tasked to create the tables in the database by the following models:

   restaurants
   ┌──────────────────────────────────────────────────────────────────────────────────────────────┐
   │ Column Name   │                   Data Type                    │         Constraints         │
   │───────────────│────────────────────────────────────────────────│─────────────────────────────│
   │ id            │ INTEGER (1 to 2,147,483,647)                   │ PRIMARY KEY, AUTO INCREMENT │
   │───────────────┼────────────────────────────────────────────────┼─────────────────────────────│
   │ name          │ A string containing a maximum of 40 characters.│ NULL is NOT permitted.      │
   │               │  Unicode is NOT needed.                        │ UNIQUE values.              │
   │───────────────┼────────────────────────────────────────────────┼─────────────────────────────│
   │ type          │ A string containing a maximum of 40 characters.│ NULL is NOT permitted.      │
   │               │ Unicode is NOT needed.                         │                             │
   │───────────────┼────────────────────────────────────────────────┼─────────────────────────────│
   │ non_stop      │ It can be true or false.                       │ NULL is NOT permitted.      │
   └──────────────────────────────────────────────────────────────────────────────────────────────┘

   offerings
   ┌───────────────┬─────────────────────────────────────────────────────┬─────────────────────────────┐
   │ Column Name   │ Data Type                                           │ Constraints                 │
   ├───────────────┼─────────────────────────────────────────────────────┼─────────────────────────────┤
   │ id            │ Integer, from 1 to 2,147,483,647.                   │ Primary Key                 │
   │               │                                                     │ AUTO_INCREMENT              │
   ├───────────────┼─────────────────────────────────────────────────────┼─────────────────────────────┤
   │ name          │ A string containing a maximum of 40 characters.     │ NULL is NOT permitted.      │
   │               │ Unicode is NOT needed.                              │ UNIQUE values.              │
   ├───────────────┼─────────────────────────────────────────────────────┼─────────────────────────────┤
   │ price         │ DECIMAL, up to 19 digits,                           │ NULL is NOT permitted.      │
   │               │  2 of which are after the decimal point.            │                             │
   ├───────────────┼─────────────────────────────────────────────────────┼─────────────────────────────┤
   │ vegan         │ It can be true or false.                            │ NULL is NOT permitted.      │
   ├───────────────┼─────────────────────────────────────────────────────┼─────────────────────────────┤
   │ restaurant_id │ Integer, from 1 to 2,147,483,647.                   │ Relationship with table     │
   │               │                                                     │ restaurants.                │
   │               │                                                     │ NULL is NOT permitted.      │
   └───────────────┴─────────────────────────────────────────────────────┴─────────────────────────────┘
 */

 CREATE TABLE restaurants ();