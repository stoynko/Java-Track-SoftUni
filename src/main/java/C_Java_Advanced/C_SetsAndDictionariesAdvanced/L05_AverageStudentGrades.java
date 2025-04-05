package C_Java_Advanced.C_SetsAndDictionariesAdvanced;

import java.util.*;

public class L05_AverageStudentGrades {

/*Write a program, which reads the name of a student and their grades and adds them to the student record,
then prints grades along with their average grade – ordered the output by the students' names.

    Input:
    •	On the first line N – the number of students, then on the next, N lines student name with grade.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TreeMap<String, ArrayList<Double>> grades = new TreeMap<>();
        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        for (int student = 1; student <= numberOfStudents; student++) {

            String studentsData = scanner.nextLine();
            String studentName = studentsData.split(" ")[0];
            Double grade = Double.parseDouble(studentsData.split(" ")[1]);

            if (!grades.containsKey(studentName)) {
                grades.put(studentName, new ArrayList<>());
                grades.get(studentName).add(grade);
            } else {
                grades.get(studentName).add(grade);
            }
        }

        for (String student : grades.keySet()) {
            System.out.printf("%s -> ", student);
            for (double grade : grades.get(student)) {
                System.out.printf("%.2f ", grade);
            }
            double gradesSum = 0;
            for (double grade : grades.get(student)) {
                gradesSum += grade;
            }
            int numberOfGrades = grades.get(student).size();
            System.out.printf("(avg: %.2f)\n", gradesSum / numberOfGrades);
        }
    }
}