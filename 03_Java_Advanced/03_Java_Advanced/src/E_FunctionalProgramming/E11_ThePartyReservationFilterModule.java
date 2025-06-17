package E_FunctionalProgramming;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class E11_ThePartyReservationFilterModule {

/*You are a young and talented developer. The first task you need to do is to implement a filtering module to a party reservation software.
First, The Party Reservation Filter Module (TPRF Module for short) is passed a list with invitations.
Next, the TPRF receives a sequence of commands that specify if you need to add or remove a given filter.

TPRF Commands are in the given format:
    •	"{command;filter type;filter parameter}".

You can receive the following TPRF commands:
    •	"Add filter", "Remove filter" or "Print".

The possible TPRF filter types are:
    •	"Starts with"
    •	"Ends with"
    •	"Length"
    •	"Contains"

All TPRF filter parameters will be a string (or an integer for the length filter).
The input will end with a "Print" command.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        HashSet<String> filters = new HashSet<>();
        String input = scanner.nextLine();

        while (!input.equals("Print")) {

            String command = input.split(";")[0];
            String filterType = input.split(";")[1];
            String filterParam = input.split(";")[2];

            if (command.equals("Add filter")) {
                filters.add(filterType + ";" + filterParam);
            } else if (command.equals("Remove filter")) {
                filters.remove(filterType + ";" + filterParam);
            }
            input = scanner.nextLine();
        }
        filters.forEach(filter -> {
            Predicate<String> filterToApply = getPredicate(filter);
            guests.removeIf(filterToApply);
        });

        guests.forEach(guest -> System.out.print(guest + " "));
    }

    private static Predicate<String> getPredicate(String filter) {
        String filterType = filter.split(";")[0];
        String filterParam = filter.split(";")[1];

        switch (filterType) {
            case "Starts with" -> {return s -> s.startsWith(filterParam);}
            case "Ends with" -> {return s -> s.endsWith(filterParam);}
            case "Length" -> {return s-> s.length() == Integer.parseInt(filterParam);}
            case "Contains" -> {return s-> s.contains(filterParam);}
        }
    return null;
    }
}
