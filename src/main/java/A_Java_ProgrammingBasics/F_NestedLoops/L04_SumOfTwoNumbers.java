package A_Java_ProgrammingBasics.F_NestedLoops;

import java.util.*;

public class L04_SumOfTwoNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numStart = Integer.parseInt(scanner.nextLine());
        int numEnd = Integer.parseInt(scanner.nextLine());
        int numMagic = Integer.parseInt(scanner.nextLine());
        int result = 0;
        int counter = 0;
        boolean flag = false;

        for (int x = numStart; x <= numEnd; x++) {
            for (int y = numStart; y <= numEnd; y++) {
                result = x + y;
                counter++;
                if (result == numMagic) {
                    System.out.printf("Combination N:%d (%d + %d = %d)", counter, x, y, numMagic);
                    flag = true;
                    break;
                }
            }
            if (flag == true) {
                break;
            }
        }
        if (!flag) {
            System.out.printf("%d combinations - neither equals %d", counter, numMagic);
        }
    }
}
