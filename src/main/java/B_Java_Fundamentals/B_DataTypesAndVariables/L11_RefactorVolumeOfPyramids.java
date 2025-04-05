package B_Java_Fundamentals.B_DataTypesAndVariables;

import java.util.*;

public class L11_RefactorVolumeOfPyramids {

/*You are given a working code that finds the volume of a pyramid.
However, you should consider that the variables exceed their optimum span and have improper naming.
Also, search for variables that have multiple purposes.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Length: ");
        double length = Double.parseDouble(scanner.nextLine());
        System.out.print("Width: ");
        double width = Double.parseDouble(scanner.nextLine());
        System.out.print("Height: ");
        double height = Double.parseDouble(scanner.nextLine());
        double volume = (length * width * height) / 3;
        System.out.printf("Pyramid Volume: %.2f", volume);
    }
}