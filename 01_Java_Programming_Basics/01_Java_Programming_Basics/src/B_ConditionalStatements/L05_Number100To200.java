package B_ConditionalStatements;

import java.util.*;

public class L05_Number100To200 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int digit = Integer.parseInt(scanner.nextLine());
        if (digit < 100)
            System.out.println("Less than 100");
        else if (digit >= 100 && digit <= 200)
            System.out.println("Between 100 and 200");
        else if (digit > 200)
            System.out.println("Greater than 200");
    }
}