package C_ConditionalStatementsAdvanced;

import java.util.*;

public class L06_NumberInRange {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double input = Double.parseDouble(scanner.nextLine());

        if (input >= -100 && input <= -1 || input >= 1 && input <= 100) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
