package B_Java_Fundamentals.A_BasicSyntaxConditionalStatements;

import java.util.*;

public class L09_SumOfOddNumbers {

/*Write a program that prints the next n odd numbers (starting from 1) and on the last row prints the sum of them.
On the first line, you will receive a number – n. This number shows how many odd numbers you should print.
Print the next n odd numbers, starting from 1, separated by new lines. On the last line, print the sum of these numbers.
Constraints:
    •n will be in the interval [1…100]*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int i = 1;
        int sum = 0;
        int counter = 0;

        while (counter != n) {
            if (i % 2 == 1) {
                System.out.println(i);
                sum += i;
                counter++;
            }
            i++;
        }
        System.out.printf("Sum: %d", sum);
    }
}