package A_Java_ProgrammingBasics.A_FirstStepsIntoProgramming;

import java.util.*;

public class E04_VacationBookList {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int pagesPerBook = Integer.parseInt(scanner.nextLine());
        int pagesPerHour = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());

        int timePerBook = pagesPerBook / pagesPerHour;
        int timeNeeded = timePerBook / days;

        System.out.println(timeNeeded);
    }
}
