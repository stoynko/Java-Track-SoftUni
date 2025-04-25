package A_Java_ProgrammingBasics.D_ForLoop;

import java.util.*;

public class E05_Salary {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int openedTabs = Integer.parseInt(scanner.nextLine());
        double salary = Double.parseDouble(scanner.nextLine());
        int penalty = 0;

        for (int i = 1; i <= openedTabs; i++) {
            String website = scanner.nextLine();
            switch (website) {
                case "Facebook":
                    penalty = 150;
                    break;
                case "Instagram":
                    penalty = 100;
                    break;
                case "Reddit":
                    penalty = 50;
                    break;
                default:
                    break;
            }
            salary -= penalty;
            penalty = 0;

        }
        if (salary <= 0) {
            System.out.println("You have lost your salary.");
        } else
            System.out.printf("%d", (int) salary);
    }
}