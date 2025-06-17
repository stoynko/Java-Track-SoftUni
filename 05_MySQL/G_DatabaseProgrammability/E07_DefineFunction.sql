-- Define a function ufn_is_word_comprised(set_of_letters varchar(50), word varchar(50))  that returns 1 or 0 depending on
-- if the word is a comprised of the given set of letters. Submit your query statement as Run skeleton, run queries & check DB in Judge.

CREATE FUNCTION ufn_is_word_comprised(set_of_letters VARCHAR(50), word VARCHAR(50)) RETURNS TINYINT
    DETERMINISTIC
    BEGIN
        DECLARE char_pos INT DEFAULT 0;
        DECLARE current_char VARCHAR(1);
        DECLARE result TINYINT DEFAULT 1;

        WHILE result = 1 AND char_pos <= CHARACTER_LENGTH(word) DO
            SET char_pos = char_pos + 1;
            SET current_char = SUBSTRING(word, char_pos, 1);
            IF LOCATE(current_char, set_of_letters) = 0 THEN
                SET result = 0;
            END IF;
        END WHILE;
        RETURN result;
    END