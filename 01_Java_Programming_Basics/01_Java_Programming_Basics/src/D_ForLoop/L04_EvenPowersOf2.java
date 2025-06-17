package D_ForLoop;

import java.util.*;

public class L04_EvenPowersOf2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <= n; i += 2) {
            System.out.println(Math.pow(2, i));
        }
    }
}
