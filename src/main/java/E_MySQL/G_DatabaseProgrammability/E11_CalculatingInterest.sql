-- Your task is to create a stored procedure usp_calculate_future_value_for_account that accepts as parameters – id of account and interest rate.
-- The procedure uses the function from the previous problem to give an interest to a person's account for 5 years, along with information about his/her account id,
-- first name, last name and current balance as it is shown in the example below. It should take the account_id and the interest_rate as parameters.
-- Interest rate should have precision up to 0.0001, same as the calculated balance after 5 years.
-- Be extremely careful to achieve the desired precision!
-- Submit your query statement as Run skeleton, run queries & check DB in Judge.

CREATE FUNCTION ufn_calculate_future_value(sum DECIMAL(19,4),
                                           yearly_interest DOUBLE,
                                           years INT) RETURNS DECIMAL(19,4)
    DETERMINISTIC
BEGIN
RETURN sum * (POWER(1 + yearly_interest, years));
END

CREATE PROCEDURE usp_calculate_future_value_for_account(p_id INT, p_interest_rate DECIMAL(6, 4))
BEGIN
    SELECT acc.id AS 'account_id',
       ah.first_name,
       ah.last_name,
       acc.balance AS 'current_balance',
       ufn_calculate_future_value(acc.balance, p_interest_rate, 5) AS 'balance_in_5_years'
    FROM account_holders AS ah
         JOIN accounts AS acc ON ah.id = acc.account_holder_id
    WHERE acc.id = p_id;
END