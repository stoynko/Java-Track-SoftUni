package C_Java_Advanced.C_SetsAndDictionariesAdvanced;

import java.util.*;
import java.util.stream.*;

public class E11_LegendaryFarming {

/*You've beaten all the content, and the last thing left to accomplish is to own a legendary item. However, it's a tedious process and requires quite a bit of farming.
Anyway, you are not too pretentious – any legendary will do. The possible items are:
    •	Shadowmourne – requires 250 Shards;
    •	Valanyr – requires 250 Fragments;
    •	Dragonwrath – requires 250 Motes;
Shards, Fragments, and Motes are the key materials, all else is junk. You will be given lines of input, such as 2 motes 3 ores 15 stones.
Keep track of the key materials - the first that reaches the 250 mark wins the race. At that point, print the corresponding legendary obtained.
Then, print the remaining shards, fragments, and motes, ordered by quantity in descending order, each on a new line. Finally, print the collected junk items in alphabetical order.

    Input:
        •	Each line of input is in format "{quantity} {material} {quantity} {material} … {quantity} {material}".
    Output:
        •	On the first line, print the obtained item in the format "{Legendary item} obtained!".
        •	On the next three lines, print the remaining key materials in descending order by quantity.
            o	If two key materials have the same quantity, print them in alphabetical order.
        •	On the final several lines, print the junk items in alphabetical order.
            o	All materials are printed in format "{material}: {quantity}".
            o	All output should be lowercase, except the first letter of the legendary.
    Constraints:
        •	The quantity-material pairs are between 1 and 25 per line.
        •	The number of lines is in the range [1..10].
        •	All materials are case-insensitive.
        •	Allowed time: 250ms/16MB.*/

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

        materials.entrySet().stream()
                .sorted((entry1, entry2) -> {
                    int valueCompare = entry2.getValue().compareTo(entry1.getValue());
                    if (valueCompare != 0) {
                        return valueCompare;
                    }
                    return entry1.getKey().compareTo(entry2.getKey());
                })
                .forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));

        junk.entrySet().stream()
                .sorted((entry1, entry2) -> {
                    return entry1.getKey().compareTo(entry2.getKey());
                })
                .forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));
    }
}