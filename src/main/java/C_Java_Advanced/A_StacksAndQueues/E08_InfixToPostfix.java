package C_Java_Advanced.A_StacksAndQueues;

import java.util.*;

public class E08_InfixToPostfix {

/*Mathematical expressions are written in an infix notations, for example "5 / ( 3 + 2 )".
However, this kind of notation is not efficient for computer processing, as you first need to evaluate the expression inside the brackets,
so there is a lot of back and forth movement. A more suitable approach is to convert it into the so-called postfix notations
(also called Reverse Polish Notation), in which the expression is evaluated from left to right, for example, "3 2 + 5 /".
Implement an algorithm that converts the mathematical expression from infix notation into a postfix notation.
Use the famous Shunting-yard algorithm.

    Input:
        •	You will receive an expression on a single line consisting of tokens.
        •	Tokens could be numbers 0-9, variables a-z, operators +, -, *, / and brackets ( or ).
        •	Each token is separated by exactly one space.

    Output:
        •	The output should be on a single line, consisting of tokens separated by exactly one space.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().trim();
        String[] infixExpression = input.split("\\s+");
        StringBuilder postfixExpression = new StringBuilder();
        ArrayDeque<Character> operatorsStack = new ArrayDeque<>();

        for (String token : infixExpression) {
            char currentChar = token.charAt(0);

            if (isCharVariable(currentChar)) {
                postfixExpression.append(token).append(" ");
            } else if (currentChar == '(') {
                operatorsStack.push(currentChar);
            } else if (currentChar == ')') {
                while (!operatorsStack.isEmpty() && operatorsStack.peek() != '(') {
                    postfixExpression.append(operatorsStack.pop()).append(" ");
                }
                operatorsStack.pop();
            } else if (isCharOperator(currentChar)) {
                while (!operatorsStack.isEmpty() && operatorsStack.peek() != '('
                        && getPrecedence(operatorsStack.peek()) >= getPrecedence(currentChar)) {
                    postfixExpression.append(operatorsStack.pop()).append(" ");
                }
                operatorsStack.push(currentChar);
            }
        }
        while (!operatorsStack.isEmpty()) {
            char operator = operatorsStack.pop();
            postfixExpression.append(operator).append(" ");
        }

        System.out.println(postfixExpression.toString().trim());
    }

    private static int getPrecedence(char operator) {
        int precadence = 0;
        switch (operator) {
            case '+', '-' -> precadence = 1;
            case '*', '/' -> precadence = 2;
        }
        return precadence;
    }

    private static boolean isCharVariable(char character) {
        return Character.isDigit(character) || Character.isLetter(character);
    }

    private static boolean isCharOperator(char character) {
        return character == '+' || character == '-' || character == '*' || character == '/' || character == '(' || character == ')';
    }
}