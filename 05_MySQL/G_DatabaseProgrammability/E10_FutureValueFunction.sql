-- Your task is to create a function ufn_calculate_future_value that accepts as parameters – sum
-- (with precision, 4 digits after the decimal point), yearly interest rate (double) and number of years(int).
-- It should calculate and return the future value of the initial sum.
-- The result from the function must be decimal, with precision 4.
--  Using the following formula:

--      FV = I * (1 + R)^T
-- •	I – Initial sum
-- •	R – Yearly interest rate
-- •	T – Number of years
-- Submit your query statement as Run skeleton, run queries & check DB in Judge.

CREATE FUNCTION ufn_calculate_future_value(
    p_sum DECIMAL(19,4),
    p_yearly_interest DOUBLE,
    p_years INT) RETURNS DECIMAL(19,4)

    DETERMINISTIC
    BEGIN
        RETURN p_sum * (POWER(1 + p_yearly_interest, p_years));
    END