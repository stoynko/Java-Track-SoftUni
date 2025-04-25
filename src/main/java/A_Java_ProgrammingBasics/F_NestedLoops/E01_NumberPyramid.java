package A_Java_ProgrammingBasics.F_NestedLoops;

import java.util.*;

public class E01_NumberPyramid {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        boolean flag = false;

        for (int row = 1; row <= n; row++) {
            for (int i = 1; i <= row; i++) {
                counter++;
                if (counter > n) {
                    flag = true;
                    break;
                }
                System.out.printf("%d ", counter);
            }
            System.out.println();
            if (flag)
                break;
        }
    }
}
