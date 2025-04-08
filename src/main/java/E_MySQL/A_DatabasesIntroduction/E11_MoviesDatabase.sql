-- Using SQL queries create Movies database with the following entities:
--    •	directors (id, director_name, notes)
--        o	director_name cannot be null
--    •	genres (id, genre_name, notes)
--        o	genre_name cannot be null
--    •	categories (id, category_name, notes)
--        o	category_name cannot be null
--   •	movies (id, title, director_id, copyright_year, length, genre_id, category_id, rating, notes)
--        o	title cannot be null

--Set most appropriate data types for each column. Set primary key to each table. Populate each table with 5 records.
--Make sure the columns that are present in 2 tables would be of the same data type. Consider which fields are always required and which are optional.
--Submit your CREATE TABLE and INSERT statements as Run queries & check DB. */

CREATE TABLE `directors`(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    director_name VARCHAR(100) NOT NULL,
    notes TEXT
);

CREATE TABLE `genres` (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    genre_name VARCHAR(100) NOT NULL,
    notes TEXT
);

CREATE TABLE `categories` (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(100) NOT NULL,
    notes TEXT
);

CREATE TABLE `movies` (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    director_id INT,
    copyright_year YEAR,
    length DECIMAL(5,2),
    genre_id INT,
    category_id INT,
    rating DECIMAL(5,2),
    notes TEXT
);

INSERT INTO `directors` (id, director_name, notes) VALUES
    (1, 'Christopher Nolan', 'Known for non-linear, cerebral films'),
    (2, 'Bong Joon-ho', 'Korean director, Oscar winner'),
    (3, 'Hayao Miyazaki', 'Pioneer of Japanese animation'),
    (4, 'David Fincher', 'Known for dark psychological dramas'),
    (5, 'Wes Anderson', 'Signature visual and quirky tone');

INSERT INTO `genres` (id, genre_name, notes) VALUES
    (1, 'Science Fiction', 'Tech, time, space, speculative'),
    (2, 'Drama', 'Emotion-driven plots'),
    (3, 'Animation', 'Hand-drawn or computer-generated'),
    (4, 'Biography', 'Based on real-life stories'),
    (5, 'Comedy', 'Focus on humor and satire');

INSERT INTO `categories` (id, category_name, notes) VALUES
    (1, 'Feature Film', 'Over 75 minutes'),
    (2, 'International', 'Produced outside local region'),
    (3, 'Documentary', 'Real events and people'),
    (4, 'Short Film', 'Less than 40 minutes'),
    (5, 'Festival Winner', 'Awarded at film festivals');

ALTER TABLE `movies`
    ADD CONSTRAINT fk_director_id
        FOREIGN KEY (director_id) REFERENCES directors(id);

ALTER TABLE `movies`
    ADD CONSTRAINT fk_categories_id
        FOREIGN KEY (category_id) REFERENCES categories(id);

ALTER TABLE `movies`
    ADD CONSTRAINT fk_genre_id
        FOREIGN KEY (genre_id) REFERENCES genres(id);

INSERT INTO `movies` (id, title, director_id, copyright_year, length, genre_id, category_id, rating, notes) VALUES
    (1, 'Inception', 1, '2010', 148.00, 1, 1, 8.8, 'Dream layers and time'),
    (2, 'Parasite', 2, '2019', 132.00, 2, 2, 8.6, 'Class divide story'),
    (3, 'Spirited Away', 3, '2001', 125.00, 3, 2, 8.6, 'Coming-of-age fantasy'),
    (4, 'The Social Network', 4, '2010', 120.00, 4, 1, 7.8, 'Story of Facebook'),
    (5, 'The Grand Budapest Hotel', 5, '2014', 99.00, 5, 1, 8.1, 'Whimsical hotel adventures');

/*CREATE TABLE `directors`(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    director_name VARCHAR(100) NOT NULL,
    notes TEXT
);

CREATE TABLE `genres` (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    genre_name VARCHAR(100) NOT NULL,
    notes TEXT
);

CREATE TABLE `categories` (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(100) NOT NULL,
    notes TEXT
);

CREATE TABLE `movies` (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    director_id VARCHAR(255),
    copyright_year DATE,
    length DOUBLE(10,2),
    genre_id VARCHAR(255),
    category_id VARCHAR(255),
    rating DOUBLE(5,2),
    notes TEXT
);


INSERT INTO `directors` (id, director_name, notes) VALUES
(1, 'Christopher Nolan', 'Known for non-linear, cerebral films'),
(2, 'Bong Joon-ho', 'Korean director, Oscar winner'),
(3, 'Hayao Miyazaki', 'Pioneer of Japanese animation'),
(4, 'David Fincher', 'Known for dark psychological dramas'),
(5, 'Wes Anderson', 'Signature visual and quirky tone');

INSERT INTO `genres` (id, genre_name, notes) VALUES
(1, 'Science Fiction', 'Tech, time, space, speculative'),
(2, 'Drama', 'Emotion-driven plots'),
(3, 'Animation', 'Hand-drawn or computer-generated'),
(4, 'Biography', 'Based on real-life stories'),
(5, 'Comedy', 'Focus on humor and satire');

INSERT INTO `categories` (id, category_name, notes) VALUES
(1, 'Feature Film', 'Over 75 minutes'),
(2, 'International', 'Produced outside local region'),
(3, 'Documentary', 'Real events and people'),
(4, 'Short Film', 'Less than 40 minutes'),
(5, 'Festival Winner', 'Awarded at film festivals');

INSERT INTO `movies` (id, title, director_id, copyright_year, length, genre_id, category_id, rating, notes) VALUES
(1, 'Inception', 'Christopher Nolan', '2010-07-16', 148.00, 'Science Fiction', 'Feature Film', 8.8, 'Dream layers and time'),
(2, 'Parasite', 'Bong Joon-ho', '2019-05-30', 132.00, 'Drama', 'International', 8.6, 'Class divide story'),
(3, 'Spirited Away', 'Hayao Miyazaki', '2001-07-20', 125.00, 'Animation', 'International', 8.6, 'Coming-of-age fantasy'),
(4, 'The Social Network', 'David Fincher', '2010-10-01', 120.00, 'Biography', 'Feature Film', 7.8, 'Story of Facebook'),
(5, 'The Grand Budapest Hotel', 'Wes Anderson', '2014-03-28', 99.00, 'Comedy', 'Feature Film', 8.1, 'Whimsical hotel adventures'); */