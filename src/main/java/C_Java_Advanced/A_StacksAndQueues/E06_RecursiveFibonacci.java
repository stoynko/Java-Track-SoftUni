package C_Java_Advanced.A_StacksAndQueues;

import java.util.*;

public class E06_RecursiveFibonacci {

/*Each member of the Fibonacci sequence is calculated from the sum of the two previous members. The first two elements are 1, 1.
Therefore, the sequence goes like 1, 1, 2, 3, 5, 8, 13, 21, 34…
The following sequence can be generated with an array, but that's easy, so your task is to implement it recursively.
If the function getFibonacci(n) returns the nth Fibonacci number, we can express it using

    getFibonacci(n) = getFibonacci(n-1) + getFibonacci(n-2).

However, this will never end, and a Stack Overflow Exception is thrown in a few seconds. For the recursion to stop,
it has to have a "bottom". The bottom of the recursion is getFibonacci(1), and should return 1. The same goes for getFibonacci(0).

    Input
    •	On the only line in the input, the user should enter the wanted Fibonacci number N where 1 ≤ N ≤ 49.
Output
    •	The output should be the nth Fibonacci number counting from 0.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Long> stack = new ArrayDeque<>();
        stack.push(1L);
        stack.push(1L);
        int operations = Integer.parseInt(scanner.nextLine());

        while (operations > 1) {
            long sum = 0;
            long operandA = stack.pop();
            long operandB = stack.pop();
            sum = operandA + operandB;
            stack.push(operandA);
            stack.push(sum);
            operations--;
        }
        System.out.println(stack.pop());
    }
}
