package C_Java_Advanced.A_StacksAndQueues;

import java.util.*;

public class E02_BasicStackOperations {

/*You will be given an integer N representing the number of elements to push into the stack, an integer S representing the number of
elements to pop from the stack, and an integer X, an element that you should check whether is present in the stack.
If it is, print "true" on the console. If it's not, print the smallest element currently present in the stack.

Input
    •	On the first line, you will be given N, S, and X separated by a single space.
    •	On the next line, you will be given a line of numbers separated by one or more white spaces.
Output
    •	On a single line print, either "true" if X is present in the stack, otherwise, print the smallest element in the stack.
    •	If the stack is empty – print 0.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();
        scanner.nextLine();
        int[] data = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < n; i++) {
            stack.push(data[i]);
        }
        for (int i = 0; i < s; i++) {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        }

        if (stack.contains(x)) {
            System.out.println("true");
        } else {
            if (!stack.isEmpty()) {
                System.out.println(Collections.min(stack));
            } else {
                System.out.println("0");
            }
        }
    }
}
