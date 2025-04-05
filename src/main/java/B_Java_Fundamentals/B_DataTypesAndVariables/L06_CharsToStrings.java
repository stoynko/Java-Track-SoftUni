package B_Java_Fundamentals.B_DataTypesAndVariables;

import java.util.*;

public class L06_CharsToStrings {

//Write a program that reads 3 lines of input. On each line, you get a single character. Combine all the characters into one string and print it on the console.

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String charOne = scanner.nextLine();
        String charTwo = scanner.nextLine();
        String charThree = scanner.nextLine();

        String result = charOne + charTwo + charThree;

        System.out.println(result);
    }
}