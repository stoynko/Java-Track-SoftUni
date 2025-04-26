-- Write stored procedure usp_transfer_money(from_account_id, to_account_id, amount) that transfers money from one account to another.
-- Consider cases when one of the account_ids is not valid, the amount of money is negative number, outgoing balance is enough or transferring
-- from/to one and the same account. Make sure that the whole procedure passes without errors and if error occurs make no change in the database.
-- Make sure to guarantee exact results working with precision up to fourth sign after decimal point.
-- Submit your query statement as Run skeleton, run queries & check DB in Judge.

CREATE PROCEDURE usp_transfer_money(from_account_id INT, to_account_id INT, amount DECIMAL(19, 4))
    BEGIN
        DECLARE valid_from_account_id INT DEFAULT 0;
        DECLARE valid_to_account_id INT DEFAULT 0;
        DECLARE balance_sender DECIMAL (19, 4) DEFAULT 0.0;

    START TRANSACTION;
        SET valid_from_account_id = (SELECT COUNT(*) FROM accounts AS acc WHERE from_account_id = acc.id);
        SET valid_to_account_id = (SELECT COUNT(*) FROM accounts AS acc WHERE to_account_id = acc.id);
        SET balance_sender = (SELECT balance FROM accounts AS acc WHERE from_account_id = acc.id);

        IF valid_from_account_id = 0 OR valid_to_account_id = 0 THEN
            ROLLBACK;
        ELSEIF from_account_id = to_account_id THEN
            ROLLBACK;
        ELSEIF amount <= 0 THEN
            ROLLBACK;
        ELSEIF balance_sender < amount THEN
            ROLLBACK;
        ELSE
            UPDATE accounts AS acc
            SET balance = balance - amount
                WHERE acc.id = from_account_id;
            UPDATE accounts AS acc
            SET balance = balance + amount
                WHERE acc.id = to_account_id;
            COMMIT;
        END IF;
    END