package A_Java_ProgrammingBasics.F_NestedLoops;

import java.util.*;

public class E05_SpecialNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        String specialNumS = "";
        int specialNum = 0;
        for (int d1 = 1; d1 <= 9; d1++) {
            for (int d2 = 1; d2 <= 9; d2++) {
                for (int d3 = 1; d3 <= 9; d3++) {
                    for (int d4 = 1; d4 <= 9; d4++) {
                        if (number % d1 == 0 && number % d2 == 0 && number % d3 == 0 && number % d4 == 0) {
                            System.out.printf("%d%d%d%d ", d1, d2, d3, d4);
                        }
                    }
                }
            }
        }
    }
}