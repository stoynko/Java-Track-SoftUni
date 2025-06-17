package B_Encapsulation.L02_SalaryIncrease;

import java.io.*;
import java.util.*;

public class Main {

/*Create a class Person, which should have private fields for:
    •	firstName: String
    •	lastName: String
    •	age: int
    •	toString() - override

Read person with their names, age, and salary. Read percent bonus to every person salary.
People younger than 30 get a half bonus. Expand Person from the previous task.
Add salary field and getter and setter with proper access.

New fields and methods:
    •	salary: double
    •	increaseSalary(double bonus) */

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            people.add(new Person(input[0], input[1], Integer.parseInt(input[2]), Double.parseDouble(input[3])));
        }
        double bonus = Double.parseDouble(reader.readLine());
        for (Person person : people) {
            person.increaseSalary(bonus);
            System.out.println(person.toString());
        }
    }

}
