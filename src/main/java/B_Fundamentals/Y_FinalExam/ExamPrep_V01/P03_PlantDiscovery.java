package B_Fundamentals.Y_FinalExam.ExamPrep_V01;

import java.util.*;

public class P03_PlantDiscovery {

/*You have now returned from your world tour. On your way, you have discovered some new plants, and you want to gather some information about them
and create an exhibition to see which plant is highest rated. On the first line, you will receive a number n. On the next n lines,
you will be given some information about the plants that you have discovered in the format: "{plant}<->{rarity}".
Store that information because you will need it later. If you receive a plant more than once, update its rarity.

After that, until you receive the command "Exhibition", you will be given some of these commands:
    •	"Rate: {plant} - {rating}" – add the given rating to the plant (store all ratings)
    •	"Update: {plant} - {new_rarity}" – update the rarity of the plant with the new one
    •	"Reset: {plant}" – remove all the ratings of the given plant

Note: If any given plant name is invalid, print "error"

After the command "Exhibition", print the information that you have about the plants in the following format:
"Plants for the exhibition:
    - {plant_name1}; Rarity: {rarity}; Rating: {average_rating}
    - {plant_name2}; Rarity: {rarity}; Rating: {average_rating}
    …
    - {plant_nameN}; Rarity: {rarity}; Rating: {average_rating}"

The average rating should be formatted to the second decimal place.

Input / Constraints:
    •	You will receive the input as described above.
    •	JavaScript: you will receive a list of strings.
Output:
    •	Print the information about all plants as described above.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> plantsData = new LinkedHashMap<>();
        Map<String, List<Double>> plantRatings = new LinkedHashMap<>();
        int numberOfPlants = Integer.parseInt(scanner.nextLine());

        for (int currentPlant = 1; currentPlant <= numberOfPlants; currentPlant++) {
            String[] input = Arrays.stream(scanner.nextLine().split("<->")).toArray(String[]::new);
            String plantName = input[0].trim();
            int plantRarity = Integer.parseInt(input[1].trim());
            plantsData.put(plantName, plantRarity);
            plantRatings.putIfAbsent(plantName, new ArrayList<>());
        }

        String input = scanner.nextLine();

        while (!input.equals("Exhibition")) {

            String command = input.split(":")[0].trim();
            String plantName = input.split(":")[1].split(" - ")[0].trim();
            if (!plantsData.containsKey(plantName)) {
                System.out.println("error");
                input = scanner.nextLine();
                continue;
            }
            switch (command) {
                case "Rate" -> {
                    Double newRating = Double.parseDouble(input.split(":")[1].split(" - ")[1]);
                    plantRatings.get(plantName).add(newRating);
                }
                case "Update" -> {
                    int newRarity = Integer.parseInt(input.split(":")[1].split(" - ")[1]);
                    plantsData.put(plantName, newRarity);
                }
                case "Reset" -> {
                    if (plantsData.containsKey(plantName)) {
                        plantRatings.get(plantName).clear();

                    }
                }
            }
            input = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        for (Map.Entry<String, Integer> entry : plantsData.entrySet()) {
            double averageRating = 0;
            if (!plantRatings.get(entry.getKey()).isEmpty()) {
                averageRating = plantRatings.get(entry.getKey()).stream().mapToDouble(Double::doubleValue).sum() / plantRatings.get(entry.getKey()).size();
            }
            System.out.printf("- %s; Rarity: %d; Rating: %.2f\n", entry.getKey(), entry.getValue(), averageRating);
        }
    }
}
