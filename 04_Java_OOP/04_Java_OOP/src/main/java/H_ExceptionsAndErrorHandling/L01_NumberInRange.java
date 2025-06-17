package H_ExceptionsAndErrorHandling;

import java.util.*;

public class L01_NumberInRange {

/*Write a program to enter an integer in a certain range. Until the number is not valid, enter a new number from the console.
When the number is valid - end the program.

Input:
    •	Read a range - two numbers, separated by a space.
    •	On the next line, read the String.
Output
    •	Print the range in the following format: "Range: [{startIndex}...{endIndex}]".
    •	When an invalid number is entered, String or the number is out of range, print "Invalid number: {num}".
    •	When the entered number is valid, print "Valid number: {num}". */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] integersRange = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int lowerRange = integersRange[0];
        int upperRange = integersRange[1];
        System.out.printf("Range: [%d...%d]\n", lowerRange, upperRange);
        boolean isNumberValid = false;
        int numberToCheck = 0;

        do {
            String input = scanner.nextLine();
            try {
                numberToCheck = Integer.parseInt(input);
                if (numberToCheck < lowerRange || numberToCheck > upperRange) {
                    throw new IllegalArgumentException(String.format("Invalid number: %d", numberToCheck));
                } else {
                    isNumberValid = true;
                }
            } catch (NumberFormatException e) {
                System.out.printf("Invalid number: %s\n", input);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        } while (isNumberValid == false);
        System.out.printf("Valid number: %d\n", numberToCheck);
    }
}
