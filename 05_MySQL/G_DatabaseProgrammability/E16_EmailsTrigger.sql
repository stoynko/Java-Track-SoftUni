-- Create another table – notification_emails(id, recipient, subject, body).
-- Add a trigger to logs table to create new email whenever new record is inserted in logs table.
-- The following data is required to be filled for each email:
-- •	recipient – account_id
-- •	subject – "Balance change for account: {account_id}"
-- •	body - "On {date (current date)} your balance was changed from {old} to {new}."
-- Submit your query statement as Run skeleton, run queries & check DB in Judge.

CREATE TABLE logs(
    log_id INT AUTO_INCREMENT PRIMARY KEY,
    account_id INT,
    old_sum DECIMAL(19, 4) NOT NULL,
    new_sum DECIMAL(19, 4) NOT NULL
);

CREATE TRIGGER balance_change_trigger AFTER UPDATE ON accounts
    FOR EACH ROW
BEGIN
    INSERT INTO logs (account_id, old_sum, new_sum) VALUES
        (old.id, old.balance, new.balance);
END;

CREATE TABLE notification_emails(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    recipient INT,
    subject VARCHAR(100),
    body TEXT
);

CREATE TRIGGER send_notification_email AFTER INSERT ON logs
    FOR EACH ROW
BEGIN
    INSERT INTO notification_emails(recipient, subject, body) VALUES
        (new.account_id, CONCAT('Balance change for account: ', new.account_id), CONCAT('On ', DATE_FORMAT(NOW(), '%b %d %Y at %r'), 'your balance was changed from ', new.old_sum, ' to ', new.new_sum));
END