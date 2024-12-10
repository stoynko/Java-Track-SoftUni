package B_Fundamentals.F_ObjectsAndClasses.L06_StudentsV02;

import java.util.*;

public class Main {

/*Define a class Student, which holds the following information about students: first name, last name, age, and hometown.
Read the list of students until you receive the "end" command. After that, you will receive a city name.
Print only students which are from the given city, in the following format: "{firstName} {lastName} is {age} years old".*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Students> studentsList = new ArrayList<>();
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] data = input.split(" ");
            String firstName = data[0];
            String lastName = data[1];
            int age = Integer.parseInt(data[2]);
            String hometown = data[3];
            if (checkIfStudentExists(studentsList, firstName, lastName)) {
                Students existingStudent = getStudentInfo(studentsList, firstName, lastName);
                existingStudent.setFirstName(firstName);
                existingStudent.setLastName(lastName);
                existingStudent.setAge(age);
                existingStudent.setHometown(hometown);
            } else {
                Students newStudent = new Students(firstName, lastName, age, hometown);
                studentsList.add(newStudent);
            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        for (Students student : studentsList) {
            if (student.getHometown().equals(input)) {
                System.out.printf("%s %s is %d years old%n", student.getFirstName(), student.getLastName(), student.getAge());
            }
        }
    }

    private static boolean checkIfStudentExists(List<Students> studentsList, String firstName, String lastName) {
        for (Students student : studentsList) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return true;
            }
        }
        return false;
    }

    private static Students getStudentInfo(List<Students> studentsList, String firstName, String lastName) {
        Students existingStudent = null;
        for (Students student : studentsList) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                existingStudent = student;
            }
        }
        return existingStudent;
    }
}