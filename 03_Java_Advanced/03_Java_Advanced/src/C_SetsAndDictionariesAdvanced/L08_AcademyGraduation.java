package C_SetsAndDictionariesAdvanced;

import java.util.*;

public class L08_AcademyGraduation {

/*Write a program that:
    •	Reads from console number of students for a track.
    •	Reads on pair of rows:
        o	The first line is the name of the student.
        o	The second line is his score for a different number of courses.
•	Print on console "{name} is graduated with {average scores)".*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Double> students = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double [] grades = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
            double average = getAverage(grades);
            students.putIfAbsent(name, average);
        }

        students.forEach((name, grades) -> {
            System.out.printf("%s is graduated with %s\n", name, grades);
        });
    }

    private static double getAverage(double[] grades) {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }

        return sum / grades.length;
    }
}
