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

CREATE TABLE countries(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) CHARACTER SET ASCII NOT NULL UNIQUE,
    description TEXT,
    currency VARCHAR(5) CHARACTER SET ASCII NOT NULL
);

CREATE TABLE airplanes(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    model VARCHAR(50) CHARACTER SET ASCII NOT NULL UNIQUE,
    passengers_capacity INT NOT NULL,
    tank_capacity DECIMAL (19, 2) NOT NULL,
    cost DECIMAL (19, 2) NOT NULL
);

CREATE TABLE passengers (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(30) CHARACTER SET ASCII NOT NULL,
    last_name VARCHAR(30) CHARACTER SET ASCII NOT NULL,
    country_id INT NOT NULL,
    CONSTRAINT fk_tbpassengers_country_id_tbcountries_id
        FOREIGN KEY (country_id)
            REFERENCES countries(id)
);

CREATE TABLE flights (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    flight_code VARCHAR(30) CHARACTER SET ASCII NOT NULL UNIQUE,
    departure_country INT NOT NULL,
    destination_country INT NOT NULL,
    airplane_id INT NOT NULL,
    has_delay BOOL,
    departure DATETIME,
    CONSTRAINT fk_tbflights_departure_country_tbcountries_id
        FOREIGN KEY (departure_country)
            REFERENCES countries(id),
    CONSTRAINT fk_tbflights_destination_country_tbcountries_id
        FOREIGN KEY (destination_country)
            REFERENCES countries(id),
    CONSTRAINT fk_tbflights_airplane_id_tbairplanes_id
        FOREIGN KEY (airplane_id)
            REFERENCES airplanes(id)
);

CREATE TABLE flights_passengers(
    flight_id INT,
    passenger_id INT,
    CONSTRAINT fk_tbflights_passengers_flight_id_tbflights_id
        FOREIGN KEY (flight_id)
            REFERENCES flights(id),
    CONSTRAINT fk_tbflights_passengers_passenger_id_tbpassengers_id
        FOREIGN KEY (passenger_id)
            REFERENCES passengers(id)
);

INSERT INTO countries (name, currency, description) VALUES
    ('Kazakhstan', 'KZT', 'Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem. Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat. Praesent blandit.'),
    ('Mexico', 'MXN', 'Sed accumsan felis. Ut at dolor quis odio consequat varius. Integer ac leo. Pellentesque ultrices mattis odio. Donec vitae nisi. Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus.'),
    ('France', 'EUR', 'Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque. Duis bibendum. Morbi non quam nec dui luctus rutrum. Nulla tellus. In sagittis dui vel nisl. Duis ac nibh.'),
    ('Philippines', 'PHP', 'Aenean auctor gravida sem. Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo. Morbi ut odio. Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim.'),
    ('Peru', 'PEN', 'Etiam pretium iaculis justo. In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus. Nulla ut erat id mauris vulputate elementum.'),
    ('Greece', 'EUR', 'Vivamus tortor. Duis mattis egestas metus. Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh.'),
    ('Finland', 'EUR', 'Aenean sit amet justo. Morbi ut odio. Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim.'),
    ('Canada', 'CAD', 'In quis justo.'),
    ('Thailand', 'THB', 'Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede. Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem. Fusce consequat. Nulla nisl. Nunc nisl. Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum.'),
    ('Venezuela', 'VEF', 'Aliquam erat volutpat. In congue. Etiam justo. Etiam pretium iaculis justo. In hac habitasse platea dictumst. Etiam faucibus cursus urna.'),
    ('Indonesia', 'IDR', 'Suspendisse potenti. Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum. Aliquam non mauris. Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis. Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl.'),
    ('Mongolia', 'MNT', 'Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero. Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh. In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet. Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam.'),
    ('Argentina', 'ARS', 'Vestibulum rutrum rutrum neque. Aenean auctor gravida sem. Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo. Morbi ut odio. Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim.'),
    ('Bosnia and Herzegovina', 'BAM', 'Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque. Quisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus.'),
    ('Ukraine', 'UAH', 'Aenean auctor gravida sem. Praesent id massa id nisl venenatis lacinia.'),
    ('El Salvador', 'USD', 'Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo. Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros. Suspendisse accumsan tortor quis turpis.'),
    ('Czech Republic', 'CZK', 'Morbi a ipsum. Integer a nibh. In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet. Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo.'),
    ('Morocco', 'MAD', 'Phasellus in felis. Donec semper sapien a libero.'),
    ('United States', 'USD', 'In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus. Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst. Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem.'),
    ('Afghanistan', 'AFN', 'Curabitur in libero ut massa volutpat convallis. Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo. Maecenas pulvinar lobortis est. Phasellus sit amet erat. Nulla tempus. Vivamus in felis eu sapien cursus vestibulum.'),
    ('Armenia', 'AMD', 'Sed accumsan felis. Ut at dolor quis odio consequat varius. Integer ac leo. Pellentesque ultrices mattis odio. Donec vitae nisi. Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus. Curabitur at ipsum ac tellus semper interdum. Mauris ullamcorper purus sit amet nulla.'),
    ('Germany', 'EUR', 'Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus. Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst. Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem.'),
    ('Colombia', 'COP', 'Nunc purus. Phasellus in felis. Donec semper sapien a libero. Nam dui. Proin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis. Ut at dolor quis odio consequat varius. Integer ac leo. Pellentesque ultrices mattis odio.'),
    ('Guatemala', 'GTQ', 'Vivamus tortor. Duis mattis egestas metus. Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh. Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros. Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue.'),
    ('Uzbekistan', 'UZS', 'Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem. Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat. Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede. Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.'),
    ('Iran', 'IRR', 'Cras in purus eu magna vulputate luctus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.'),
    ('China', 'CNY', 'Donec semper sapien a libero. Nam dui. Proin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis. Ut at dolor quis odio consequat varius.'),
    ('Syria', 'SYP', 'In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem. Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit. Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque. Duis bibendum. Morbi non quam nec dui luctus rutrum.'),
    ('Poland', 'PLN', 'Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.'),
    ('Slovenia', 'EUR', 'Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus. Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst.'),
    ('Brazil', 'BRL', 'Etiam pretium iaculis justo. In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus. Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi.'),
    ('Italy', 'EUR', 'Ut tellus. Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi. Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque. Quisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus.'),
    ('Nigeria', 'NGN', 'Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat. In congue. Etiam justo. Etiam pretium iaculis justo.'),
    ('Mauritius', 'MUR', 'In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus. Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi. Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit.');

INSERT INTO airplanes (model, passengers_capacity, tank_capacity, cost) VALUES
    ('Airbus A220', 775, 20958.00, 133.94), ('Airbus A320', 413, 36980.00, 127.40), ('Airbus A330', 475, 26141.00, 85.80),
    ('Airbus A350 XWB', 736, 7342.00, 83.67), ('Antonov An-148/An-158', 547, 34643.00, 133.94), ('Boeing 737', 496, 32400.00, 135.98),
    ('Boeing 747', 470, 7110.00, 98.44), ('Boeing 767', 550, 24458.00, 139.36), ('Boeing 777', 226, 9128.00, 136.25),
    ('Boeing 787 Dreamliner', 213, 8175.00, 130.80), ('Comac ARJ21 Xiangfeng', 222, 17515.00, 80.38), ('Embraer E-Jet E2 family', 465, 24973.00, 138.34),
    ('Irkut MC-21', 301, 37530.00, 138.68), ('Mitsubishi SpaceJet', 371, 12594.00, 81.46), ('Sukhoi Superjet SSJ100', 283, 12688.00, 126.64),
    ('Tupolev Tu-204/Tu-214', 203, 14339.00, 131.78);

INSERT INTO passengers (first_name, last_name, country_id) VALUES
    ('Daniela', 'Paulot', 4), ('Walliw', 'Luty', 12), ('Ernst', 'Grenshiels', 5),
    ('Gus', 'Porrett', 28), ('Elfrieda', 'Shaefer', 6), ('Amity', 'Wilstead', 5),
    ('Angel', 'Saines', 32), ('Lannie', 'Koeppe', 7), ('Gloriana', 'Drennan', 1),
    ('Tanner', 'Valentim', 23), ('Lissi', 'Phittiplace', 4), ('Traci', 'Tolotti', 19),
    ('Brigida', 'Giacomo', 19), ('Dermot', 'Abbe', 15), ('Adrea', 'Paulsson', 26),
    ('Michaelina', 'Decker', 33), ('Willamina', 'Autie', 1), ('Bethany', 'Blackaller', 30),
    ('Miof mela', 'Strotone', 13), ('Winona', 'Devin', 19), ('Stacy', 'Taberner', 21),
    ('Clara', 'Dutch', 35), ('Brocky', 'O'' Finan', 33), ('Alidia', 'Kleewein', 34),
    ('Zaneta', 'Vivash', 1), ('Karilynn', 'Gerok', 1), ('Hussein', 'Tenaunt', 29),
    ('Ophelie', 'Lineham', 13), ('Leonelle', 'Gatenby', 34), ('Trudy', 'McGrirl', 22),
    ('Susanna', 'Raynor', 4), ('Bobby', 'Du Barry', 2), ('Ginnie', 'Slesser', 6),
    ('Abrahan', 'Glennie', 20), ('Norri', 'Gerrets', 23), ('Marc', 'Petschelt', 23),
    ('Clayborn', 'Erb', 18), ('Eddi', 'Filyukov', 28), ('Christie', 'Goaley', 32),
    ('Martguerita', 'Wace', 32), ('Niels', 'Barizeret', 33), ('Babbette', 'Middlemass', 24),
    ('Diannne', 'Shiril', 16), ('Kerk', 'Jouhan', 21), ('Nero', 'Lovelady', 9),
    ('Glen', 'Figin', 5), ('Luther', 'Cardenas', 11), ('Lucita', 'Carnoghan', 4),
    ('Noel', 'Lyston', 18), ('Adorne', 'Hughs', 5), ('Karin', 'Sargerson', 7),
    ('Xaviera', 'Doniso', 12), ('Kristopher', 'Clymer', 25), ('Drucy', 'Lambswood', 3),
    ('Morganica', 'Algore', 35), ('Candida', 'Twist', 17), ('Zedekiah', 'Kos', 29),
    ('Alida', 'McLise', 7), ('Henriette', 'Spacy', 21), ('Theadora', 'Goodreid', 1),
    ('Stephanie', 'California', 18), ('Albertine', 'Stuckes', 29), ('Revkah', 'Chinn', 33),
    ('Concordia', 'Routledge', 19), ('Shirlene', 'Jacobovitz', 17), ('Ruthe', 'Care', 26),
    ('Ellis', 'Tuley', 32), ('Nicolina', 'Manes', 17), ('Cassy', 'Jarmyn', 18),
    ('Blair', 'Hernik', 19), ('Ferguson', 'McCloy', 34), ('Ellyn', 'Agerskow', 30),
    ('Barbe', 'Moynihan', 11), ('Gary', 'Jefford', 35), ('Nell', 'Farge', 22),
    ('Shelden', 'McNamara', 30), ('Brena', 'O''Doran', 26), ('Erhard', 'Hollyar', 5),
    ('Ericka', 'Jales', 18), ('Mathew', 'Tallowin', 22), ('Pam', 'Puddefoot', 10),
    ('Leroy', 'Harriskine', 24), ('Genvieve', 'Stockoe', 5), ('Ronna', 'Meddick', 5),
    ('Rodrigo', 'Connors', 5), ('Lucia', 'Flegg', 11), ('Dag', 'Gaudon', 29),
    ('Rickey', 'Rowett', 33), ('Ned', 'Illiston', 6), ('West', 'Motto', 23),
    ('Abbey', 'Hauxwell', 25), ('Faustine', 'Greatorex', 32), ('Osborne', 'Hugin', 31),
    ('Budd', 'Pelman', 24), ('Mariejeanne', 'Cantwell', 21), ('Steffen', 'Pemberton', 24),
    ('Dannye', 'Rikard', 15), ('Myrwyn', 'Beet', 24), ('Kendal', 'Cusack', 33),
    ('Charla', 'Cooke', 30);

INSERT INTO flights (flight_code, departure_country, destination_country, airplane_id, has_delay, departure) VALUES
    ('YZ-430', 29, 30, 7, 0, '2023-08-31 07:17:32'), ('MI-603', 10, 13, 12, 1, '2022-11-16 13:31:29'),
    ('QY-625', 7, 13, 3, 1, '2021-12-06 00:59:45'), ('LY-430', 19, 19, 2, 1, '2022-12-13 16:36:06'),
    ('ZP-782', 20, 10, 13, 0, '2022-08-11 16:32:39'), ('ZJ-280', 35, 4, 4, 0, '2023-05-19 16:54:38'),
    ('BA-910', 18, 7, 2, 0, '2022-03-26 20:05:43'), ('RL-102', 27, 34, 12, 1, '2023-07-22 11:33:11'),
    ('EA-907', 20, 33, 6, 0, '2023-07-10 21:15:57'), ('XY-389', 12, 7, 12, 1, '2022-04-27 00:51:17'),
    ('OK-712', 30, 4, 3, 1, '2023-05-20 08:28:09'), ('JN-857', 32, 12, 6, 0, '2022-05-09 23:25:44'),
    ('DP-070', 19, 2, 2, 0, '2022-05-17 00:28:14'), ('HM-237', 4, 24, 2, 0, '2022-08-18 01:38:08'),
    ('CQ-548', 15, 4, 7, 1, '2022-12-14 16:52:07'), ('HE-352', 5, 28, 7, 1, '2023-02-01 08:29:56'),
    ('TU-095', 1, 8, 13, 1, '2023-07-04 10:34:29'), ('VX-845', 19, 6, 8, 1, '2022-06-08 16:34:49'),
    ('NY-218', 16, 21, 13, 0, '2022-09-15 02:48:26'), ('OC-643', 10, 22, 8, 1, '2023-04-06 11:53:07'),
    ('FT-863', 18, 28, 11, 0, '2023-04-03 08:42:52'), ('IR-264', 8, 23, 2, 1, '2022-04-25 19:56:40'),
    ('BY-814', 6, 27, 10, 1, '2023-01-11 06:11:05'), ('DL-661', 28, 24, 6, 0, '2021-12-11 15:02:11'),
    ('BG-702', 17, 32, 4, 1, '2023-04-19 02:21:00'), ('DK-663', 10, 35, 11, 1, '2022-05-12 12:50:25'),
    ('VI-897', 6, 16, 7, 1, '2022-10-20 06:07:52'), ('HQ-369', 27, 33, 16, 0, '2023-01-29 02:13:08'),
    ('AU-013', 24, 16, 8, 0, '2022-10-10 07:51:31'), ('ZT-264', 22, 11, 15, 1, '2023-08-10 08:18:37'),
    ('AS-371', 12, 21, 8, 0, '2022-08-11 08:07:08'), ('MN-744', 24, 33, 12, 1, '2022-04-07 13:14:30'),
    ('QC-472', 15, 13, 11, 0, '2023-03-28 17:30:32'), ('LS-349', 3, 3, 3, 0, '2023-03-09 03:47:32'),
    ('KW-382', 21, 25, 2, 0, '2022-10-29 14:11:14'), ('HQ-906', 4, 14, 8, 0, '2023-07-28 19:26:51'),
    ('TK-783', 8, 25, 4, 0, '2023-08-26 19:09:37'), ('IL-082', 34, 19, 2, 1, '2023-01-14 02:48:36'),
    ('BJ-654', 34, 13, 16, 1, '2023-10-07 11:07:58'), ('FT-260', 27, 35, 16, 0, '2021-12-09 04:44:40'),
    ('RC-434', 35, 14, 9, 1, '2022-07-23 22:38:58'), ('CQ-504', 23, 21, 8, 1, '2022-03-10 21:02:09'),
    ('ZN-100', 4, 9, 16, 0, '2023-02-02 05:58:04'), ('QN-810', 29, 27, 11, 1, '2022-03-22 07:47:15'),
    ('AH-536', 3, 33, 10, 1, '2022-07-22 23:49:38'), ('YH-358', 32, 23, 5, 0, '2022-04-18 08:52:00'),
    ('DF-729', 5, 10, 11, 0, '2022-04-09 22:55:42'), ('XY-018', 3, 27, 16, 0, '2022-08-30 19:43:56'),
    ('VJ-242', 30, 27, 15, 1, '2022-03-12 18:22:22'), ('TT-432', 4, 20, 16, 0, '2023-01-25 12:53:05'),
    ('HK-249', 6, 20, 10, 0, '2023-05-15 09:41:54'), ('JE-304', 25, 34, 12, 1, '2023-03-14 20:53:22'),
    ('BX-118', 17, 17, 14, 0, '2021-11-11 09:52:10'), ('PR-948', 32, 32, 13, 1, '2022-10-11 17:14:54'),
    ('VI-209', 6, 25, 4, 0, '2023-07-31 16:22:16'), ('RN-108', 21, 17, 2, 0, '2023-04-24 12:56:15'),
    ('ZB-158', 19, 15, 3, 1, '2023-01-30 02:53:38'), ('NI-862', 1, 31, 16, 0, '2022-06-08 13:54:25'),
    ('MK-493', 10, 2, 10, 0, '2023-06-14 21:46:52'), ('KU-493', 11, 18, 4, 0, '2023-01-23 16:20:18'),
    ('LU-724', 10, 26, 4, 1, '2021-12-25 18:39:30'), ('TH-260', 14, 35, 9, 0, '2023-09-16 07:08:38'),
    ('PN-119', 26, 9, 6, 1, '2023-01-22 22:36:44'), ('ID-276', 34, 8, 11, 1, '2023-03-01 00:58:36'),
    ('PB-114', 22, 15, 5, 0, '2022-12-13 04:17:36'), ('KI-774', 22, 11, 3, 1, '2022-11-16 14:38:58'),
    ('KU-684', 3, 1, 3, 1, '2022-02-28 08:29:52'), ('JM-290', 29, 34, 11, 1, '2023-08-23 18:35:30'),
    ('SP-621', 30, 7, 2, 0, '2023-01-10 16:52:34'), ('TQ-989', 28, 3, 2, 1, '2022-12-07 17:50:44'),
    ('QS-259', 13, 29, 4, 0, '2023-10-01 10:45:54'), ('YW-624', 16, 6, 8, 0, '2022-03-30 22:12:56'),
    ('LX-013', 15, 16, 4, 0, '2023-01-10 23:39:44'), ('IQ-046', 4, 15, 3, 0, '2022-04-15 11:54:09'),
    ('KG-884', 11, 29, 13, 0, '2022-08-25 07:16:28'), ('NB-135', 11, 32, 12, 0, '2022-09-30 22:20:21'),
    ('NX-889', 33, 30, 12, 1, '2023-08-06 09:14:12'), ('WW-522', 23, 11, 3, 0, '2022-03-09 04:14:24'),
    ('GO-923', 32, 29, 8, 1, '2023-03-17 01:57:12'), ('OP-805', 24, 23, 9, 1, '2023-03-12 01:49:53'),
    ('UM-065', 29, 28, 10, 0, '2022-10-04 12:01:16'), ('HX-210', 33, 11, 11, 1, '2021-11-24 18:02:16'),
    ('UE-343', 13, 16, 7, 0, '2023-04-14 19:10:59'), ('JE-869', 4, 7, 3, 0, '2022-09-21 04:56:12'),
    ('GP-271', 30, 12, 8, 0, '2023-01-09 18:50:03'), ('AN-190', 10, 13, 10, 1, '2022-12-21 03:55:26'),
    ('GB-191', 22, 6, 10, 0, '2022-06-12 04:33:54'), ('AB-776', 33, 32, 7, 1, '2022-10-22 20:48:40'),
    ('VW-619', 30, 33, 10, 0, '2022-06-28 17:08:07'), ('YC-028', 27, 30, 7, 1, '2022-05-24 19:25:55'),
    ('XT-969', 16, 28, 11, 1, '2022-01-22 17:36:07'), ('QN-187', 7, 2, 12, 1, '2023-10-06 07:35:10'),
    ('JT-072', 1, 30, 11, 0, '2022-11-07 04:44:24'), ('QO-163', 32, 7, 8, 1, '2023-05-20 20:37:10'),
    ('NW-347', 11, 20, 13, 0, '2022-11-17 09:27:58'), ('QJ-807', 33, 19, 11, 1, '2023-10-15 20:22:55'),
    ('QM-740', 12, 1, 12, 0, '2023-04-15 17:41:45'), ('QX-657', 30, 21, 6, 1, '2023-05-08 21:23:14'),
    ('UC-831', 2, 5, 13, 1, '2022-12-08 08:07:32'), ('LF-479', 4, 11, 7, 0, '2023-09-04 07:48:49');

INSERT INTO flights_passengers (flight_id, passenger_id) VALUES
    (1, 46), (1, 80), (1, 100), (2, 3), (2, 32), (2, 59), (2, 88), (3, 28), (3, 38), (3, 59),
    (3, 76), (3, 81), (3, 92), (4, 2), (4, 17), (4, 40), (4, 41), (4, 53), (4, 53), (4, 56),
    (4, 57), (4, 64), (4, 80), (4, 88), (5, 10), (5, 15), (5, 46), (5, 50), (6, 11), (6, 25),
    (6, 42), (6, 60), (6, 86), (7, 37), (7, 44), (7, 46), (7, 63), (7, 67), (8, 20), (8, 20),
    (8, 56), (8, 63), (8, 89), (8, 92), (9, 34), (9, 40), (9, 44), (9, 74), (9, 78), (10, 27),
    (10, 64), (10, 85), (11, 24), (11, 24), (11, 81), (12, 2), (12, 9), (12, 16), (12, 22), (12, 36),
    (12, 40), (13, 1), (13, 2), (13, 41), (13, 66), (13, 75), (13, 86), (14, 2), (14, 54), (14, 68),
    (15, 74), (15, 12), (16, 5), (16, 11), (16, 63), (16, 71), (16, 83), (16, 83), (16, 87), (16, 91),
    (16, 100), (17, 2), (17, 10), (17, 11), (17, 22), (17, 30), (17, 30), (17, 60), (17, 86), (17, 87),
    (17, 93), (18, 4), (18, 19), (18, 60), (18, 65), (18, 97), (19, 5), (19, 14), (19, 60), (19, 78),
    (19, 94), (20, 19), (20, 37), (20, 45), (20, 51), (20, 54), (20, 70), (20, 75), (20, 80), (21, 21),
    (21, 36), (21, 80), (21, 94), (21, 94), (21, 96), (22, 17), (22, 38), (22, 60), (22, 62), (23, 2),
    (23, 8), (23, 19), (23, 20), (23, 23), (23, 55), (23, 67), (23, 72), (23, 82), (24, 14), (24, 28),
    (24, 71), (24, 73), (24, 87), (24, 90), (24, 94), (24, 13), (25, 1), (25, 2), (25, 25), (25, 25),
    (25, 41), (25, 42), (25, 49), (25, 86), (26, 5), (26, 19), (26, 23), (26, 51), (26, 94), (27, 31),
    (27, 63), (27, 66), (28, 10), (28, 16), (28, 48), (28, 62), (28, 63), (28, 65), (28, 68), (28, 69),
    (28, 75), (28, 85), (29, 1), (29, 31), (29, 32), (29, 45), (29, 67), (30, 13), (30, 13), (30, 69),
    (30, 85), (30, 85), (30, 97), (31, 2), (31, 12), (31, 15), (31, 40), (32, 31), (32, 84), (33, 5),
    (33, 10), (33, 32), (33, 41), (33, 59), (33, 96), (34, 21), (34, 25), (34, 30), (34, 38), (34, 55),
    (34, 88), (34, 93), (34, 95), (35, 39), (36, 18), (36, 44), (37, 31), (37, 53), (37, 82), (38, 4),
    (38, 14), (38, 15), (38, 18), (38, 68), (39, 6), (39, 12), (39, 16), (39, 25), (39, 31), (39, 69),
    (39, 91), (40, 8), (40, 26), (40, 45), (40, 52), (40, 59), (40, 69), (40, 74), (40, 80), (41, 9),
    (41, 34), (41, 44), (41, 48), (41, 74), (41, 84), (41, 91), (42, 22), (42, 48), (42, 58), (43, 52),
    (43, 74), (43, 78), (43, 77), (43, 84), (43, 87), (44, 2), (44, 39), (44, 51), (44, 54), (44, 54),
    (44, 85), (44, 92), (45, 20), (45, 32), (45, 46), (46, 1), (46, 12), (46, 16), (46, 39), (46, 81),
    (47, 5), (47, 9), (47, 23), (47, 32), (47, 49), (47, 53), (47, 54), (47, 71), (47, 96), (48, 48),
    (48, 70), (48, 83), (49, 2), (49, 11), (49, 49), (49, 77), (50, 31), (50, 34), (50, 37), (50, 46),
    (50, 61), (50, 90), (50, 97), (51, 5), (51, 20), (51, 35), (51, 36), (51, 38), (51, 49), (51, 74),
    (51, 83), (51, 90), (52, 6), (52, 9), (52, 13), (52, 26), (52, 27), (52, 38), (52, 56), (52, 62),
    (52, 66), (52, 95), (53, 11), (53, 14), (53, 80), (54, 12), (54, 13), (54, 32), (54, 38), (55, 10),
    (55, 26), (55, 47), (55, 77), (55, 14), (56, 6), (56, 15), (56, 29), (56, 39), (56, 39), (56, 50),
    (56, 55), (56, 59), (56, 72), (57, 18), (57, 22), (57, 31), (57, 37), (57, 42), (57, 50), (57, 67),
    (57, 74), (57, 100), (58, 11), (58, 59), (58, 29), (58, 80), (58, 99), (59, 30), (59, 32), (59, 49),
    (59, 65), (59, 68), (59, 75), (60, 15), (60, 34), (60, 46), (60, 66), (60, 77), (60, 97), (61, 8),
    (61, 11), (61, 14), (61, 17), (61, 18), (61, 20), (61, 21), (61, 38), (61, 45), (61, 53), (62, 32),
    (62, 44), (62, 83), (63, 6), (63, 12), (63, 23), (63, 47), (63, 81), (63, 94), (64, 4), (64, 68),
    (64, 72), (64, 78), (64, 78), (64, 94), (64, 99), (65, 13), (65, 32), (65, 36), (66, 3), (66, 24),
    (66, 95), (67, 56), (67, 65), (67, 80), (67, 83), (67, 8), (68, 8), (68, 51), (68, 56), (68, 56),
    (69, 39), (69, 39), (69, 83), (70, 42), (70, 45), (70, 53), (70, 67), (70, 97), (71, 30), (72, 8),
    (72, 22), (72, 27), (72, 49), (72, 67), (73, 29), (73, 36), (73, 88), (73, 99), (73, 100), (74, 4),
    (74, 20), (74, 42), (74, 43), (74, 49), (74, 67), (75, 26), (75, 56), (75, 77), (75, 80), (76, 2),
    (76, 55), (76, 71), (76, 77), (78, 2), (78, 26), (79, 84), (79, 87), (80, 30), (80, 35), (80, 55),
    (81, 4), (81, 20), (81, 47), (81, 49), (81, 75), (82, 19), (82, 20), (82, 55), (82, 95), (83, 20),
    (83, 24), (83, 59), (83, 93), (84, 29), (84, 35), (84, 42), (84, 45), (85, 11), (85, 22), (85, 32),
    (85, 53), (85, 70), (85, 96), (85, 96), (85, 99), (86, 74), (87, 23), (87, 35), (87, 46), (87, 53),
    (87, 71), (88, 3), (88, 13), (88, 27), (88, 35), (88, 40), (89, 5), (89, 14), (89, 26), (89, 27),
    (89, 31), (89, 14), (89, 58), (89, 94), (89, 94), (90, 3), (90, 97), (91, 23), (91, 58), (91, 62),
    (91, 76), (92, 38), (92, 58), (92, 61), (92, 70), (92, 73), (92, 74), (93, 2), (93, 16), (93, 16),
    (93, 54), (93, 59), (93, 67), (93, 76), (94, 24), (94, 100), (95, 6), (95, 14), (95, 14), (95, 16),
    (95, 20), (95, 52), (95, 58), (95, 60), (95, 70), (95, 73), (96, 47), (96, 71), (96, 84), (96, 85);