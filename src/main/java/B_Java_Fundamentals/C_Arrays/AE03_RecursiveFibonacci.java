package B_Java_Fundamentals.C_Arrays;

import java.util.*;

public class AE03_RecursiveFibonacci {

/*The Fibonacci sequence is quite a famous sequence of numbers. Each sequence member is calculated from the sum of the two previous elements.
The first two elements are 1, 1. Therefore, the sequence goes like 1, 1, 2, 3, 5, 8, 13, 21, 34…
The following sequence can be generated with an array, but that's easy, so your task is to implement it recursively.
So if the function GetFibonacci(n) returns the nth Fibonacci number we can express it using GetFibonacci(n) = GetFibonacci(n-1) + GetFibonacci(n-2).
However, this will never end and in a few seconds, a StackOverflow Exception is thrown. For the recursion to stop, it has to have a "bottom".
At the bottom of the recursion is GetFibonacci(2) should return 1, and GetFibonacci(1) should return 1.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int target = Integer.parseInt(scanner.nextLine());
        int[] sequence = new int[target];
        if (target == 1 || target == 0) {
            System.out.println(1);
            return;
        }
        sequence[0] = 1;
        sequence[1] = 1;
        for (int index = 2; index <= sequence.length - 1; index++) {
            sequence[index] = sequence[index - 1] + sequence[index - 2];
        }

        System.out.println(sequence[target - 1]);
    }
}
