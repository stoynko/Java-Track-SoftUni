package F_ObjectsAndClasses.E04_Students;

public class Student {

    private String firstname;
    private String lastname;
    private double grade;

    public Student(String firstname, String lastname, double grade) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    public void printStudent() {
        System.out.printf("%s %s: %.2f%n", firstname, lastname, grade);
    }
}