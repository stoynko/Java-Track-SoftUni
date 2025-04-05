package B_Java_Fundamentals.D_Methods;

import java.util.*;

public class E06_MiddleCharacters {

/*You will receive a single string. Write a method that prints the middle character.
If the length of the string is even, there are two middle characters.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("");
        printMiddleCharacters(input);
    }

    private static void printMiddleCharacters(String[] input) {

        int index = input.length / 2;
        if (input.length % 2 != 0) {
            System.out.println(input[index]);
        } else {
            System.out.printf("%s%s", input[index - 1], input[index]);
        }
    }
}