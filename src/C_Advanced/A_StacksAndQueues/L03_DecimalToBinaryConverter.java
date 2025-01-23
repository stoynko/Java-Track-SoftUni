package C_Advanced.A_StacksAndQueues;

import java.util.*;

public class L03_DecimalToBinaryConverter {

/*Create a simple program that can convert a decimal number to its binary representation.
Implement an elegant solution using a Stack.
Print the binary representation back at the terminal.*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decimalNumber = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        if (decimalNumber == 0) {
            System.out.println(decimalNumber);
        } else {
            while (decimalNumber > 0) {
                int remainder = decimalNumber % 2;
                stack.push(remainder);
                decimalNumber /= 2;
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
