package C_Java_Advanced.C_SetsAndDictionariesAdvanced;

import java.util.*;

public class L04_CountRealNumbers {

/*Write a program that counts the occurrence of real numbers. The input is a single line with real numbers separated by a space.
Print the numbers in the order of appearance. All numbers must be formatted to one digit after the decimal point.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<Double, Integer> map = new LinkedHashMap<>();
        double[] integers = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

        for (double integer : integers) {

            if (!map.containsKey(integer)) {
                int value = 1;
                map.put(integer, value);
            } else {
                map.put(integer, map.get(integer) + 1);
            }
        }

        for (double integer : map.keySet()) {
            System.out.printf("%.1f -> %d\n", integer, map.get(integer));
        }
    }
}
