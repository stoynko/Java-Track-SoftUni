-- Add stored procedure usp_deposit_money(account_id, money_amount) that operate in transactions.
-- Make sure to guarantee valid positive money_amount with precision up to fourth sign after decimal point.
-- The procedure should produce exact results working with the specified precision.
-- Submit your query statement as Run skeleton, run queries & check DB in Judge.

CREATE PROCEDURE usp_deposit_money(account_id INT, money_amount DECIMAL(19, 4))
    BEGIN
        DECLARE valid_id INT DEFAULT 0;
        START TRANSACTION;
        SET valid_id := (SELECT COUNT(*) FROM accounts WHERE id = account_id);
        IF money_amount <= 0 OR valid_id = 0 THEN
            ROLLBACK;
        ELSE
            UPDATE accounts
            SET balance = balance + money_amount
            WHERE id = account_id;
            COMMIT;
        END IF;
    END