package B_Java_Fundamentals.B_DataTypesAndVariables;

import java.util.*;

public class E05_PrintASCIITable {

/*Find online more information about ASCII (American Standard Code for Information Interchange) and write a program that prints part of the ASCII table
of characters at the console. On the first line of input, you will receive the char index you should start with,
and on the second line - the index of the last character you should print.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        short start = Short.parseShort(scanner.nextLine());
        short end = Short.parseShort(scanner.nextLine());

        for (short i = start; i <= end; i++) {
            char currentChar = (char) i;
            System.out.printf("%s ", currentChar);
        }
    }
}