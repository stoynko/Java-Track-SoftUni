package D_OOP.D_InterfacesAndAbstraction.L05_BorderControl;

import java.util.*;

public class Main {

/*It’s the future, you’re the ruler of a totalitarian dystopian society inhabited by citizens and robots, since you’re afraid of rebellions
you decide to implement strict control of who enters your city. Your soldiers check the Ids of everyone who enters and leaves.
You will receive from the console an unknown amount of lines until the command "End" is received, on each line, there will be the
information for either a citizen or a robot who tries to enter your city in the format:
"{name} {age} {id}" for citizens and "{model} {id}" for robots.

After the end command on the next line, you will receive a single number representing the last digits of fake ids, all citizens or
robots whose Id ends with the specified digits must be detained.

The output of your program should consist of all detained Ids each on a separate line (the order of printing doesn’t matter). */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Identifiable> entities = new ArrayList<>();
        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String[] inputData = input.split("\\s+");
            if (inputData.length == 3) {
                String name = inputData[0];
                int age = Integer.parseInt(inputData[1]);
                String id = inputData[2];
                Citizen citizen = new Citizen(name, age, id);
                entities.add(citizen);
            } else {
                String model = inputData[0];
                String id = inputData[1];
                Robot robot = new Robot(model, id);
                entities.add(robot);
            }
            input = scanner.nextLine();
        }

        String searchCriteria = scanner.nextLine();
        for (Identifiable entity : entities) {
            if (entity.getId().endsWith(searchCriteria)) {
                System.out.println(entity.getId());
            }
        }
    }
}
