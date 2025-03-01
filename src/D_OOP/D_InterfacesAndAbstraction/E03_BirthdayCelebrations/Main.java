package D_OOP.D_InterfacesAndAbstraction.E03_BirthdayCelebrations;

import java.util.*;

public class Main {

/*It is a well-known fact that people celebrate birthdays, it is also known that some people also celebrate their pet's birthdays.
Extend the program from your last task to add birthdays to citizens and include a class Pet, pets have a name and a birthdate.
Also, create a class Robot that has an id and model. Encompass repeated functionality into interfaces and implement them in your classes.

You will receive from the console an unknown amount of lines until the command "End" is received,
each line will contain information in one of the following formats "Citizen {name} {age} {id} {birthdate}" for citizens,
"Robot {id} {model}" for robots or "Pet {name} {birthdate}" for pets.
After the end command on the next line, you will receive a single number representing a specific year, your task is to print all
birthdays (of both citizens and pets) in that year in the format "{day}/{month}/{year}" (the order of printing doesn’t matter). */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Birthable> entitiesWithBirthday = new ArrayList<>();
        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String[] inputData = input.split(" ");
            String entity = inputData[0];

            switch (entity) {
                case "Citizen":
                    String name = inputData[1];
                    int age = Integer.parseInt(inputData[2]);
                    String id = inputData[3];
                    String birthDate = inputData[4];
                    Citizen citizen = new Citizen (name, age, id, birthDate);
                    entitiesWithBirthday.add(citizen);
                    break;
                case "Pet":
                    name = inputData[1];
                    birthDate = inputData[2];
                    Pet pet = new Pet(name, birthDate);
                    entitiesWithBirthday.add(pet);
                    break;
                case "Robot":
                    break;
            }

            input = scanner.nextLine();
        }

        boolean isFound = false;
        String birthYear = scanner.nextLine();
        for (Birthable entity : entitiesWithBirthday) {
            String birthDate = entity.getBirthDate();
            if (birthDate.endsWith(birthYear)) {
                isFound = true;
                System.out.println(entity.getBirthDate());
            }
        }

        if (!isFound) {
            System.out.println("<no output>");
        }
    }
}
