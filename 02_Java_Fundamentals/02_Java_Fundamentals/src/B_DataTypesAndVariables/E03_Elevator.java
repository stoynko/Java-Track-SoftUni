package B_DataTypesAndVariables;

import java.util.*;

public class E03_Elevator {

/*Calculate how many courses will be needed to elevate n persons by using an elevator with a capacity of p persons.
The input holds two lines: the number of people n and the capacity p of the elevator.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        byte persons = Byte.parseByte(scanner.nextLine());
        byte capacity = Byte.parseByte(scanner.nextLine());

        float count = persons / (float) capacity;

        System.out.printf("%.0f", Math.ceil(count));
    }
}