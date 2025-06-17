-- Add stored procedures usp_withdraw_money(account_id, money_amount) that operate in transactions.
-- Make sure to guarantee withdraw is done only when balance is enough and money_amount is valid positive number.
-- Work with precision up to fourth sign after decimal point.
-- The procedure should produce exact results working with the specified precision.
-- Submit your query statement as Run skeleton, run queries & check DB in Judge.

CREATE PROCEDURE usp_withdraw_money(account_id INT, money_amount DECIMAL(19, 4))
BEGIN
    DECLARE valid_id INT DEFAULT 0;
    DECLARE current_balance DECIMAL (19, 4) DEFAULT 0.0;
    SET valid_id := (SELECT COUNT(*) FROM accounts WHERE id = account_id);
    SET current_balance := (SELECT balance FROM accounts WHERE id = account_id);

START TRANSACTION;
    IF current_balance < money_amount OR money_amount < 0 OR valid_id = 0 THEN
        ROLLBACK;
    ELSE
        UPDATE accounts
        SET balance = balance - money_amount
        WHERE id = account_id;
        COMMIT;
    END IF;
END