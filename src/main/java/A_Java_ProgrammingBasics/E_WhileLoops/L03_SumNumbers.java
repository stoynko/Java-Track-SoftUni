package A_Java_ProgrammingBasics.E_WhileLoops;

import java.util.*;

public class L03_SumNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int initialInput = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        while (true) {
            sum += Integer.parseInt(scanner.nextLine());
            if (sum >= initialInput) {
                System.out.println(sum);
                break;
            }
        }
    }
}
