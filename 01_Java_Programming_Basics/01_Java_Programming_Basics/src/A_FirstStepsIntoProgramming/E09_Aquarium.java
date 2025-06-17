package A_FirstStepsIntoProgramming;

import java.util.*;

public class E09_Aquarium {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        double negativeSpace = Double.parseDouble(scanner.nextLine()) / 100;

        double volume = (length * width * height) * 0.001;
        double total = volume - (volume * negativeSpace);

        System.out.println(total);
    }
}

