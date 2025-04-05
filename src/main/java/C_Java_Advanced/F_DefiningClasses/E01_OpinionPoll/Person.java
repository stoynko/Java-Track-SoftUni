package C_Java_Advanced.F_DefiningClasses.E01_OpinionPoll;

public class Person {

    private String name;
    private int age;

    public void setName (String name) {
        this.name = name;
    }

    public void setAge (int age) {
        this.age = age;
    }

    public String getName () {
        return this.name;
    }

    public int getAge () {
        return this.age;
    }

    Person (String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", this.name, this.age);
    }
}
