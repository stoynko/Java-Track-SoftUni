package B_Java_Fundamentals.C_Arrays;

import java.util.*;

public class E01_Train {

/*You will be given a count of wagons in a train n. On the next n lines,
you will receive how many people will get on that wagon. In the end,
print the whole train and the sum of the people on the train.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int wagonCount = Integer.parseInt(scanner.nextLine());
        int[] passengers = new int[wagonCount];
        int passengersSum = 0;

        for (int i = 0; i <= wagonCount; i++) {
            passengers[i] = Integer.parseInt(scanner.nextLine());
            passengersSum += passengers[i];
            System.out.printf("%d ", passengers[i]);
        }
        System.out.printf("%n%d", passengersSum);
    }
}
