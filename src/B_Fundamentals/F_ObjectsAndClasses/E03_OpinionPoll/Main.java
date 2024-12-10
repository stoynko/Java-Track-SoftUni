package B_Fundamentals.F_ObjectsAndClasses.E03_OpinionPoll;

import java.util.*;

public class Main {

/*Using the Person class, write a program that reads from the console N lines of personal information and then prints all people whose age is more than 30 years.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int peopleAmount = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();

        for (int person = 1; person <= peopleAmount; person++) {

            String[] data = scanner.nextLine().split(" ");
            String name = data[0];
            int age = Integer.parseInt(data[1]);

            if (age > 30) {
                Person currentPerson = new Person(name, age);
                people.add(currentPerson);
            }
        }
        for (Person person : people) {
            person.printPerson();
        }
    }
}