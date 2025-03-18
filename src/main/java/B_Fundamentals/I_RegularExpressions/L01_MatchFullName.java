package B_Fundamentals.I_RegularExpressions;

import java.util.*;
import java.util.regex.*;

public class L01_MatchFullName {

/*  Write a Java Program to match full names from a list of names and print them on the console.

First, write a regular expression to match a valid full name, according to these conditions:

•	A valid full name has the following characteristics:
    o	It consists of two words.
    o	Each word starts with a capital letter.
    o	After the first letter, it only contains lowercase letters afterward.
        o	Each of the two words should be at least two letters long.
        o	The two words are separated by a single space.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String regex = "\\b[A-Z][a-z]+ [A-Z][a-z]+\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(scanner.nextLine());

        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
    }
}