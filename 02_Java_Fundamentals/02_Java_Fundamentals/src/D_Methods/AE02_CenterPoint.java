package D_Methods;

import java.util.*;

public class AE02_CenterPoint {

/*You are given the coordinates of two points on a Cartesian coordinate system - X1, Y1, X2, and Y2.
Create a method that prints the point that is closest to the center of the coordinate system (0, 0) in the format (X, Y).
If the points are at the same distance from the center, print only the first one.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int pointA_X = Integer.parseInt(scanner.nextLine());
        int pointA_Y = Integer.parseInt(scanner.nextLine());
        int pointB_X = Integer.parseInt(scanner.nextLine());
        int pointB_Y = Integer.parseInt(scanner.nextLine());
        int[] closest = new int[2];

        if (calculateDistanceFromOrigin(pointA_X, pointA_Y) <= calculateDistanceFromOrigin(pointB_X, pointB_Y)) {
            setClosest(closest, pointA_X, pointA_Y);
        } else {
            setClosest(closest, pointB_X, pointB_Y);
        }
        System.out.printf("(%d, %d)", closest[0], closest[1]);
    }

    private static int calculateDistanceFromOrigin(int x, int y) {
        return (int) Math.sqrt(x * x + y * y);
    }

    private static void setClosest(int[] array, int X, int Y) {
        array[0] = X;
        array[1] = Y;
    }
}