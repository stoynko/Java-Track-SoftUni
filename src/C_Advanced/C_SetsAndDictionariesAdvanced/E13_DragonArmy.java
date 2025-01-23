package C_Advanced.C_SetsAndDictionariesAdvanced;

import java.util.*;

public class E13_DragonArmy {

/*Heroes III is the best game ever. Everyone loves it, and everyone plays it all the time. John is not an exclusion from this rule.
His favorite units in the game are all types of dragons – black, red, gold, azure, etc… He likes them so much that he gives them names
and keeps logs of their stats: damage, health, and armor. The process of aggregating all the data is quite tedious,
so he would like to have a program doing it. Since he is no programmer, it's your task to help him. You need to categorize dragons
by their type. For each dragon, identified by name, keep information about his stats. Type is preserved as in the input order,
but dragons are sorted alphabetically by name. For each type, you should also print the average damage, health, and armor of the dragons.
For each dragon, print his stats. There may be missing stats in the input, though. If a stat is missing,
you should assign its default values. Default values are as follows: health - 250, damage - 45, and armor - 10.
Missing stat will be marked by null. The input is in the following format "{type} {name} {damage} {health} {armor}".
Any of the integers may be assigned a null value. See the examples below for a better understanding of your task.
If the same dragon is added a second time, the new stats should overwrite the previous ones.
Two dragons are considered equal if they match by both name and type.

Input:
    •	On the first line, you are given the number N -> the number of dragons to follow.
    •	On the next N lines, you are given input in the above-described format. There will be a single space separating each element.
Output:
    •	Print the aggregated data on the console.
    •	For each type, print average stats of its dragons in format "{Type}::({damage}/{health}/{armor})".
    •	Damage, health, and armor should be rounded to two digits after the decimal separator.
    •	For each dragon, print its stats in format "-{Name} -> damage: {damage}, health: {health}, armor: {armor}".
Constraints:
    •	N is in the range [1…100].
    •	The dragon type and name are one word only, starting with a capital letter.
    •	Damage health and armor are integers in the range [0 … 100000] or null.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, TreeMap<String, List<Integer>>> dragonArmy = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String[]inputData = collectDragonInformation(scanner);
            String type = inputData[0];
            String dragon = inputData[1];
            int damage = Integer.parseInt(inputData[2]);
            int health = Integer.parseInt(inputData[3]);
            int armor = Integer.parseInt(inputData[4]);

            if (!dragonArmy.containsKey(type)) {
                dragonArmy.put(type, new TreeMap<>());
                dragonArmy.get(type).put(dragon, new ArrayList<>());
                List<Integer> dragonStats = new ArrayList<>(Arrays.asList(damage, health, armor));
                dragonArmy.get(type).put(dragon, dragonStats);
            } else {
                TreeMap<String, List<Integer>> dragons = dragonArmy.get(type);
                if (!dragons.containsKey(dragon)){
                    dragons.put(dragon, new ArrayList<>());
                    List<Integer> dragonStats = new ArrayList<>(Arrays.asList(damage, health, armor));
                    dragonArmy.get(type).put(dragon, dragonStats);
                } else {
                    List<Integer> dragonStats = new ArrayList<>(Arrays.asList(damage, health, armor));
                    dragonArmy.get(type).put(dragon, dragonStats);
                }
                dragonArmy.put(type, dragons);
            }
        }

        dragonArmy.entrySet().forEach(type -> {
            List<Integer> averageStats = new ArrayList<>(Arrays.asList(0, 0, 0));
            type.getValue().entrySet().forEach((dragon -> {
                averageStats.set(0, averageStats.get(0) + dragon.getValue().get(0));
                averageStats.set(1, averageStats.get(1) + dragon.getValue().get(1));;
                averageStats.set(2, averageStats.get(2) + dragon.getValue().get(2));
            }));
            double averageDamage = (double) averageStats.get(0) / type.getValue().size();
            double averageHealth = (double) averageStats.get(1) / type.getValue().size();
            double averageArmor = (double) averageStats.get(2) / type.getValue().size();
            System.out.printf("%s::(%.2f/%.2f/%.2f)\n", type.getKey(), averageDamage, averageHealth, averageArmor);

            type.getValue().forEach((dragon, stats) -> {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n", dragon, stats.get(0), stats.get(1), stats.get(2));
            });
        });
    }

    private static String[] collectDragonInformation(Scanner scanner) {

        int defaultHealth = 250;
        int defaultDamage = 45;
        int defaultArmor = 10;

        String[] inputData = scanner.nextLine().split(" ");

        if (inputData[2].equals("null")) {
            inputData[2] = String.valueOf(defaultDamage);
        }

        if (inputData[3].equals("null")){
            inputData[3] = String.valueOf(defaultHealth);
        }

        if (inputData[4].equals("null")){
            inputData[4] = String.valueOf(defaultArmor);
        }
        return inputData;
    }
}