/*Using SQL queries modify table users. Remove username field from the primary key so only the field id would be primary key.
Now add unique constraint to the username field. The initial primary key name on (id, username) is pk_users.
Submit your query in Judge as Run skeleton, run queries & check DB.*/

ALTER TABLE `users`
DROP PRIMARY KEY,
    ADD PRIMARY KEY (id);

ALTER TABLE `users`
    MODIFY username VARCHAR(30) NOT NULL UNIQUE;