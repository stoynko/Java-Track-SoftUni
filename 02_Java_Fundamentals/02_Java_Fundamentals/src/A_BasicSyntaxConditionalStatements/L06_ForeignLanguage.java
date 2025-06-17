package A_BasicSyntaxConditionalStatements;

import java.util.*;

public class L06_ForeignLanguage {

/*Write a program that:
    •	Reads a string from the console, representing country
    Print:
    o	"English" -> if the entered country is "USA" or "England"
    o	"Spanish" -> if the entered country is "Spain" or "Argentina" or "Mexico"
    o	"unknown" -> if the entered country is any other different from countries listed above*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String country = scanner.nextLine();

        String language = switch (country) {
            case "USA", "England" -> "English";
            case "Spain", "Argentina", "Mexico" -> "Spanish";
            default -> "unknown";};

        System.out.printf("%s", language);
    }
}