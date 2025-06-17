package D_InterfacesAndAbstraction.E04_FoodShortage;

import java.util.*;

public class Main {

/*Your totalitarian dystopian society suffers a shortage of food, so many rebels appear.
Extend the code from your previous (Problem 2. Multiple Implementation) tasks with new functionality to solve this task.

Define a class Rebel which has a name, age, and group (String), names are unique - there will never be 2 Rebels/Citizens or a Rebel and
Citizen with the same name. Define an interface Buyer which defines the methods buyFood() and a getFood().
Implement the Buyer interface in the Citizen and Rebel class, both Rebels and Citizens start with 0 food,
when a Rebel buys food his food increases by 5, when a Citizen buys food his food increases by 10.

On the first line of the input you will receive an integer N - the number of people, on each of the next N lines you will receive
information in one of the following formats:
•	"{name} {age} {id} {birthdate}" for a Citizen
•	"{name} {age} {group}" for a Rebel
After the N lines, until the command "End" is received, you will receive names of people who bought food, each on a new line.
Note that not all names may be valid, in the case of an incorrect name - nothing should happen.

On the only line of output, you should print the total amount of food purchased.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Buyer> buyers = new HashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String[] inputData = scanner.nextLine().split(" ");
            String name = inputData[0];
            int age = Integer.parseInt(inputData[1]);
            Buyer buyer;
            if (inputData.length == 4) {
                String id = inputData[2];
                String birthDate = inputData[3];
                buyer = new Citizen(name, age, id, birthDate);

            } else {
                String group = inputData[2];
                buyer = new Rebel(name, age, group);

            }
            buyers.put(name, buyer);
        }

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            Buyer buyer = buyers.get(input);
            if (buyer != null) {
                buyer.buyFood();
            }

            input = scanner.nextLine();
        }

        System.out.println(buyers.values().stream().mapToInt(Buyer::getFood).sum());
    }
}
