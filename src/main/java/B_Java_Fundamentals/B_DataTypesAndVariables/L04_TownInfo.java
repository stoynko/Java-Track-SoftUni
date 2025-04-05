package B_Java_Fundamentals.B_DataTypesAndVariables;

import java.util.*;

public class L04_TownInfo {

/*You will be given 3 lines of input. On the first line, you will be given the name of the town,
on the second – the population, and on the third – the area.
Use the correct data types and print the result in the following format:

    "Town {town name} has population of {population} and area {area} square km.".*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String cityName = scanner.nextLine();
        long cityPopulation = Integer.parseInt(scanner.nextLine());
        short cityArea = Short.parseShort(scanner.nextLine());

        System.out.printf("Town %s has population of %d and area %d square km.", cityName, cityPopulation, cityArea);
    }
}