package H_ExceptionsAndErrorHandling;

import java.util.*;
import java.util.stream.*;

public class L03_EnterNumbers {

/*Write a method readNumber(int start, int end) that enters an integer number in a given range [start…end], excluding the numbers start and end.
If an invalid number or a non-number text is entered, the method should throw an exception. Using this method,
write a program that enters 10 numbers: a1, a2, … a10, such that 1 < a1 < … < a10 < 100. If the user enters an invalid number,
continue while there are 10 valid numbers entered. Print the array elements, separated with comma and space ", ".

Hints:
    •	When the entered input holds a non-integer value, print "Invalid Number!".
    •	When the entered input holds an integer that is out of range, print "Your number is not in range {currentNumber} - 100!". */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] enteredNumbers = new int[10];
        int validNumbersCounter = 0;
        int start = 1;
        int end = 100;

        while (validNumbersCounter < 10) {
            try {
                int number = readNumber(scanner, start, end);
                enteredNumbers[validNumbersCounter] = number;
                start = number;
                validNumbersCounter++;
            } catch (NumberFormatException e) {
                System.out.println("Invalid Number!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }

        String output = Arrays.stream(enteredNumbers).mapToObj(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(output);
    }

    private static int readNumber(Scanner scanner, int start, int end) {

        String input = scanner.nextLine();
        int number = Integer.parseInt(input);
        if (number <= start || number >= end) {
            throw new IllegalArgumentException(String.format("Your number is not in range %d - %d!", start, end));
        }
        return number;
    }
}
