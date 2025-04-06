/* Using SQL queries modify table users from the previous task.
First remove current primary key then create new primary key that would be combination of fields id and username.
The initial primary key name on id is pk_users. Submit your query in Judge as Run skeleton, run queries & check DB.*/

ALTER TABLE `users`
DROP PRIMARY KEY,
ADD CONSTRAINT pk_user
PRIMARY KEY (id, username);