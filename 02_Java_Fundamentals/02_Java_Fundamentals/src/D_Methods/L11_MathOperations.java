package D_Methods;

import java.util.*;

public class L11_MathOperations {

/*Write a method that receives two numbers and an operator, calculates the result, and returns it. You will be given three lines of input.
The first will be the first number, the second one will be the operator, and the last one will be the second number. The possible operators are: / * + -*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int operatorA = Integer.parseInt(scanner.nextLine());
        String operation = scanner.nextLine();
        int operatorB = Integer.parseInt(scanner.nextLine());
        System.out.println(Calculation(operation, operatorA, operatorB));
    }

    private static int Calculation(String operation, int operatorA, int operatorB) {
        int result = 0;
        switch (operation) {
            case "+" -> result = operatorA + operatorB;
            case "-" -> result = operatorA - operatorB;
            case "*" -> result = operatorA * operatorB;
            case "/" -> result = operatorA / operatorB;
        }
        return result;
    }
}