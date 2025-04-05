package B_Java_Fundamentals.E_Lists;

import java.util.*;
import java.util.stream.*;

public class E07_AppendArrays {

/*Write a program to append several arrays of numbers.
•	Arrays are separated by "|".
•	Values are separated by spaces (" ", one or several).
•	Order the arrays from the last to the first and their values from left to right.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> list = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());

        Collections.reverse(list);
        System.out.println(list.toString().replaceAll("[\\[\\],]", "").replaceAll("\\s+", " ").trim());
    }
}