package D_Java_OOP.X_Workshop.entities.user;

import D_Java_OOP.X_Workshop.common.*;

public class UserValidator {

    public static void validateUsername(String username) {
        if (username == null || username.isBlank() || username.length() < 5
                || username.chars().noneMatch(Character::isDigit)) {
            throw new IllegalArgumentException(SystemErrors.INVALID_USERNAME);
        }
    }

    public static void validatePassword(String password) {
        if (password == null || password.isBlank() || password.length() != 6
                || !password.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(SystemErrors.INVALID_PASSWORD);
        }
    }
}
