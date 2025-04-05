package B_Java_Fundamentals.A_BasicSyntaxConditionalStatements;

import java.util.*;

public class E05_Login {

/*You will be given a string representing a username. The password will be that username reversed. Until you receive the correct password,
print on the console "Incorrect password. Try again.". When you receive the correct password, print "User {username} logged in."
However, on the fourth try, if the password is still not correct, print "User {username} blocked!" and end the program.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        StringBuilder password = new StringBuilder();

        for (int index = username.length() - 1; index >= 0; index--) {
            password.append(username.charAt(index));
        }

        String passwordInput = scanner.nextLine();
        int counterAttempts = 0;
        boolean isBlocked = false;

        while (!passwordInput.contentEquals(password)) {
            counterAttempts++;
            if (counterAttempts == 4) {
                System.out.printf("User %s blocked!", username);
                return;
            }
            System.out.println("Incorrect password. Try again.");
            passwordInput = scanner.nextLine();
        }

        if (passwordInput.contentEquals(password)) {
            System.out.printf("User %s logged in.", username);
        }
    }
}