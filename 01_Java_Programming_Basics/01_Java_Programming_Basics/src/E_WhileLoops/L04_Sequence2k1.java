package E_WhileLoops;

import java.util.*;

public class L04_Sequence2k1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        int x = 1;

        while (x <= input) {
            System.out.println(x);
            x = x * 2 + 1;
        }
    }
}
