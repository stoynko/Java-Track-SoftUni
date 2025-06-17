package B_DataTypesAndVariables;

import java.util.*;

public class L12_RefactorSpecialNumbers {

/*You are given a code that is a similar to the solution to Problem 10 - Special Numbers.
However, the variables are improperly named, declared before they are needed, and some of them are used for multiple things.
Without using your previous solution, modify the code so that it is easy to read and understand.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int current = 0;
        boolean isSpecial = false;

        for (int i = 1; i <= n; i++) {
            current = i;

            while (i > 0) {
                sum += i % 10;
                i = i / 10;
            }
            String result = "";
            isSpecial = (sum == 5) || (sum == 7) || (sum == 11);

            if (isSpecial) {
                result = "True";
            } else {
                result = "False";
            }
            System.out.printf("%d -> %s%n", current, result);
            sum = 0;
            i = current;
        }
    }
}