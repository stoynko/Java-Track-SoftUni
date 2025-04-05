package B_Java_Fundamentals.D_Methods;

import java.util.*;

public class L06_CalculateRectangleArea {

//Create a method that calculates and returns the area of a rectangle by given width and length*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        System.out.println(CalculateRectangleArea(width, length));
    }

    private static int CalculateRectangleArea(int width, int length) {
        return width * length;
    }
}