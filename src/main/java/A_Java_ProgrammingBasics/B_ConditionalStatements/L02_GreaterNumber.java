package A_Java_ProgrammingBasics.B_ConditionalStatements;

import java.util.*;

public class L02_GreaterNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        if (a > b) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }
    }
}
