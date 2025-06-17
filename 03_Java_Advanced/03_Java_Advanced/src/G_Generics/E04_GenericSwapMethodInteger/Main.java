package G_Generics.E04_GenericSwapMethodInteger;

import java.util.*;

public class Main {

/*Use the description of the previous problem but now, test your list of generic boxes with Integers.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Box<Integer> genericBox = new Box<>();
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(scanner.nextLine());
            genericBox.add(input);
        }
        String[] command = scanner.nextLine().split(" ");
        int indexA = Integer.parseInt(command[0]);
        int indexB = Integer.parseInt(command[1]);
        genericBox.swap(indexA, indexB);
        System.out.println(genericBox);
    }
}
