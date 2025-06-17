package D_ForLoop;

import java.util.*;

public class E07_TrekkingMania {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int groupsCount = Integer.parseInt(scanner.nextLine());
        int climbersTotal = 0;
        int musCounter = 0;
        int monCounter = 0;
        int kCounter = 0;
        int k2Counter = 0;
        int eCounter = 0;

        for (int i = 0; i < groupsCount; i++) {
            int groupMembers = Integer.parseInt(scanner.nextLine());
            climbersTotal += groupMembers;
            if (groupMembers <= 5) {
                musCounter += groupMembers;
            } else if (groupMembers > 5 && groupMembers <= 12) {
                monCounter += groupMembers;
            } else if (groupMembers > 12 && groupMembers <= 25) {
                kCounter += groupMembers;
            } else if (groupMembers > 25 && groupMembers <= 40) {
                k2Counter += groupMembers;
            } else {
                eCounter += groupMembers;
            }
        }
        System.out.printf("%.2f%%\n", (double) musCounter / climbersTotal * 100);
        System.out.printf("%.2f%%\n", (double) monCounter / climbersTotal * 100);
        System.out.printf("%.2f%%\n", (double) kCounter / climbersTotal * 100);
        System.out.printf("%.2f%%\n", (double) k2Counter / climbersTotal * 100);
        System.out.printf("%.2f%%\n", (double) eCounter / climbersTotal * 100);
    }
}