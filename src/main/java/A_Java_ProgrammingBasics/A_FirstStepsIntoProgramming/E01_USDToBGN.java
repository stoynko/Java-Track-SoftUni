package A_Java_ProgrammingBasics.A_FirstStepsIntoProgramming;

import java.util.*;

public class E01_USDToBGN {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double usdValue = 1.79549;
        double input = Double.parseDouble(scanner.nextLine());
        double result = usdValue * input;

        System.out.println(result);
    }
}
