package B_Fundamentals.Y_FinalExam.ExamPrep_V02;

import java.util.*;

public class P03_HeroesOfCodeAndLogicVII {

/*You got your hands on the most recent update on the best MMORPG of all time – Heroes of Code and Logic. You want to play it all day long! So cancel all other arrangements and create your party!
On the first line of the standard input, you will receive an integer n – the number of heroes that you can choose for your party.
On the next n lines, the heroes themselves will follow with their hit points and mana points separated by a single space in the following format: "{hero name} {HP} {MP}"
    -	HP stands for hit points and MP for mana points
    -	a hero can have a maximum of 100 HP and 200 MP
After you have successfully picked your heroes, you can start playing the game. You will be receiving different commands, each on a new line, separated by " – ", until the "End" command is given.
There are several actions that the heroes can perform:

"CastSpell – {hero name} – {MP needed} – {spell name}"
    •	If the hero has the required MP, he casts the spell, thus reducing his MP. Print this message:
        o	"{hero name} has successfully cast {spell name} and now has {mana points left} MP!"
    •	If the hero is unable to cast the spell print:
        o	"{hero name} does not have enough MP to cast {spell name}!"
        "TakeDamage – {hero name} – {damage} – {attacker}"
    •	Reduce the hero HP by the given damage amount. If the hero is still alive (his HP is greater than 0) print:
        o	"{hero name} was hit for {damage} HP by {attacker} and now has {current HP} HP left!"
    •	If the hero has died, remove him from your party and print:
        o	"{hero name} has been killed by {attacker}!"
        "Recharge – {hero name} – {amount}"
    •	The hero increases his MP. If it brings the MP of the hero above the maximum value (200), MP is increased to 200. (the MP can't go over the maximum value).
    •	 Print the following message:
        o	"{hero name} recharged for {amount recovered} MP!"
        "Heal – {hero name} – {amount}"
    •	The hero increases his HP. If a command is given that would bring the HP of the hero above the maximum value (100), HP is increased to 100 (the HP can't go over the maximum value).
    •	 Print the following message:
        o	"{hero name} healed for {amount recovered} HP!"
Input:
    •	On the first line of the standard input, you will receive an integer n.
    •	On the following n lines, the heroes themselves will follow with their hit points and mana points separated by a space in the following format.
    •	You will be receiving different commands, each on a new line, separated by " – ", until the "End" command is given.
Output:
    •	Print all members of your party who are still alive, in the following format (their HP/MP need to be indented 2 spaces):
            "{hero name}
            HP: {current HP}
            MP: {current MP}"
Constraints:
    •	The starting HP/MP of the heroes will be valid, 32-bit integers will never be negative or exceed the respective limits.
    •	The HP/MP amounts in the commands will never be negative.
    •	The hero names in the commands will always be valid members of your party. No need to check that explicitly.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> heroesHP = new LinkedHashMap<>();
        Map<String, Integer> heroesMP = new LinkedHashMap<>();

        int numberOfHeroes = Integer.parseInt(scanner.nextLine());

        for (int currentHero = 1; currentHero <= numberOfHeroes; currentHero++) {
            String heroData = scanner.nextLine();
            String heroName = heroData.split("\\s+")[0];
            int heroHP = Integer.parseInt(heroData.split("\\s+")[1]);
            int heroMP = Integer.parseInt(heroData.split("\\s+")[2]);

            if (heroHP > 100) {
                heroHP = 100;
            }
            if (heroMP > 200) {
                heroMP = 200;
            }
            heroesHP.put(heroName, heroHP);
            heroesMP.put(heroName, heroMP);
        }

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String action = input.split(" - ")[0];
            switch (action) {
                case "CastSpell" -> {
                    String heroName = input.split(" - ")[1];
                    int neededMP = Integer.parseInt(input.split(" - ")[2]);
                    String spellName = input.split(" - ")[3];
                    int availableMP = heroesMP.get(heroName);

                    if (availableMP >= neededMP) {
                        heroesMP.put(heroName, availableMP - neededMP);
                        System.out.printf("%s has successfully cast %s and now has %d MP!\n", heroName, spellName, availableMP - neededMP);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!\n", heroName, spellName);
                    }
                }
                case "TakeDamage" -> {
                    String heroName = input.split(" - ")[1];
                    int damage = Integer.parseInt(input.split(" - ")[2]);
                    String attacker = input.split(" - ")[3];
                    int availableHP = heroesHP.get(heroName);
                    if (availableHP - damage > 0) {
                        heroesHP.put(heroName, availableHP - damage);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!\n", heroName, damage, attacker, availableHP - damage);
                    } else {
                        heroesHP.remove(heroName);
                        heroesMP.remove(heroName);
                        System.out.printf("%s has been killed by %s!\n", heroName, attacker);
                    }
                }
                case "Recharge" -> {
                    String heroName = input.split(" - ")[1];
                    int amount = Integer.parseInt(input.split(" - ")[2]);
                    int availableMP = heroesMP.get(heroName);
                    if (availableMP + amount > 200) {
                        heroesMP.put(heroName, 200);
                        System.out.printf("%s recharged for %d MP!\n", heroName, 200 - availableMP);
                    } else {
                        heroesMP.put(heroName, availableMP + amount);
                        System.out.printf("%s recharged for %d MP!\n", heroName, amount);
                    }
                }
                case "Heal" -> {
                    String heroName = input.split(" - ")[1];
                    int amount = Integer.parseInt(input.split(" - ")[2]);
                    int availableHP = heroesHP.get(heroName);
                    if (availableHP + amount > 100) {
                        heroesHP.put(heroName, 100);
                        System.out.printf("%s healed for %d HP!\n", heroName, 100 - availableHP);
                    } else {
                        heroesHP.put(heroName, availableHP + amount);
                        System.out.printf("%s healed for %d HP!\n", heroName, amount);
                    }
                }
            }
            input = scanner.nextLine();
        }
        heroesHP.forEach((heroName, heroHP) -> {
            System.out.println(heroName);
            System.out.printf("  HP: %d\n", heroHP);
            System.out.printf("  MP: %d\n", heroesMP.get(heroName));
        });
    }
}
