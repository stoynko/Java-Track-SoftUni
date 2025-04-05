package B_Java_Fundamentals.X_MidExam.ExamPrep_V05;

import java.util.*;
import java.util.stream.*;

public class P02_MuOnline {

/*You have initial health 100 and initial bitcoins 0. You will be given a string representing the dungeon's rooms.
Each room is separated with '|' (vertical bar): "room1|room2|room3…"
Each room contains a command and a number, separated by space. The command can be:
•	"potion"
    o	You are healed with the number in the second part. But your health cannot exceed your initial health (100).
    o	First print: "You healed for {amount} hp."
    o	After that, print your current health: "Current health: {health} hp."
•	"chest"
    o	You've found some bitcoins, the number in the second part.
    o	Print: "You found {amount} bitcoins."
•	In any other case, you are facing a monster, which you will fight. The second part of the room contains the attack of the monster. You should remove the monster's attack from your health.
    o	If you are not dead (health <= 0), you've slain the monster, and you should print: "You slayed {monster}."
    o	If you've died, print "You died! Killed by {monster}." and your quest is over. Print the best room you've managed to reach: "Best room: {room}"

If you managed to go through all the rooms in the dungeon, print on the following three lines:

"You've made it!
Bitcoins: {bitcoins}
Health: {health}"*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> dungeon = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());
        int health = 100;
        int lostHealth = 0;
        int bitcoins = 0;
        int dungeonProgress = 1;

        while (!dungeon.isEmpty()) {

            String[] command = (dungeon.get(0)).split(" ");
            String action = command[0];

            switch (action) {

                case "potion" -> {
                    int potionValue = Integer.parseInt(command[1]);
                    int healedFor = potionValue;
                    health += potionValue;
                    if (health > 100) {
                        healedFor = potionValue - (health - 100);
                        health = 100;
                    }
                    System.out.printf("You healed for %d hp.%n", healedFor);
                    System.out.printf("Current health: %d hp.%n", health);
                }
                case "chest" -> {
                    int bitcoinsFound = Integer.parseInt(command[1]);
                    System.out.printf("You found %d bitcoins.%n", bitcoinsFound);
                    bitcoins += bitcoinsFound;
                }
                default -> {
                    String monster = action;
                    int damage = Integer.parseInt(command[1]);
                    health -= damage;
                    lostHealth += damage;
                    if (health > 0) {
                        System.out.printf("You slayed %s.%n", monster);
                    } else {
                        System.out.printf("You died! Killed by %s.%n", monster);
                        System.out.printf("Best room: %d", dungeonProgress);
                        return;

                    }
                }
            }
            dungeonProgress++;
            dungeon.remove(0);
        }
        System.out.println("You've made it!");
        System.out.printf("Bitcoins: %d%n", bitcoins);
        System.out.printf("Health: %d%n", health);
    }
}