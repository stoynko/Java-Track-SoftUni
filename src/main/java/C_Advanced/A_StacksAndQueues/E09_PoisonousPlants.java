package C_Advanced.A_StacksAndQueues;

import java.util.*;

public class E09_PoisonousPlants {

/*You are given N plants in a garden. Each of these plants has been added with some amount of pesticide.
You are given the pesticide's initial values and each plant's position. After each day,
if any plant has more pesticide than the plant at its left, being weaker (more GMO) than the left one, it dies.
Print the number of days after which no plant dies, i.e. the time after which there are no plants with more pesticide
content than the plant to their left.
    Input:
        •	The input consists of an integer N representing the number of plants.
        •	The next single line consists of N integers,
            where every integer represents each plant's position and amount of pesticides. 1 ≤ N ≤ 100000.
        •	Pesticides amount on a plant is between 0 and 1000000000.
    Output:
        •	Output a single value equal to the number of days after which no plants die.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int numberOfPlants = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<Integer, Integer> plants = new LinkedHashMap<>();
        ArrayDeque<String> plantStack = new ArrayDeque();
        ArrayDeque<String> livingStack = new ArrayDeque();

        for (int plant = 0; plant < numberOfPlants; plant++) {
            int pesticideValue = scanner.nextInt();
            plants.put((plant + 1), pesticideValue);
            plantStack.push(pesticideValue + " " + (plant + 1));
        }

        int dayCounter = 0;
        while (true) {
            boolean hasPlantDied = false;
            while (!plantStack.isEmpty()) {
                if (plantStack.size() == 1) {
                    livingStack.push(plantStack.pop());
                    break;
                }
                String currentPlant = plantStack.pop();
                int currentPlantValue = Integer.parseInt(currentPlant.split(" ")[0]);
                int currentPlantIndex = Integer.parseInt(currentPlant.split(" ")[1]);

                String leftPlant = plantStack.peek();
                int leftPlantValue = Integer.parseInt(leftPlant.split(" ")[0]);
                int leftPlantIndex = Integer.parseInt(leftPlant.split(" ")[1]);

                if (currentPlantValue > leftPlantValue) {
                    plants.remove(currentPlantIndex);
                    hasPlantDied = true;
                } else {
                    livingStack.push(currentPlant);
                }
            }

            while (!livingStack.isEmpty()) {
                plantStack.push(livingStack.pop());
            }
            if (!hasPlantDied) {
                System.out.println(dayCounter);
                return;
            }
            dayCounter++;
        }
    }
}