package A_BasicSyntaxConditionalStatements;

public class L08_DivisibleByThree {

/*Write a program that prints all the numbers from 1 to 100, which are divisible by 3.
You have to use a single for loop. The program should not receive input.*/

    public static void main(String[] args) {

        for (int i = 3; i <= 99; i += 3) {
            System.out.println(i);
        }
    }
}