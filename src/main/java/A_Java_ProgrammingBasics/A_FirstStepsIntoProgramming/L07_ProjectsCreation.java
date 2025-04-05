package A_Java_ProgrammingBasics.A_FirstStepsIntoProgramming;

import java.util.*;

public class L07_ProjectsCreation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int projects = Integer.parseInt(scanner.nextLine());
        int timePerProject = 3;
        int timeNeeded = projects * timePerProject;

        System.out.printf("The architect %s will need %d hours to complete %d project/s.", name, timeNeeded, projects);

    }
}
