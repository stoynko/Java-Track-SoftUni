package B_Fundamentals.B_DataTypesAndVariables;

import java.util.*;

public class L07_ReversedChars {

//Write a program that takes 3 lines of characters and prints them in reversed order with a space between them.

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String charOne = scanner.nextLine();
        String charTwo = scanner.nextLine();
        String charThree = scanner.nextLine();

        System.out.printf("%s %s %s", charThree, charTwo, charOne);
    }
}
