package C_SetsAndDictionariesAdvanced;

import java.util.*;

public class L01_ParkingLot {

/*Write a program that:
    o	Records car numbers for every car that enters the parking lot.
    o	Removes car number when the car is out.
When the parking lot is empty, print "Parking Lot is Empty".

    Input:
        o	The input will be a string in the format "{direction, carNumber}".
        o	The input ends with the string "END".
    Output:
        o	Print the output with all car numbers which are in the parking lot.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        LinkedHashSet<String> parkedCars = new LinkedHashSet<>();

        while (!input.equals("END")) {
            String direction = input.split(",\\s+")[0];
            String registrationNumber = input.split(",\\s+")[1];

            if (direction.equals("IN")) {
                parkedCars.add(registrationNumber);
            } else {
                parkedCars.remove(registrationNumber);
            }

            input = scanner.nextLine();
        }

        if (!parkedCars.isEmpty()) {
            for (String carRegistration : parkedCars) {
                System.out.println(carRegistration);
            }
        } else {
            System.out.println("Parking Lot is Empty");
        }
    }
}