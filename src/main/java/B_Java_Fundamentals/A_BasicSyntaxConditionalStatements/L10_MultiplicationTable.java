package B_Java_Fundamentals.A_BasicSyntaxConditionalStatements;

import java.util.*;

public class L10_MultiplicationTable {

/*You will receive an integer as input from the console. Print the 10 times table for this integer.
See the examples below for more information.
Print every row of the table in the following format:
    {theInteger} X {times} = {product}

Constraints:
    •The integer will be in the interval [1…100]*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= 10; i++) {
            int result = n * i;
            System.out.printf("%d X %d = %d\n", n, i, result);
        }
    }
}