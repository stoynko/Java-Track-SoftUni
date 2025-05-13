-- Using SQL query create table users with columns:

-- •	id – unique number for every user. There will be no more than 263-1 users. (Auto incremented)
-- •	username – unique identifier of the user will be no more than 30 characters (non Unicode). (Required)
-- •	password – password will be no longer than 26 characters (non Unicode). (Required)
-- •	profile_picture – image with size up to 900 KB.
-- •	last_login_time
-- •	is_deleted – shows if the user deleted his/her profile. Possible states are true or false.

-- Make id primary key. Populate the table with 5 records. Submit your CREATE and INSERT statements.
-- Submit your CREATE and INSERT statements as Run queries & check DB.

CREATE TABLE users (
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
username VARCHAR(30) NOT NULL,
password VARCHAR(26),
profile_picture TEXT,
last_login_time TIMESTAMP,
is_deleted BOOL);

INSERT INTO `users` (id, username, password, profile_picture, last_login_time, is_deleted) VALUES
(1, 'Ivan', '123', 'PROFILE_PHOTO', NOW(), false),
(2, 'Georgi', '123', 'PROFILE_PHOTO', NOW(), false),
(3, 'Petar', '123', 'PROFILE_PHOTO', NOW(), false),
(4, 'Mariya', '123', 'PROFILE_PHOTO', NOW(), false),
(5, 'Gergana', '123', 'PROFILE_PHOTO', NOW(), false);
