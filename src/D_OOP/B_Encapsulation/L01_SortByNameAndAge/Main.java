package D_OOP.B_Encapsulation.L01_SortByNameAndAge;

import java.io.*;
import java.util.*;

public class Main {

/*Create a class Person, which should have private fields for:
    •	firstName: String
    •	lastName: String
    •	age: int
    •	toString() - override */

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            people.add(new Person(input[0], input[1], Integer.parseInt(input[2])));
        }

        Collections.sort(people, (firstPerson, secondPerson) -> {
            int sComp = firstPerson.getFirstName().compareTo(secondPerson.getFirstName());

            if (sComp != 0) {
                return sComp;
            } else {
                return Integer.compare(firstPerson.getAge(), secondPerson.getAge());
            }
        });

        for (Person person : people) {
            System.out.println(person.toString());
        }
    }
}
