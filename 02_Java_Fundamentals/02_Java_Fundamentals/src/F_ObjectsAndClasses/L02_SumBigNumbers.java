package F_ObjectsAndClasses;

import java.math.*;
import java.util.*;

public class L02_SumBigNumbers {

/*You will receive two numbers (0 to 1050), and print their sum.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BigInteger firstNumber = new BigInteger(scanner.nextLine());
        BigInteger secondNumber = new BigInteger(scanner.nextLine());
        BigInteger result = firstNumber.add(secondNumber);
        System.out.println(result);
    }
}