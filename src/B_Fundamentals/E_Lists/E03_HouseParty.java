package B_Fundamentals.E_Lists;

import java.util.*;

public class E03_HouseParty {

/*Write a program that keeps track of guests going to a house party.
On the first input line, you are going to receive how many commands you are going to have.
 On the next lines you are going to receive some of the following inputs:

•	"{name} is going!"
•	"{name} is not going!"

If you receive the first type of input, you have to add the person if he/she is not on the list.
If he/she is in the list, print on the console: "{name} is already in the list!".
If you receive the second type of input, you must remove the person if he/she is on the list.
If not, print: "{name} is not in the list!". In the end, print all guests.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> guests = new ArrayList<>();

        for (int count = 0; count < n; count++) {
            String input = scanner.nextLine();
            List<String> elements = List.of(input.split(" "));
            String guestName = elements.get(0);

            if (elements.size() < 4) {
                if (guests.contains(guestName)) {
                    System.out.printf("%s is already in the list!%n", guestName);
                } else {
                    guests.add(guestName);
                }
            } else {
                if (guests.contains(guestName)) {
                    guests.remove(guestName);
                } else {
                    System.out.printf("%s is not in the list!%n", guestName);
                }
            }
        }
        for (String guest : guests) {
            System.out.println(guest);
        }
    }
}