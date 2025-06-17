package G_AssociativeArraysAndStreamAPI;

import java.util.*;

public class E06_StudentAcademy {

/*Write a program that keeps the information about students and their grades. On the first line, you will receive number n.
After that, you will receive n pair of rows. First, you will receive the student's name, after that, you will receive his grade.
Check if the student already exists and if not - add him. Keep track of all grades for each student.
When you finish reading data, keep students with an average grade higher or equal to 4.50. Print the students and their average grade in the format:
"{name} –> {averageGrade}"
Format the average grade to the 2nd decimal place.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> students = new LinkedHashMap<>();
        int inputCount = Integer.parseInt(scanner.nextLine());

        for (int currentInput = 1; currentInput <= inputCount; currentInput++) {
            String studentName = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (students.containsKey(studentName)) {
                students.get(studentName).add(grade);
            } else {
                students.put(studentName, new ArrayList<>());
                students.get(studentName).add(grade);
            }
        }
        Map<String, Double> output = new LinkedHashMap<>();

        students.forEach((student, grades) -> {
            double gradesSum = students.get(student).stream().mapToDouble(i -> i).sum();
            double averageGrade = gradesSum / students.get(student).size();
            if (averageGrade >= 4.5) {
                output.put(student, averageGrade);
            }
        });

        output.forEach((student, grade) -> {
            System.out.printf("%s -> %.2f%n", student, grade);
        });
    }
}