package F_ObjectsAndClasses;

import java.math.*;
import java.util.*;

public class L03_BigFactorial {

/*You will receive N - the number in the range [0 - 1000]. Calculate the Factorial of N and print the result.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        BigInteger result = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        System.out.println(result);
    }
}
