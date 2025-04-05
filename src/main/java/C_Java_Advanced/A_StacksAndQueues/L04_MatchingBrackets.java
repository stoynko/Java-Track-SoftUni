package C_Java_Advanced.A_StacksAndQueues;

import java.util.*;

public class L04_MatchingBrackets {

/*We are given an arithmetical expression with brackets. Scan through the string and extract each sub-expression.
Print the result back at the terminal.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StringBuilder expression = new StringBuilder(scanner.nextLine());
        ArrayDeque<Integer> indicesStack = new ArrayDeque<>();

        for (int index = 0; index <= expression.length() - 1; index++) {

            char currentChar = expression.charAt(index);
            int endIndex = 0;
            if (currentChar == '(') {
                indicesStack.push(index);
            } else if (currentChar == ')') {
                System.out.println(expression.substring(indicesStack.pop(), index + 1));
            }
        }
    }
}
