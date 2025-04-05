package B_Java_Fundamentals.A_BasicSyntaxConditionalStatements;

import java.util.*;

public class AE04_ReverseString {

//Write a program that reverses a string and prints it on the console.

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String result = "";

        for (int index = input.length() - 1; index >= 0; index--) {
            result = result + input.charAt(index);
        }
        System.out.println(result);
    }
}

