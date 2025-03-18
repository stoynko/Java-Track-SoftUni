package C_Advanced.H_IteratorsAndComparators.E05_ComparingObjects;

public class Person implements Comparable<Person> {

    private String name;
    private int age;
    private String town;
    private Person otherPerson;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getTown() {
        return town;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Person otherPerson) {

        if (this.name.equals(otherPerson.getName())) {
            if (this.age == otherPerson.getAge()) {
                if (this.town.equals(otherPerson.getTown())) {
                    return 0;
                }
            }
        }
        return this.getName().compareTo(otherPerson.getName());
    }
}
