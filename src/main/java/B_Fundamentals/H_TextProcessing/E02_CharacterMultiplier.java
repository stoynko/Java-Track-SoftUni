package B_Fundamentals.H_TextProcessing;

import java.util.*;

public class E02_CharacterMultiplier {

/*Create a method that takes two strings as arguments and returns the sum of their character codes multiplied
(multiply str1[0] with str2[0] and add to the total sum). Then continue with the next two characters.
If one of the strings is longer than the other, add the remaining character codes to the total sum without multiplication.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        int sum = 0;
        int maxCycles = Math.min(input[0].length(), input[1].length());
        if (maxCycles == input[0].length()) {
            sum = calculateSum(input, maxCycles, sum);
            sum = addRemainder(input[1], maxCycles, sum);
        } else {
            sum = calculateSum(input, maxCycles, sum);
            sum = addRemainder(input[0], maxCycles, sum);
        }

        System.out.println(sum);
    }

    private static int addRemainder(String word, int maxCycles, int sum) {

        for (int index = maxCycles; index <= word.length() - 1; index++) {
            sum += word.charAt(index);
        }
        return sum;
    }

    private static int calculateSum(String[] input, int maxCycles, int sum) {
        for (int index = 0; index < maxCycles; index++) {
            int operatorA = input[0].charAt(index);
            int operatorB = input[1].charAt(index);
            sum += operatorA * operatorB;
        }
        return sum;
    }
}