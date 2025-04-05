package B_Java_Fundamentals.F_ObjectsAndClasses.E03_OpinionPoll;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void printPerson() {
        System.out.printf("%s - %d%n", this.name, this.age);
    }
}

