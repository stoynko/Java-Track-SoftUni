package B_Encapsulation.L02_SalaryIncrease;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %f leva", this.firstName, this.lastName, this.salary);
    }

    public void increaseSalary(double bonus) {
        if (this.age < 30) {
            this.salary += this.salary * 0.5 * (bonus / 100);
        } else {
            this.salary += this.salary * (bonus / 100);
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

}
