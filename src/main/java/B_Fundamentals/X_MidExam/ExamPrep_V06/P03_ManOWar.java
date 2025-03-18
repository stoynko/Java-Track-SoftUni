package B_Fundamentals.X_MidExam.ExamPrep_V06;

import java.util.*;
import java.util.stream.*;

public class P03_ManOWar {

/*The pirates encounter a huge Man-O-War at sea.

Create a program that tracks the battle and either chooses a winner or prints a stalemate. On the first line, you will receive the status of the pirate ship,
which is a string representing integer sections separated by ">". On the second line, you will receive the same type of status, but for the warship:

"{section1}>{section2}>{section3}… {sectionN}"

On the third line, you will receive the maximum health capacity a section of the ship can reach.
The following lines represent commands until "Retire":
    •	"Fire {index} {damage}" - the pirate ship attacks the warship with the given damage at that section. Check if the index is valid and if not, skip the command.
        If the section breaks (health <= 0) the warship sinks, print the following and stop the program: "You won! The enemy ship has sunken."
    •	"Defend {startIndex} {endIndex} {damage}" - the warship attacks the pirate ship with the given damage at that range (indexes are inclusive).
        Check if both indexes are valid and if not, skip the command. If the section breaks (health <= 0) the pirate ship sinks, print the following and stop the program:
        "You lost! The pirate ship has sunken."
    •	"Repair {index} {health}" - the crew repairs a section of the pirate ship with the given health. Check if the index is valid and if not, skip the command.
        The health of the section cannot exceed the maximum health capacity.
    •	"Status" - prints the count of all sections of the pirate ship that need repair soon, which are all sections that are lower than 20% of the maximum health capacity. Print the following:
        "{count} sections need repair."

In the end, if a stalemate occurs, print the status of both ships, which is the sum of their individual sections, in the following format:
    "Pirate ship status: {pirateShipSum}
    Warship status: {warshipSum}"

Input:
    •	On the 1st line, you are going to receive the status of the pirate ship (integers separated by '>').
    •	On the 2nd line, you are going to receive the status of the warship.
    •	On the 3rd line, you will receive the maximum health a section of a ship can reach.
    •	On the following lines, until "Retire", you will be receiving commands.
Output:
    •	Print the output in the format described above.
Constraints:
    •	The section numbers will be integers in the range [1….1000].
    •	The indexes will be integers [-200….200].
    •	The damage will be an integer in the range [1….1000].
    •	The health will be an integer in the range [1….1000].*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> pirateShip = Arrays.stream(scanner.nextLine().split(">")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> warShip = Arrays.stream(scanner.nextLine().split(">")).map(Integer::parseInt).collect(Collectors.toList());
        int healthMaximum = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("Retire")) {
            String[] actions = input.split(" ");
            String action = actions[0];
            switch (action) {
                case "Fire" -> {
                    int shipSection = Integer.parseInt(actions[1]);
                    if (checkForValidIndex(warShip, shipSection)) {
                        int damage = Integer.parseInt(actions[2]);
                        int newSectionHealth = warShip.get(shipSection) - damage;
                        if (newSectionHealth <= 0) {
                            System.out.println("You won! The enemy ship has sunken.");
                            return;
                        } else {
                            warShip.set(shipSection, newSectionHealth);
                        }
                    }
                }
                case "Defend" -> {
                    int shipSectionFrom = Integer.parseInt(actions[1]);
                    int shipSectionTo = Integer.parseInt(actions[2]);
                    if (checkForValidIndex(pirateShip, shipSectionFrom)) {
                        if (checkForValidIndex(pirateShip, shipSectionTo)) {
                            int damage = Integer.parseInt(actions[3]);
                            for (int currentSection = shipSectionFrom; currentSection <= shipSectionTo; currentSection++) {
                                int newSectionHealth = pirateShip.get(currentSection) - damage;
                                if (newSectionHealth <= 0) {
                                    System.out.println("You lost! The pirate ship has sunken.");
                                    return;
                                } else {
                                    pirateShip.set(currentSection, newSectionHealth);
                                }
                            }
                        }
                    }
                }
                case "Repair" -> {
                    int shipSection = Integer.parseInt(actions[1]);
                    if (checkForValidIndex(pirateShip, shipSection)) {
                        int repairValue = Integer.parseInt(actions[2]);
                        if ((repairValue + pirateShip.get(shipSection) > healthMaximum)) {
                            pirateShip.set(shipSection, healthMaximum);
                        } else {
                            int newSectionHealth = pirateShip.get(shipSection) + repairValue;
                            pirateShip.set(shipSection, newSectionHealth);
                        }
                    }
                }
                case "Status" -> {
                    int sectionsToRepair = 0;
                    for (int section : pirateShip) {
                        if ((double) section < (healthMaximum * 0.2)) {
                            sectionsToRepair++;
                        }
                    }
                    System.out.printf("%d sections need repair.%n", sectionsToRepair);
                }
            }
            input = scanner.nextLine();
        }
        int pirateShipSum = 0;
        int warShipSum = 0;
        for (int section : pirateShip) {
            pirateShipSum += section;
        }
        for (int section : warShip) {
            warShipSum += section;
        }
        System.out.printf("Pirate ship status: %d%n", pirateShipSum);
        System.out.printf("Warship status: %d%n", warShipSum);
    }

    private static boolean checkForValidIndex(List<Integer> list, int index) {
        return index >= 0 && index < list.size();
    }
}
