package A_Java_ProgrammingBasics.E_WhileLoops;

import java.util.*;

public class L02_Password {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();
        String password = scanner.nextLine();

        String input = scanner.nextLine();

        while (true) {
            if (input.equals(password)) {
                System.out.printf("Welcome %s!", userName);
                break;
            }
            input = scanner.nextLine();
        }
    }
}