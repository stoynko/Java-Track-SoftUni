package A_Java_ProgrammingBasics.B_ConditionalStatements;

import java.util.*;

public class L04_PasswordGuess {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String password = "s3cr3t!P@ssw0rd";
        String passwordInput = scanner.nextLine();

        if (password.equals(passwordInput))
            System.out.println("Welcome");
        else
            System.out.println("Wrong password!");
    }
}