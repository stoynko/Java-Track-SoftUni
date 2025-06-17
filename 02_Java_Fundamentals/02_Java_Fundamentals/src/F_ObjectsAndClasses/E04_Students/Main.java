package F_ObjectsAndClasses.E04_Students;

import java.util.*;

public class Main {

/*Write a program that receives n count of students and orders them by grade (in descending).
Each student should have a first name (string), a last name (string), and a grade (a floating-point number).

Input:
    •	First-line will be a number n.
    •	Next n lines you will get student info in the format "{first name} {second name} {grade}".
Output:
    •	Print each student in the following format "{first name} {second name}: {grade}".*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        List<Student> students = new ArrayList<>();

        for (int index = 1; index <= numberOfStudents; index++) {
            String[] data = scanner.nextLine().split("\\s+");
            String firstName = data[0];
            String lastName = data[1];
            double grade = Double.parseDouble(data[2]);
            Student currentStudent = new Student(firstName, lastName, grade);
            students.add(currentStudent);
        }
        students.sort(Comparator.comparing(Student::getGrade));
        Collections.reverse(students);

        for (Student currentStudent : students) {
            currentStudent.printStudent();
        }
    }
}
