package E_Lists;

import java.util.*;
import java.util.stream.*;

public class E01_Train {

/*On the first line, you will be given a list of wagons (integers). Each integer represents the number of passengers that are currently in each wagon.
On the next line, you will get the max capacity of each wagon (single integer). Until you receive "end" you will be given two types of input:
    •	Add {passengers} - add a wagon to the end with the given number of passengers
    •	{passengers} -  find an existing wagon to fit all the passengers (starting from the first wagon)

In the end, print the final state of the train (all the wagons separated by a space)*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int maxCapacity = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] action = input.split(" ");
            if (action[0].equals("Add")) {
                wagons.add(Integer.parseInt(action[1]));
            } else {
                int newPasengers = Integer.parseInt(action[0]);
                for (int currentWagon = 0; currentWagon <= wagons.size() - 1; currentWagon++) {
                    if ((wagons.get(currentWagon) + newPasengers) <= maxCapacity) {
                        wagons.set(currentWagon, wagons.get(currentWagon) + newPasengers);
                        break;
                    }
                }
            }
            input = scanner.nextLine();
        }
        System.out.println(wagons.toString().replaceAll("[\\[\\],]", ""));
    }
}
