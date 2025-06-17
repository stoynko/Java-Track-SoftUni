package A_FirstStepsIntoProgramming;

import java.util.*;

public class L06_ConcatenateData {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String firstname = scanner.nextLine();
        String lastName = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String town = scanner.nextLine();

        System.out.printf("You are %s %s, a %d-years old person from %s.", firstname, lastName, age, town);
    }
}
