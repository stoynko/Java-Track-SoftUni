package B_Fundamentals.B_DataTypesAndVariables;

import java.util.*;

public class E06_TriplesOfLatinCharacets {

//Write a program to read an integer n and print all triples of the first n small Latin letters, ordered alphabetically.

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        byte n = Byte.parseByte(scanner.nextLine());

        byte start = 97;
        byte end = 122;
        byte range = (byte) (start + n);

        for (int i = start; i < range; i++) {
            char charOne = (char) i;
            for (int k = start; k < range; k++) {
                char charTwo = (char) k;
                for (int j = start; j < range; j++) {
                    char charThree = (char) j;
                    System.out.printf("%s%s%s%n", charOne, charTwo, charThree);
                }
            }
        }
    }
}