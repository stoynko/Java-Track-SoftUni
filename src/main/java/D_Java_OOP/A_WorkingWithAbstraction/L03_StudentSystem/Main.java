package D_Java_OOP.A_WorkingWithAbstraction.L03_StudentSystem;

import java.util.*;

public class Main {

/*You are given a working project for a small Student System, but the code is very poorly organized.
Break up the code logically into smaller functional units – methods and classes and don’t break the functionality.

The program supports the following commands:
    •	"Create {studentName} {studentAge} {studentGrade}" – creates a new student and adds them to the repository.
    •	"Show {studentName}" – prints on the console information about a student in the format:
        "{studentName} is {studentAge} years old. {commentary}.", where the commentary is based on the student’s grade.
    •	"Exit" – closes the program.

Do not add any extra validation or functionality to the app! */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();
        String[] input = scanner.nextLine().split("\\s+");

        while (!input[0].equals("Exit")) {
            studentSystem.parseCommand(input);
            input = scanner.nextLine().split("\\s+");
        }
    }
}
