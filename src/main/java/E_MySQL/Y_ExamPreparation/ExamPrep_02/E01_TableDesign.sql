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
    │               │ Unicode is NOT needed.                          │                                      │
    ├───────────────┼─────────────────────────────────────────────────┼──────────────────────────────────────┤
    │ last_name     │ A string containing a maximum of 40 characters. │ NULL is NOT permitted.               │
    │               │ Unicode is NOT needed.                          │                                      │
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

CREATE TABLE countries(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(40) CHARACTER SET ASCII NOT NULL UNIQUE
);

CREATE TABLE sports(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) CHARACTER SET ASCII NOT NULL UNIQUE
);

CREATE TABLE disciplines(
    id iNT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(40) CHARACTER SET ASCII NOT NULL UNIQUE,
    sport_id INT NOT NULL,
    CONSTRAINT fk_disciplines_sport_id_sports_id
        FOREIGN KEY (sport_id)
            REFERENCES sports(id)
);

CREATE TABLE athletes(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(40) CHARACTER SET ASCII NOT NULL,
    last_name VARCHAR(40) CHARACTER SET ASCII NOT NULL,
    age INT NOT NULL,
    country_id INT NOT NULL,
    CONSTRAINT fk_athletes_country_id_countries_id
        FOREIGN KEY (country_id)
            REFERENCES countries(id)
);

CREATE TABLE medals (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(10) CHARACTER SET ASCII NOT NULL UNIQUE
);

CREATE TABLE disciplines_athletes_medals (
    discipline_id INT NOT NULL,
    athlete_id INT NOT NULL,
    medal_id INT NOT NULL,
    PRIMARY KEY (discipline_id, medal_id),
    CONSTRAINT fk_discipline_id_disciplines_id
        FOREIGN KEY (discipline_id)
            REFERENCES disciplines(id),
    CONSTRAINT fk_athlete_id_athletes_id
        FOREIGN KEY (athlete_id)
            REFERENCES athletes(id),
    CONSTRAINT fk_medal_id_medals_id
        FOREIGN KEY (medal_id)
            REFERENCES medals(id),
);