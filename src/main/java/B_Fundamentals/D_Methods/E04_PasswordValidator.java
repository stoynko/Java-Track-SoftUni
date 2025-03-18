package B_Fundamentals.D_Methods;

import java.util.*;

public class E04_PasswordValidator {

/*Write a program that checks if a given password is valid. Password rules are:
    •	6 – 10 characters (inclusive);
    •	Consists only of letters and digits;
    •	Have at least 2 digits.
If a password is valid, print "Password is valid". If it is not valid, for every unfulfilled rule, print a message:
    •	"Password must be between 6 and 10 characters"
    •	"Password must consist only of letters and digits"
    •	"Password must have at least 2 digits"*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String passwordInput = scanner.nextLine();

        if (isPasswordLengthValid(passwordInput)) {
            if (isPasswordInputValid(passwordInput)) {
                if (isPasswordDigitCountValid(passwordInput)) {
                    System.out.println("Password is valid");
                }
            }
        }
        if (!isPasswordLengthValid(passwordInput)) {
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!isPasswordInputValid(passwordInput)) {
            System.out.println("Password must consist only of letters and digits");
        }
        if (!isPasswordDigitCountValid(passwordInput)) {
            System.out.println("Password must have at least 2 digits");
        }
    }

    private static boolean isPasswordLengthValid(String passwordInput) {

        return passwordInput.length() >= 6 && passwordInput.length() <= 10;
    }

    private static boolean isPasswordInputValid(String passwordInput) {

        for (char currentChar : passwordInput.toCharArray()) {
            if (!Character.isLetterOrDigit(currentChar)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPasswordDigitCountValid(String passwordInput) {
        byte digitCounter = 0;
        for (char currentChar : passwordInput.toCharArray()) {
            if (Character.isDigit(currentChar)) {
                digitCounter++;
            }
        }
        if (digitCounter < 2) {
            return false;
        }
        return true;
    }
}