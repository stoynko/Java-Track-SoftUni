package B_Java_Fundamentals.B_DataTypesAndVariables;

import java.util.*;

public class E08_BeerKegs {

/*Write a program that calculates the volume of n beer kegs. You will receive in total 3 * n lines. Every three lines will hold information for a single keg.
First up is the model of the keg, after that is the radius of the keg, and lastly is the height of the keg.
Calculate the volume using the following formula: π * r^2 * h. In the end, print the model of the biggest keg.

You will receive 3 * n lines. Each group of lines will be on a new line:
    •	First – model – string
    •	Second –radius – floating-point number
    •	Third – height – integer number

Print the model of the biggest keg.

Constraints:
    •	n will be in the interval [1…10].
    •	The radius will be a floating-point number in the interval [1…3.402823E+38].
    •	The height will be an integer in the interval [1…2147483647].*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        byte numberKegs = Byte.parseByte(scanner.nextLine());

        String biggestKeg = "";
        double volumeTemp = Double.MIN_VALUE;
        for (int i = 1; i <= numberKegs; i++) {
            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

            double volume = Math.PI * Math.pow(radius, 2) * height;
            if (volume > volumeTemp) {
                biggestKeg = model;
                volumeTemp = volume;
            }
        }
        System.out.println(biggestKeg);
    }
}