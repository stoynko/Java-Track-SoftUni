package H_IteratorsAndComparators.E05_ComparingObjects;

import java.util.*;

public class Main {

/*There is a Comparable interface, but probably you already know. Your task is simple. Create a Person.
Each person should have a name, age, and town. You should implement the interface - Comparable and try to override the compareTo method.
When you compare two people, first you should compare their names, after that - their age and last but not least - compare their town.

Input:
On single lines, you will be given people in the format:
    •	"{name} {age} {town}"
    •	Collect them till you receive "END".
After that, you will receive an integer N - the Nth person in your collection.

Output:
On the single output line, you should bring statistics, how many people are equal to him, how many people are not equal to him,
and the total number of people in your collection.
Format:
    •	"{number of equal people} {number of not equal people} {total number of people}"

If there are no equal people, print: "No matches".
Constraints:
    •	Names, ages, and addresses will be valid.
    •	Input number will be always а valid integer in the range [2…100]. */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Person> people = new ArrayList<>();

        while (!input.equals("END")) {

            String[] inputData = input.split(" ");

            String name = inputData[0];
            int age = Integer.parseInt(inputData[1]);
            String town = inputData[2];

            Person currentPerson = new Person(name, age, town);
            people.add(currentPerson);

            input = scanner.nextLine();
        }

        Person personToSearchFor = people.get(Integer.parseInt(scanner.nextLine()) - 1);
        int peopleMatches = 0;
        int peopleDifferent = 0;

        for (Person person : people) {
            if (person.compareTo(personToSearchFor) == 0) {
                peopleMatches++;
            } else {
                peopleDifferent++;
            }
        }

        if (peopleMatches > 1) {
            System.out.printf("%d %d %d\n", peopleMatches, peopleDifferent, people.size());
        } else {
            System.out.println("No matches");
        }
    }
}