package B_Java_Fundamentals.B_DataTypesAndVariables;

import java.util.*;

public class L08_LowerOrUpper {

//Write a program that prints whether a given character is upper-case or lower-case.

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        char character = scanner.nextLine().charAt(0);

        if ((int) character >= 65 && (int) character <= 90) {
            System.out.println("upper-case");
        } else if ((int) character >= 97 && (int) character <= 122) {
            System.out.println("lower-case");
        }
    }
}
