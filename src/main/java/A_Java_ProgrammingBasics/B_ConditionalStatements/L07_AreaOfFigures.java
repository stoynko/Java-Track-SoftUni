package A_Java_ProgrammingBasics.B_ConditionalStatements;

import java.util.*;

public class L07_AreaOfFigures {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String figure = scanner.nextLine();

        if (figure.equals("square")) {
            double a = Double.parseDouble(scanner.nextLine());
            double area = a * a;
            System.out.printf("%.3f", area);
        } else if (figure.equals("rectangle")) {
            double a = Double.parseDouble(scanner.nextLine());
            double b = Double.parseDouble(scanner.nextLine());
            double area = a * b;
            System.out.printf("%.3f", area);
        } else if (figure.equals("circle")) {
            double r = Double.parseDouble(scanner.nextLine());
            double area = r * r * Math.PI;
            System.out.printf("%.3f", area);
        } else if (figure.equals("triangle")) {
            double b = Double.parseDouble(scanner.nextLine());
            double h = Double.parseDouble(scanner.nextLine());
            double area = (b * h) / 2;
            System.out.printf("%.3f", area);
        }
    }
}