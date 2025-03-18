package C_Advanced.A_StacksAndQueues;

import java.util.*;

public class E05_BalancedParentheses {

/*Given a sequence consisting of parentheses, determine whether the expression is balanced.
A sequence of parentheses is balanced if every open parenthesis can be paired uniquely with a closing parenthesis that occurs
after the former. Also, the interval between them must be balanced.
You will be given three types of parentheses: (, {, and [.
    •	{[()]} - This is a balanced parenthesis.
    •	{[(])} - This is not a balanced parenthesis.
Input
    •	Each input consists of a single line, the sequence of parentheses.
    •	1 ≤ Length of sequence ≤ 1000.
    •	Each character of the sequence will be one of the following: {, }, (, ), [, ].
Output
    •	For each test case, print on a new line "YES" if the parentheses are balanced. Otherwise, print "NO".*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Character> openingBrackets = new ArrayDeque<>();
        boolean isBalanced = true;

        if (input.length() % 2 == 0) {
            for (int index = 0; index < input.length(); index++) {
                char currentBracket = input.charAt(index);
                if (currentBracket == '(' || currentBracket == '{' || currentBracket == '[') {
                    openingBrackets.push(currentBracket);
                } else if (currentBracket == ')' || currentBracket == '}' || currentBracket == ']') {
                    char currentClosingBracket = input.charAt(index);
                    char currentOpeningBracket = openingBrackets.pop();
                    if (currentOpeningBracket == '(' && currentClosingBracket == ')') {
                        continue;
                    } else if (currentOpeningBracket == '{' && currentClosingBracket == '}') {
                        continue;
                    } else if (currentOpeningBracket == '[' && currentClosingBracket == ']') {
                        continue;
                    } else {
                        isBalanced = false;
                        break;
                    }
                }
            }
        } else {
            isBalanced = false;
        }
        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}