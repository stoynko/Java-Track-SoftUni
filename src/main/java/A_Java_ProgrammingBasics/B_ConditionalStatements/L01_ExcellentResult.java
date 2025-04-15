package A_Java_ProgrammingBasics.B_ConditionalStatements;

import java.util.*;

public class L01_ExcellentResult {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double grade = Double.parseDouble(scanner.nextLine());

        if (grade >= 5) {
            System.out.println("Excellent!");
        }
    }
}
