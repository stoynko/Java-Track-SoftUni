package B_Fundamentals.C_Arrays;

import java.util.*;

public class L06_EqualArrays {

/*Read two arrays and print on the console whether they are identical or not/
Arrays are identical if their elements are equal. If the arrays are identical,
find the sum of the first one and print on the console the following message:
            "Arrays are identical. Sum: {sum}"

Otherwise, find the first index where the arrays differ and print on the console following message:
        "Arrays are not identical. Found difference at {index} index."  */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean isIdentical = false;
        int sum = 0;
        int indexBreakage = 0;
        int[] arrayA = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arrayB = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int currentIndex = 0; currentIndex < arrayA.length; currentIndex++) {
            if (arrayA[currentIndex] == arrayB[currentIndex]) {
                isIdentical = true;
                sum += arrayA[currentIndex];
            } else {
                isIdentical = false;
                indexBreakage = currentIndex;
                break;
            }
        }
        if (isIdentical) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        } else {
            System.out.printf("Arrays are not identical. Found difference at %d index.", indexBreakage);
        }
    }
}

