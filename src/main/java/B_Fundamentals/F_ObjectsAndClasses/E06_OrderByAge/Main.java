package B_Fundamentals.F_ObjectsAndClasses.E06_OrderByAge;

import java.util.*;

public class Main {

/*You will receive an unknown number of lines. On each line, you will receive an array with 3 elements.
The first element will be a string and represents the name of the person. The second element will be a string and will represent the ID of the person.
The last element will be an integer which represents the age of the person.
When you receive the command "End", stop taking input and print all the people, ordered by age.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Person> people = new ArrayList<>();

        while (!input.equals("End")) {

            String name = input.split("\\s+")[0];
            String identificationNumber = input.split("\\s+")[1];
            int age = Integer.parseInt(input.split("\\s+")[2]);
            Person currentPerson = new Person(name, identificationNumber, age);
            people.add(currentPerson);
            input = scanner.nextLine();
        }
        people.sort(Comparator.comparing(Person::getAge));

        for (Person person : people) {
            System.out.printf("%s with ID: %s is %d years old.%n", person.getName(), person.getIdentificationNumber(), person.getAge());
        }
    }
}