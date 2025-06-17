package G_AssociativeArraysAndStreamAPI;

import java.util.*;

public class E09_ForceBook {

/*The force users are struggling to remember which side is the different forceUsers from because they switch them too often.
So you are tasked to create a web application to manage their profiles. You will receive several input lines in one of the following formats:
"{force_side} | {force_user}"
"{force_user} -> {force_side}"

The "force_user" and "force_side" are strings containing any character.
If you receive "force_side | force_user":
    •	If there is no such force user and no such force side -> create a new force side and add the force user to the corresponding side.
    •	Only if there is no such force user on any force side -> add the force user to the corresponding side.
    •	If there is such force user already -> skip the command and continue to the next operation.
If you receive a "force_user -> force_side":
    •	If there is such force user already -> change their side.
    •	If there is no such force user on any force side -> add the force user to the corresponding force side.
    •	If there is no such force user and no such force side -> create a new force side and add the force user to the corresponding side.
    •	Then you should print on the console: "{force_user} joins the {force_side} side!".

You should end your program when you receive the command "Lumpawaroo". At that point, you should print each force side.
For each side, print the force users. In case there are no force users on a side, you shouldn't print the side information.

Input / Constraints:
    •	The input comes in the form of commands in one of the formats specified above.
    •	The input ends when you receive the command "Lumpawaroo".
Output:
    •	As output for each force side, you must print all the force users.
    •	The output format is:
        "Side: {forceSide}, Members: {forceUsers.Count}
        ! {forceUser}
        ! {forceUser}
        ! {forceUser}"
    •	In case there are NO forceUsers, don't print this side.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, List<String>> sides = new LinkedHashMap<>();
        while (!input.equals("Lumpawaroo")) {

            if (input.contains("|")) {

                String forceSide = input.split("\\| ")[0].trim();
                String forceUser = input.split("\\|")[1].trim();
                boolean isUserRegistered = false;

                if (!sides.containsKey(forceSide)) {
                    sides.put(forceSide, new ArrayList<>());
                }

                for (Map.Entry<String, List<String>> entry : sides.entrySet()) {
                    if (entry.getValue().contains(forceUser)) {
                        isUserRegistered = true;
                    }
                }

                if (!isUserRegistered) {
                    sides.get(forceSide).add(forceUser);
                }

            } else if (input.contains("->")) {

                String forceUser = input.split(" -> ")[0].trim();
                String forceSide = input.split(" -> ")[1].trim();

                for (Map.Entry<String, List<String>> entry : sides.entrySet()) {
                    entry.getValue().remove(forceUser);
                }

                if (sides.containsKey(forceSide)) {
                    sides.get(forceSide).add(forceUser);
                } else {
                    sides.put(forceSide, new ArrayList<>());
                    sides.get(forceSide).add(forceUser);
                }
                System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : sides.entrySet()) {
            String forceSide = entry.getKey();
            List<String> forceUsers = entry.getValue();

            if (!forceUsers.isEmpty()) {
                System.out.printf("Side: %s, Members: %d%n", forceSide, forceUsers.size());
                forceUsers.forEach(forceUser -> System.out.printf("! %s%n", forceUser));
            }
        }
    }
}