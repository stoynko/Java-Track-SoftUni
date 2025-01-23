package C_Advanced.C_SetsAndDictionariesAdvanced;

import java.util.*;

public class L02_SoftUniParty {

/*There is a party in SoftUni. Many guests are invited, and they are two types: VIP and regular.
When a guest comes, you have to check if he/she exists on any of the two reservation lists. All reservation numbers will be with 8 chars. All VIP numbers start with a digit.
There will be 2 command lines:
    •	First is "PARTY" - the party is on, and guests are coming.
    •	The second is "END" - then the party is over, and no more guests will come.

The output shows all guests who didn't come to the party (VIP must be first).*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        TreeSet<String> vipReservations = new TreeSet<>();
        TreeSet<String> standardReservations = new TreeSet<>();

        while (!input.equals("PARTY")) {
            if (Character.isDigit(input.charAt(0))) {
                vipReservations.add(input);
            } else {
                standardReservations.add(input);
            }
            input = scanner.nextLine();
        }

        String guestReservation = scanner.nextLine();

        while (!guestReservation.equals("END")) {

            if (Character.isDigit(guestReservation.charAt(0))) {
                vipReservations.remove(guestReservation);
            } else {
                standardReservations.remove(guestReservation);
            }
            guestReservation = scanner.nextLine();
        }

        System.out.println(vipReservations.size() + standardReservations.size());
        for (String reservation : vipReservations) {
            System.out.println(reservation);
        }
        for (String reservation : standardReservations) {
            System.out.println(reservation);
        }
    }
}