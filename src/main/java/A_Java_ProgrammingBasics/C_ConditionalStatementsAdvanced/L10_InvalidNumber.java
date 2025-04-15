package A_Java_ProgrammingBasics.C_ConditionalStatementsAdvanced;

import java.util.*;

public class L10_InvalidNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());

        if (input != 0) {
            if (input < 0 || input > 0 && input < 100 || input > 200) {
                System.out.println("invalid");
            }
        }
    }
}