package B_Java_Fundamentals.F_ObjectsAndClasses.E06_OrderByAge;

public class Person {

    private String name;
    private String identificationNumber;
    private int age;

    public Person(String name, String identificationNumber, int age) {
        this.name = name;
        this.identificationNumber = identificationNumber;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

