package A_Java_ProgrammingBasics.A_FirstStepsIntoProgramming;

import java.util.*;

public class E02_RadiansToDegrees {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double radians = Double.parseDouble(scanner.nextLine());
        double degrees = (radians * 180) / Math.PI;

        System.out.println(degrees);
    }
}
