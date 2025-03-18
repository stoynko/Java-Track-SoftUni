package B_Fundamentals.A_BasicSyntaxConditionalStatements;

import java.util.*;

    public class E01_Ages {

/*Write a program that determines whether a person is based on the given age: baby, child, teenager, adult, or elder. The bounders are:
    •	0-2 – baby;
    •	3-13 – child;
    •	14-19 – teenager;
    •	20-65 – adult;
    •	>=66 – elder;
All the values are inclusive.*/

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            int age = Integer.parseInt(scanner.nextLine());
            String ageGroup = "";
            if (age >= 0 && age <= 2) {
                ageGroup = "baby";
            } else if (age > 2 && age <= 13) {
                ageGroup = "child";
            } else if (age > 13 && age <= 19) {
                ageGroup = "teenager";
            } else if (age > 19 && age <= 65) {
                ageGroup = "adult";
            } else {
                ageGroup = "elder";
            }

            System.out.printf("%s", ageGroup);
        }
    }
