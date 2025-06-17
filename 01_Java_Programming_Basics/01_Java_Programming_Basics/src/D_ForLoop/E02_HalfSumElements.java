package D_ForLoop;

import java.util.*;

public class E02_HalfSumElements {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(scanner.nextLine());
            sum += input;
            if (input > max) {
                max = input;
            }
        }
        if (max == (sum - max)) {
            System.out.println("Yes");
            System.out.printf("Sum = %d", max);
        } else {
            System.out.println("No");
            System.out.printf("Diff = %d", Math.abs(max - (sum - max)));
        }
    }
}