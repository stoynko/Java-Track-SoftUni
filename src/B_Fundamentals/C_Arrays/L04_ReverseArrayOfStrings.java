package B_Fundamentals.C_Arrays;

import java.util.*;

public class L04_ReverseArrayOfStrings {

/*Write a program to read an array of strings, reverse it and print its elements.
The input consists of a sequence of space-separated strings.
Print the output on a single line (space separated).*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int counter = 0;
        for (int index = 0; index < input.length / 2; index++) {
            String temp = input[index];
            input[index] = input[input.length - 1 - index];
            input[input.length - 1 - index] = temp;
        }
        System.out.println(String.join(" ", input));
    }
}