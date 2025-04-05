package B_Java_Fundamentals.C_Arrays;

import java.util.*;

public class AE02_PascalTriangle {

    /*The triangle may be constructed in the following manner: In row 0 (the topmost row), there is a unique nonzero entry 1.
    Each entry of each subsequent row is constructed by adding the number above and to the left with the number above and to the right,
    treating blank entries as 0. For example, the initial number in the first (or any other) row is 1 (the sum of 0 and 1),
    whereas the numbers 1 and 3 in the third row are added to produce the number 4 in the fourth row.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rowsCount = Integer.parseInt(scanner.nextLine());
        int[] previousRow = new int[]{1};
        System.out.println(previousRow[0]);

        for (int row = 2; row <= rowsCount; row++) {
            int[] currentRow = new int[row];
            currentRow[0] = 1;
            currentRow[row - 1] = 1;
            for (int element = 1; element < row - 1; element++) {
                currentRow[element] = previousRow[element - 1] + previousRow[element];
            }
            for (int index = 0; index < row; index++) {
                System.out.print(currentRow[index] + " ");
            }
            System.out.println();
            previousRow = currentRow;
        }
    }
}
