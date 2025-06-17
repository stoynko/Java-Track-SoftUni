package A_BasicSyntaxConditionalStatements;

import java.util.*;

public class L01_StudentInformation {

/*Write a program that:
    •	Reads 3 lines of input – student name, age and average grade
    •	Print all the info about the student in the following format:
        "Name: {student name}, Age: {student age}, Grade: {student grade}".*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String studentName = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        double grade = Double.parseDouble(scanner.next());

        System.out.printf("Name: %s, Age: %d, Grade: %.2f", studentName, age, grade);
    }
}