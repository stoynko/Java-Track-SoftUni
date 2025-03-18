package C_Advanced.C_SetsAndDictionariesAdvanced;

import java.util.*;
import java.util.stream.*;

public class L09_Largers3Numbers {

//Read a list of integers and print the largest 3 of them. If there are less than 3, print all of them.

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> integers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).sorted((x,y) -> y.compareTo(x)).collect(Collectors.toList());

        for (int i = 0; i < Math.min(3, integers.size()); i++) {
            System.out.print(integers.get(i) + " ");
        }
    }
}
