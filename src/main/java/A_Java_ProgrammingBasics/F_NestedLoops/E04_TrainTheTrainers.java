package A_Java_ProgrammingBasics.F_NestedLoops;

import java.util.*;

public class E04_TrainTheTrainers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int juryCount = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        double grade = 0;
        double sumGrades = 0;
        double averageGrade = 0;
        double sumAverageGrades = 0;
        int presentationCounter = 0;

        while (!input.equals("Finish")) {
            String presentationName = input;
            presentationCounter++;
            for (int i = 0; i < juryCount; i++) {
                grade = Double.parseDouble(scanner.nextLine());
                sumAverageGrades += grade;
                sumGrades += grade;

            }
            averageGrade = sumGrades / juryCount;
            sumGrades = 0;
            System.out.printf("%s - %.2f.\n", presentationName, averageGrade);
            input = scanner.nextLine();
        }
        System.out.printf("Student's final assessment is %.2f.\n", sumAverageGrades / (presentationCounter * juryCount));
    }
}