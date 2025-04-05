package C_Java_Advanced.C_SetsAndDictionariesAdvanced;

import java.util.*;

public class E03_PeriodicTable {

/*You are given an n number of chemical compounds. You need to keep track of all chemical elements used in the compounds and at the end,
print all unique ones in ascending order.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeSet <String> elements = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] inputData = scanner.nextLine().split(" ");
            for (String element : inputData) {
                elements.add(element);
            }
        }

        for (String element : elements) {
            System.out.printf("%s ", element);
        }
    }
}
