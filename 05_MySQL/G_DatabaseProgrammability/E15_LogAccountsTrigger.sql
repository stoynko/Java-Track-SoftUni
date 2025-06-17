-- Create another table – logs(log_id, account_id, old_sum, new_sum).
-- Add a trigger to the accounts table that enters a new entry into the logs table every time the sum on an account changes.
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
        END