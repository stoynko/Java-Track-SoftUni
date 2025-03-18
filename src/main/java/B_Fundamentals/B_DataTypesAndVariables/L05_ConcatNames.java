package B_Fundamentals.B_DataTypesAndVariables;

import java.util.*;

public class L05_ConcatNames {

    //Read two names and a delimiter. Print the names joined by the delimiter.

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String nameA = scanner.nextLine();
        String nameB = scanner.nextLine();
        String delimiter = scanner.nextLine();

        String result = nameA + delimiter + nameB;

        System.out.println(result);
    }
}