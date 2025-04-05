package B_Java_Fundamentals.G_AssociativeArraysAndStreamAPI;

import java.util.*;
import java.util.stream.*;

public class E07_LegendaryFarming {

/*You are playing a game, and your goal is to win a legendary item - any legendary item will be good enough.

However, it's a tedious process and requires quite a bit of farming. The possible items are:
    •	"Shadowmourne" - requires 250 Shards
    •	"Valanyr" - requires 250 Fragments
    •	"Dragonwrath" - requires 250 Motes

"Shards", "Fragments", and "Motes" are the key materials (case-insensitive), and everything else is junk. You will be given lines of input in the format:
"{quantity1} {material1} {quantity2} {material2} … {quantityN} {materialN}" / 3 Motes 5 stones 5 Shards 6 leathers 255 fragments 7 Shards

Keep track of the key materials - the first one that reaches 250, wins the race.
At that point, you have to print that the corresponding legendary item is obtained.
In the end, print the remaining shards, fragments, and motes in the format:

    "shards: {numberOfShards}
    fragments: {numberOfFragments}
    motes: {numberOfMotes}"

Finally, print the collected junk items in the order of appearance.

Input:
    •	Each line comes in the following format: "{quantity1} {material1} {quantity2} {material2} … {quantityN} {materialN}"
Output:
    •	On the first line, print the obtained item in the format: "{Legendary item} obtained!" .
    •	On the next three lines, print the remaining key materials.
    •	On the several final lines, print the junk items.
    •	All materials should be printed in the format: "{material}: {quantity}".
    •	The output should be lowercase, except for the first letter of the legendary.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> materials = new LinkedHashMap<>();
        materials.put("shards", 0);
        materials.put("fragments", 0);
        materials.put("motes", 0);
        Map<String, Integer> junk = new LinkedHashMap<>();
        boolean foundLegendaryItem = false;

        while (!foundLegendaryItem) {

            List<String> inputData = Arrays.stream(scanner.nextLine().toLowerCase().split("\\s+")).collect(Collectors.toList());

            while (!inputData.isEmpty()) {

                String currentMaterial = inputData.get(1);
                int quantity = Integer.parseInt(inputData.get(0));
                inputData.remove(0);
                inputData.remove(0);
                if (currentMaterial.equals("shards") || currentMaterial.equals("fragments") || currentMaterial.equals("motes")) {
                    int currentQuantity = materials.get(currentMaterial);
                    materials.put(currentMaterial, currentQuantity + quantity);

                    if (materials.get(currentMaterial) >= 250) {
                        foundLegendaryItem = true;
                        String legendaryItem = "";
                        switch (currentMaterial) {
                            case "shards" -> legendaryItem = "Shadowmourne";
                            case "fragments" -> legendaryItem = "Valanyr";
                            case "motes" -> legendaryItem = "Dragonwrath";
                        }
                        System.out.printf("%s obtained!%n", legendaryItem);
                        materials.put(currentMaterial, materials.get(currentMaterial) - 250);
                        break;
                    }
                } else {
                    if (junk.containsKey(currentMaterial)) {
                        junk.put(currentMaterial, junk.get(currentMaterial) + quantity);
                    } else {
                        junk.put(currentMaterial, quantity);
                    }
                }
            }
        }
        materials.forEach((material, quantity) -> System.out.printf("%s: %d%n", material, quantity));
        junk.forEach((material, quantity) -> System.out.printf("%s: %d%n", material, quantity));
    }
}
