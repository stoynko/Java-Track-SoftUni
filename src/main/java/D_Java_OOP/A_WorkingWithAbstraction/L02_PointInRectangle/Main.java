package D_Java_OOP.A_WorkingWithAbstraction.L02_PointInRectangle;

import java.util.*;

public class Main {

/*Create a class Point and a class Rectangle.
The Point should hold coordinates X and Y and the Rectangle should hold 2 Points – its bottom left and top right corners.
In the Rectangle class, you should implement a contains(Point point) method that returns true or false,
based on whether the Point given as an attribute is inside or outside the Rectangle object. Points on the side of a Square are considered inside.

Input:
    •	On the first line read the coordinates of the bottom left and top right corner of the Rectangle in the format:
        "{bottomLeftX} {bottomLeftY} {topRightX} {topRightY}".
    •	On the second line, read an integer N and on the next N lines, read the coordinates of points.
Output:
    •	For each point, print out the result of the Contains() method. */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] coordinates = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Point bottomleft = new Point(coordinates[0], coordinates[1]);
        Point topRight = new Point(coordinates[2], coordinates[3]);
        Rectangle rectangle = new Rectangle(bottomleft, topRight);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {

            int[] pointCoordinates = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int pointX = pointCoordinates[0];
            int pointY = pointCoordinates[1];
            Point point = new Point(pointX, pointY);
            System.out.println(rectangle.contains(point));
        }
    }
}
