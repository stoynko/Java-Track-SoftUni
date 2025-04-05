package C_Java_Advanced.A_StacksAndQueues;

import java.util.*;

public class E01_ReverseNumbersWithStack {

/*Write a program that reads N integers from the console and reverses them using a stack.
Use the ArrayDeque<Integer> class. Just put the input numbers in the stack and pop them.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> integersStack = new ArrayDeque<>();
        int[] integers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int integer : integers) {
            integersStack.push(integer);
        }
        for (int integer : integersStack) {
            System.out.print(integersStack.pop() + " ");
        }
    }
}
