package G_AssociativeArraysAndStreamAPI;

import java.util.*;

public class E05_Courses {

/*Write a program which keeps the information about courses. Each course has a name and registered students.
You will receive the course name and student name until you receive the command "end". Check if such a course already exists and if not - add the course.
Register the user into the course. When you do receive the command "end", print the courses with their names and total registered users.
For each contest, print the registered users.

Input:
    •	Until you receive "end", the input come in the format: "{courseName} : {studentName}".
    •	The product data is always delimited by " : ".
Output:
    •	Print information about each course, following the format: "{courseName}: {registeredStudents}"
    •	Print information about each student, following the format: "-- {studentName}"*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> courses = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] courseInfo = input.split(" : ");
            String courseName = courseInfo[0];
            String studentName = courseInfo[1];
            if (courses.containsKey(courseName)) {
                courses.get(courseName).add(studentName);
            } else {
                courses.put(courseName, new ArrayList<>());
                courses.get(courseName).add(studentName);
            }
            input = scanner.nextLine();
        }

        courses.forEach((course, students) -> {
            int attendingStudents = courses.get(course).size();
            System.out.printf("%s: %d%n", course, attendingStudents);
            for (String student : students) {
                System.out.printf("-- %s%n", student);
            }
        });
    }
}
