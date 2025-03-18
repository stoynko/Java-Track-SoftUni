package C_Advanced.A_StacksAndQueues;

import java.util.*;
import java.util.stream.*;

public class L02_SimpleCalculator {

/*Create a simple calculator that can evaluate simple expressions that will not hold any operator different from addition and subtraction.
There will not be parentheses or operator precedence.
Solve the problem using a Stack.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] inputData = scanner.nextLine().split("\\s+");

        for (int index = inputData.length - 1; index >= 0; index--) {
            stack.push(inputData[index]);
        }
        while (stack.size() > 1) {
            int leftOperand = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int rightOperand = Integer.parseInt(stack.pop());
            int result = 0;
            if (operator.equals("+")) {
                result = leftOperand + rightOperand;
            } else if (operator.equals("-")) {
                result = leftOperand - rightOperand;
            }
            stack.push(String.valueOf(result));
        }
        System.out.println(stack.pop());
    }
}
