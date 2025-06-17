package G_AssociativeArraysAndStreamAPI;

import java.util.*;

public class E02_AMinerTask {

/*Until you receive the "stop" command, you will be given a sequence of strings, each on a new line.
Every odd line on the console represents a resource (e.g., Gold, Silver, Copper, etc.) and every even - quantity.
Your task is to collect the resources and print them on a new line.
Print the resources and their quantities in the format: "{resource} –> {quantity}".
The quantities inputs will be in the range [1 … 2 000 000 000].*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> resourceList = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());
            if (!resourceList.containsKey(input)) {
                resourceList.put(input, quantity);
            } else {
                resourceList.put(input, resourceList.get(input) + quantity);
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, Integer> entry : resourceList.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}