package A_Java_ProgrammingBasics.E_WhileLoops;

import java.util.*;

public class L08_Graduation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int gradeCounter = 0;
        double grade = 0;
        double gradesSum = 0;
        while (true) {
            grade = Double.parseDouble(scanner.nextLine());
            gradesSum += grade;
            gradeCounter++;
            if (grade < 4) {
                System.out.printf("%s has been excluded at %d grade\n", name, gradeCounter);
                break;
            }
            if (gradeCounter == 12) {
                System.out.printf("%s graduated. Average grade: %.2f", name, gradesSum / gradeCounter);
                break;
            }
        }
    }
}