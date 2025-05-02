/* The Summer Olympics Database needs to hold information about countries, sports, disciplines, athletes, and medals.
Your task is to create a database called summer_olympics. Then you will have to create several tables.
    •	countries – contains information about the countries.
    •	sports – contains information about the sports.
    •	disciplines – contains information about the disciplines.
        o	Each discipline has a sport.
    •	athletes – contains information about the athletes.
        o	Each athlete has a country.
    •	medals – contains information about the medals.
    •	disciplines_athletes_medals - a many-to-many mapping table between the disciplines, athletes and medals.
        o	Each athlete has disciplines and medals. An athlete can win a different medal in different disciplines, but not multiple medals in the same discipline.
    o	No two athletes can win the same type of medal (e.g., gold, silver, bronze) in the same discipline. Only one medal of each type can be awarded per discipline!

    ┌───────────────────────────────────────────────────────────────────────────────────────────┐
    │                                        Countries                                          │
    ├───────────────┬──────────────────────────────────────────────────┬────────────────────────┤
    │  Column Name  │                    Data Type                     │ Constraints            │
    ├───────────────┼──────────────────────────────────────────────────┼────────────────────────┤
    │ id            │ Integer, from 1 to 2,147,483,647.                │ Primary Key            │
    │               │                                                  │ AUTO_INCREMENT         │
    ├───────────────┼──────────────────────────────────────────────────┼────────────────────────┤
    │ name          │ A string containing a maximum of 40 characters.  │ NULL is NOT permitted. │
    │               │ Unicode is NOT needed.                           │ UNIQUE values.         │
    └───────────────┴──────────────────────────────────────────────────┴────────────────────────┘
    ┌───────────────────────────────────────────────────────────────────────────────────────────┐
    │                                        Sports                                             │
    ├───────────────┬──────────────────────────────────────────────────┬────────────────────────┤
    │  Column Name  │                    Data Type                     │ Constraints            │
    ├───────────────┼──────────────────────────────────────────────────┼────────────────────────┤
    │ id            │ Integer, from 1 to 2,147,483,647.                │ Primary Key            │
    │               │                                                  │ AUTO_INCREMENT         │
    ├───────────────┼──────────────────────────────────────────────────┼────────────────────────┤
    │ name          │ A string containing a maximum of 40 characters.  │ NULL is NOT permitted. │
    │               │ Unicode is NOT needed.                           │ UNIQUE values.         │
    └───────────────┴──────────────────────────────────────────────────┴────────────────────────┘
    ┌───────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                       Disciplines                                                 │
    ├───────────────┬──────────────────────────────────────────────────┬────────────────────────────────┤
    │  Column Name  │                    Data Type                     │ Constraints                    │
    ├───────────────┼──────────────────────────────────────────────────┼────────────────────────────────┤
    │ id            │ Integer, from 1 to 2,147,483,647.                │ Primary Key                    │
    │               │                                                  │ AUTO_INCREMENT                 │
    ├───────────────┼──────────────────────────────────────────────────┼────────────────────────────────┤
    │ name          │ A string containing a maximum of 40 characters.  │ NULL is NOT permitted.         │
    │               │ Unicode is NOT needed.                           │ UNIQUE values.                 │
    ├───────────────┼──────────────────────────────────────────────────┼────────────────────────────────┤
    │ sport_id      │ Integer, from 1 to 2,147,483,647.                │ Relationship with table sports.│
    │               │                                                  │ NULL is NOT permitted          │
    └───────────────┴──────────────────────────────────────────────────┴────────────────────────────────┘
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                               Athletes                                                 │
    ├───────────────┬─────────────────────────────────────────────────┬──────────────────────────────────────┤
    │  Column Name  │                   Data Type                     │              Constraints             │
    ├───────────────┼─────────────────────────────────────────────────┼──────────────────────────────────────┤
    │ id            │ Integer, from 1 to 2,147,483,647.               │ Primary Key                          │
    │               │                                                 │ AUTO_INCREMENT                       │
    ├───────────────┼─────────────────────────────────────────────────┼──────────────────────────────────────┤
    │ first_name    │ A string containing a maximum of 40 characters. │ NULL is NOT permitted.               │
    │               │ Unicode is NOT needed.                          │                                      │                                      │
    ├───────────────┼─────────────────────────────────────────────────┼──────────────────────────────────────┤
    │ last_name     │ A string containing a maximum of 40 characters. │ NULL is NOT permitted.               │
    │               │ Unicode is NOT needed.                          │                                      │                                      │
    ├───────────────┼─────────────────────────────────────────────────┼──────────────────────────────────────┤
    │ age           │ Integer, from 1 to 2,147,483,647.               │ NULL is NOT permitted.               │
    ├───────────────┼─────────────────────────────────────────────────┼──────────────────────────────────────┤
    │ country_id    │ Integer, from 1 to 2,147,483,647.               │ Relationship with table countries.   │
    │               │                                                 │ NULL is NOT permitted                │
    └───────────────┴─────────────────────────────────────────────────┴──────────────────────────────────────┘
    ┌───────────────────────────────────────────────────────────────────────────────────────────┐
    │                                        Medals                                             │
    ├───────────────┬──────────────────────────────────────────────────┬────────────────────────┤
    │  Column Name  │                    Data Type                     │       Constraints      │
    ├───────────────┼──────────────────────────────────────────────────┼────────────────────────┤
    │ id            │ Integer, from 1 to 2,147,483,647.                │ Primary Key            │
    │               │                                                  │ AUTO_INCREMENT         │
    ├───────────────┼──────────────────────────────────────────────────┼────────────────────────┤
    │ type          │ A string containing a maximum of 10 characters.  │ NULL is NOT permitted. │
    │               │ Unicode is NOT needed.                           │ UNIQUE values.         │
    └───────────────┴──────────────────────────────────────────────────┴────────────────────────┘


    ┌─────────────────────────────────────────────────────────────────────────────────────────┐
    │                                  disciplines_athletes_medals                            │
    ├───────────────┬──────────────────────────────────┬──────────────────────────────────────┤
    │  Column Name  │            Data Type             │             Constraints              │
    ├───────────────┼──────────────────────────────────┼──────────────────────────────────────┤
    │ discipline_id │ Integer, from 1 to 2,147,483,647.│ Relationship with table disciplines. │
    │               │                                  │ NULL is NOT permitted.               │
    ├───────────────┼──────────────────────────────────┼──────────────────────────────────────┤
    │ athlete_id    │ Integer, from 1 to 2,147,483,647.│ Relationship with table athletes.    │
    │               │                                  │ NULL is NOT permitted                │
    ├───────────────┼──────────────────────────────────┼──────────────────────────────────────┤
    │ medal_id      │ Integer, from 1 to 2,147,483,647.│ Relationship with table medals.      │
    │               │                                  │ NULL is NOT permitted                │
    └───────────────┴──────────────────────────────────┴──────────────────────────────────────┘
 */