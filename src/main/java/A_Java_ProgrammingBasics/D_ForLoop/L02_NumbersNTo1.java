package A_Java_ProgrammingBasics.D_ForLoop;

import java.util.*;

public class L02_NumbersNTo1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int j = n; j >= 1; j--) {
            System.out.println(j);
        }
    }
}