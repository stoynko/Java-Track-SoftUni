package A_Java_ProgrammingBasics.D_ForLoop;

import java.util.*;

public class L08_NumberSequence {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int greatest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int input = Integer.parseInt(scanner.nextLine());
            if (input >= greatest) {
                greatest = input;
            }
            if (input <= smallest) {
                smallest = input;
            }
        }
        System.out.printf("Max number: %d\n", greatest);
        System.out.printf("Min number: %d", smallest);
    }
}