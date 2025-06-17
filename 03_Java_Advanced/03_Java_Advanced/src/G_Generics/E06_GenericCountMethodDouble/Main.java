package G_Generics.E06_GenericCountMethodDouble;

import java.util.*;

public class Main {

//Use the description of the previous problem but now, test your list of generic boxes with Doubles.

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Box<Double> genericBox = new Box<>();
        for (int i = 0; i < n; i++) {
            double input = Double.parseDouble(scanner.nextLine());
            genericBox.add(input);
        }
        Double comparator = Double.parseDouble(scanner.nextLine());
        System.out.println(genericBox.compareElements(genericBox.getElements(), comparator));
    }
}
