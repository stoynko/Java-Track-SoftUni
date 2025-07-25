package D_InterfacesAndAbstraction.L03_SayHello;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        persons.add(new Bulgarian("Peter"));
        persons.add(new European("Peter"));
        persons.add(new Chinese("Peter"));

        for (Person person : persons) {
            print(person);
        }
    }

    private static void print(Person person) {
        System.out.println(person.sayHello());
    }
}
