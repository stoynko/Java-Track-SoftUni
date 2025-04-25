package A_Java_ProgrammingBasics.E_WhileLoops;

import java.util.*;

public class E02_ExamPreparation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int badGrades = Integer.parseInt(scanner.nextLine());
        String problem = "";
        String input = "";
        int grade = 0;
        int gradesSum = 0;
        int badGradeCounter = 0;
        int problemsCounter = 0;
        while (true) {
            input = scanner.nextLine();
            if (input.equals("Enough")) {
                System.out.printf("Average score: %.2f\n", (double) gradesSum / problemsCounter);
                System.out.printf("Number of problems: %d\n", problemsCounter);
                System.out.printf("Last problem: %s\n", problem);
                break;
            }
            grade = Integer.parseInt(scanner.nextLine());
            gradesSum += grade;
            problemsCounter++;
            if (grade <= 4) {
                badGradeCounter++;
                if (badGradeCounter == badGrades) {
                    System.out.printf("You need a break, %d poor grades.\n", badGradeCounter);
                    break;
                }
            }
            problem = input;
        }
    }
}