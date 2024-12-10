package B_Fundamentals.B_DataTypesAndVariables;

import java.util.*;

public class AE01_DataTypeFinder {

/*You will receive input until you receive "END". Find what data type is the input. Possible data types are:
    •	Integer
    •	Floating point
    •	Characters
    •	Boolean
    •	Strings

 Print the result in the following format: "{input} is {data type} type".*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("END")) {
            Scanner finalInput = new Scanner(input);
            if (finalInput.hasNextBoolean()) {
                System.out.printf("%s is boolean type%n", input);
            } else if (finalInput.hasNextInt()) {
                System.out.printf("%s is integer type%n", input);
            } else if (finalInput.hasNextDouble()) {
                System.out.printf("%s is floating point type%n", input);
            } else if (input.length() == 1) {
                System.out.printf("%s is character type%n", input);
            } else {
                System.out.printf("%s is string type%n", input);
            }

            input = scanner.nextLine();
        }
    }
}
