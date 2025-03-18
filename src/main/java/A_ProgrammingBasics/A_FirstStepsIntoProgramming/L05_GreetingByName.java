package A_ProgrammingBasics.A_FirstStepsIntoProgramming;

import java.util.*;

public class L05_GreetingByName {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        System.out.printf("Hello, %s!", name);
    }
}
