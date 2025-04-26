-- Your task is to create a stored procedure usp_get_holders_with_balance_higher_than that accepts a number as a
-- parameter and returns all people who have more money in total of all their accounts than the supplied number.
-- The result should be sorted by account_holders.id ascending.
-- Submit your query statement as Run skeleton, run queries & check DB in Judge.

CREATE PROCEDURE usp_get_holders_with_balance_higher_than(balance_param DECIMAL)
BEGIN
SELECT ah.first_name,
       ah.last_name
FROM account_holders AS ah
         JOIN accounts AS acc ON ah.id = acc.account_holder_id
GROUP BY ah.first_name, ah.last_name
HAVING SUM(acc.balance) > balance_param;
END