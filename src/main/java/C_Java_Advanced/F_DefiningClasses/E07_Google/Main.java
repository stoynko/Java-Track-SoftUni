package C_Java_Advanced.F_DefiningClasses.E07_Google;

import java.util.*;

public class Main {


    public static void main(String[] args) {

        /*You will receive an unknown number of rows from the console until you receive the "End" command, on each of those lines,
        there will be information about a person in one of the following formats:
            •	"{Name} company {companyName} {department} {salary}"
            •	"{Name} pokemon {pokemonName} {pokemonType}"
            •	"{Name} parents {parentName} {parentBirthday}"
            •	"{Name} children {childName} {childBirthday}"
            •	"{Name} car {carModel} {carSpeed}"*/

        Scanner scanner = new Scanner(System.in);
        Map<String, Person> peoples = new HashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String[] inputData = input.split(" ");
            String personName = inputData[0];

            if (!peoples.containsKey(personName)) {
                peoples.put(personName, new Person(personName));
            }

            switch (inputData[1]) {
                case "company" -> {
                    String companyName = inputData[2];
                    String department = inputData[3];
                    double salary = Double.parseDouble(inputData[4]);
                    Company company = new Company(companyName, department, salary);
                    peoples.get(personName).setCompany(company);
                }
                case "pokemon" -> {
                    String pokemonName = inputData[2];
                    String pokemonType = inputData[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    peoples.get(personName).getPokemonsList().add(pokemon);
                }
                case "parents" -> {
                    String parentName = inputData[2];
                    String parentBirthday = inputData[3];
                    peoples.get(personName).getParentsList().add(new Parent(parentName, parentBirthday));
                }
                case "children" -> {
                    String childName = inputData[2];
                    String childBirthday = inputData[3];
                    peoples.get(personName).getChildrenList().add(new Child(childName, childBirthday));
                }
                case "car" -> {
                    String carModel = inputData[2];
                    int carSpeed = Integer.parseInt(inputData[3]);
                    peoples.get(personName).setCar(new Car(carModel, carSpeed));
                }
            }
            input = scanner.nextLine();
        }
        String personToDisplay = scanner.nextLine();
        if (peoples.containsKey(personToDisplay)) {
            System.out.println(peoples.get(personToDisplay).toString());
        }
    }
}