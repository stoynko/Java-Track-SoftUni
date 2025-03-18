package C_Advanced.Z_Exam;

import java.util.*;
import java.util.stream.*;

public class E01_MedievalAlchemy {

/*You will have to memorize all crafted potion names. The alchemist aims to craft all of the following potions:

        Potion	                Energy Level
    Brew of Immortality	            110
    Essence of Resilience           100
    Draught of Wisdom	            90
    Potion of Agility	            80
    Elixir of Strength	            70

Input Data:
    •	On the first line you will receive quantities of different substances the alchemist has stored, separated by a comma and space (", ").
    •	On the second line you will receive levels of crystal energy, also separated by a comma and space (", "). See the Examples section.

End Conditions:

The alchemist's quest will end immediately, under the following circumstances:
    •	The alchemist has successfully crafted all five potions.
    •	If the alchemist runs out of substances or crystals before crafting all five potions.

- Alchemy Process
Once per day, the alchemist enters a secret room where he carefully stores his substances and crystals.
    •	To maintain their stability, he has stored the substances in a special container, placing each one on top of the previous.
        When he needs a substance, he takes the last one he stored.
    •	He uses crystals as an energy source and always takes the first crystal.
- Crafting Logic
Each day, the alchemist combines the last stored substance with the first crystal in line to try to craft a new potion:
    •	The alchemist will not attempt to craft the same potion if it has already been crafted.
        o	In this case, he tries to craft the next possible potion (follow the instructions below).
    •	If the sum of the substance and crystal energy is equal to one of the required energy levels from the list of potions and it has not been
        crafted yet, the potion is successfully crafted and should be memorized.
        o	The substance is consumed and disappears from its respective collection.
        o	The crystal is exhausted and disappears from its collection too.
    •	If the sum does not exactly match any of the required energy levels for the potions:
        o	The alchemist tries to use the energy to craft the potion with the highest possible energy requirements which is less than the combined energy:
        o	The used substance is removed from its collection.
        o	The crystal is returned to the back of the sequence with a reduced (decreased by 20 units) energy level.
        o	Do not return zero values to the collection.
    •	If the crystal's energy drops to 0 or less, it is removed entirely.
        o	If there is no potion with an energy requirement that matches or is less than the combined energy, the attempt fails.
        o	The substance is lost entirely (remove it).
        o	The crystal is returned to the back of the sequence with a reduced (decreased by 5 units) energy level.

        Do not return zero values to the collection.
            o	If the crystal's energy drops to 0 or less, it is removed entirely.
Input:
    •	On the first line, you will receive a sequence of integers, representing the substances, separated by a comma and a single space (', ').
    •	On the second line, you will receive a sequence of integers, representing all crystals' energy levels,
        separated by a comma and a single space (', '). See the Examples section.

Output:
    •	On the first line, print the outcome based on whether all five potions were crafted successfully:
        o	If all potions are crafted: "Success! The alchemist has forged all potions!"
        o	If not all potions are crafted: "The alchemist failed to complete his quest."
    •	On the next line, print the crafted potions in the order they were prepared: "Crafted potions: {potion1}, {potion2} … {potionn}"
        o	If no potions were crafted, skip this line.
    •	Finally, print the state of both sequences on separate lines.
        o	If a sequence is empty, skip its line.
        o	Substances must be printed in stack order (from the last to the first element).
            "Substances: {substancen}, {substancen-1} … {substance1}"
            "Crystals: {crystal1}, {crystal2} … {crystaln}"
Constraints:
    •	All given numbers will be valid integers in the range [1 - 120]
    •	Both sequences will initially have at least one element */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> substancesStack = new ArrayDeque<>();
        ArrayDeque<Integer> crystalQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt).forEach(substancesStack::push);
        Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt).forEach(crystalQueue::offer);
        List<String> potionRecipes = new ArrayList<>(List.of("Brew of Immortality", "Essence of Resilience", "Draught of Wisdom", "Potion of Agility", "Elixir of Strength"));
        List<Integer> potionEnergyValues = new ArrayList<>(List.of(110, 100, 90, 80, 70));
        List<String> craftedPotions = new ArrayList<>();
        boolean hasCrafted = false;

        while (!substancesStack.isEmpty() && !crystalQueue.isEmpty() && craftedPotions.size() != 5) {

            int substance = substancesStack.pop();
            int crystalEnergy = crystalQueue.poll();
            int solution = substance + crystalEnergy;

            for (int index = 0; index < potionEnergyValues.size(); index++) {
                if (solution == potionEnergyValues.get(index)) {
                    potionEnergyValues.remove(index);
                    craftedPotions.add(potionRecipes.get(index));
                    potionRecipes.remove(index);
                    hasCrafted = true;
                    break;
                }
                if (index == potionEnergyValues.size() - 1) {
                    hasCrafted = false;
                }
            }

            if (!hasCrafted) {
                for (int index = 0; index < potionEnergyValues.size(); index++) {
                    if (solution > potionEnergyValues.get(index)) {
                        potionEnergyValues.remove(index);
                        craftedPotions.add(potionRecipes.get(index));
                        potionRecipes.remove(index);
                        hasCrafted = true;
                        break;
                    }
                    if (index == potionEnergyValues.size() - 1) {
                        hasCrafted = false;
                    }
                }
                if (hasCrafted) {
                    crystalEnergy -= 20;
                    if (crystalEnergy > 0) {
                        crystalQueue.offer(crystalEnergy);
                    }
                }
            }

            if (!hasCrafted) {
                crystalEnergy -= 5;
                if (crystalEnergy > 0) {
                    crystalQueue.offer(crystalEnergy);
                }
            }
        }

        System.out.println(craftedPotions.size() == 5 ? "Success! The alchemist has forged all potions!" : "The alchemist failed to complete his quest.");
        if (!craftedPotions.isEmpty()) {
            System.out.printf("Crafted potions: %s\n", String.join(", ", craftedPotions));
        }
        if (!substancesStack.isEmpty()) {
            String remainingSubstances = substancesStack.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.printf("Substances: %s\n", remainingSubstances);
        }
        if (!crystalQueue.isEmpty()) {
            String remainingCrystals = crystalQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.printf("Crystals: %s\n", remainingCrystals);
        }
    }
}

