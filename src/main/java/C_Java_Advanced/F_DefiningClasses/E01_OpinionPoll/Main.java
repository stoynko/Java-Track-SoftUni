package C_Java_Advanced.F_DefiningClasses.E01_OpinionPoll;

import java.util.*;
import java.util.stream.*;

public class Main {

/*Create a Person class with two fields String name and int age.
Write a program that reads from the console N lines of personal information and then prints all people whose age is more than 30 years,
sorted in alphabetical order. Print in the following format "{name} – {age}".*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Person> peopleList = new ArrayList<>();
        int inputCount = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= inputCount; i++) {

            String[] inputData = scanner.nextLine().split(" ");
            String name = inputData[0];
            int age = Integer.parseInt(inputData[1]);

            Person person = new Person(name, age);
            peopleList.add(person);
        }

        peopleList = peopleList.stream().filter(person -> person.getAge() > 30).collect(Collectors.toList());
        peopleList.sort(Comparator.comparing(person -> person.getName()));
        peopleList.forEach(System.out::println);
    }
}
