package C_Advanced.E_FunctionalProgramming;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class E10_PredicateParty {

/*The Wire's parents are on vacation for the holidays, and he is planning an epic party at home. Unfortunately, his organizational skills are next to non-existent,
so you are given the task of helping him with the reservations. On the first line, you get a list of all the people that are coming.
On the next lines, until you get the "Party!" command, you may be asked to double or remove all the people that apply to the given criteria. There are three different options:

    •	Everyone that has a name starts with a given string.
    •	Everyone that has a name ending with a given string.
    •	Everyone has a name with a given length.

When you print the guests that are coming to the party, you have to print them in ascending order. If nobody is going, print "Nobody is going to the party!".*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        HashSet<String> filters = new HashSet<>();
        String input = scanner.nextLine();

        while (!input.equals("Party!")) {

            String command = input.split("\\s+")[0];
            String filterType = input.split("\\s+")[1];
            String filterParam = input.split("\\s+")[2];
            filters.add(filterType + " " + filterParam);
            List<String> modifiedGuests = new ArrayList<>(guests);
            guests.forEach(guest -> {
                Predicate<String> filterToApply = getPredicate(filterType, filterParam);
                if (command.equals("Double")) {
                    if (filterToApply.test(guest)) {
                        modifiedGuests.add(guest);
                    }
                } else if (command.equals("Remove")) {
                    modifiedGuests.removeIf(filterToApply);
                }
            });
            guests = modifiedGuests;
            input = scanner.nextLine();
        }

        if (!guests.isEmpty()) {
            Collections.sort(guests);
            System.out.printf("%s are going to the party!", String.join(", ", guests));
        } else {
            System.out.println("Nobody is going to the party!");
        }
    }

    public static Predicate<String> getPredicate(String filterType, String filterParam) {

        switch (filterType) {
            case "StartsWith" -> {
                return s -> s.startsWith(filterParam);
            }
            case "EndsWith" -> {
                return s -> s.endsWith(filterParam);
            }
            case "Length" -> {
                return s -> s.length() == Integer.parseInt(filterParam);
            }
        }
        return null;
    }
}
