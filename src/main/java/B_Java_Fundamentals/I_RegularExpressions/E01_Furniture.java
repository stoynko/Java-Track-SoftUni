package B_Java_Fundamentals.I_RegularExpressions;

import java.util.*;
import java.util.regex.*;

public class E01_Furniture {

/*Write a program to calculate the total cost of different types of furniture.
You will be given some lines of input until you receive the line "Purchase".
For the line to be valid, it should be in the following format:
    ">>{furniture name}<<{price}!{quantity}"
The price can be a floating-point number or a whole number. Store the names of the furniture and the total price.
In the end, print each bought furniture on a separate line in the format:
    "Bought furniture:
    {1st name}
    {2nd name}
    …"
And on the last line, print the following: "Total money spend: {spend money}", formatted to the second decimal point.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String regex = ">>(?<furnitureName>[A-Za-z]+)<<(?<price>\\d+.?\\d*)!(?<quantity>\\d+)";
        Pattern pattern = Pattern.compile(regex);
        String input = scanner.nextLine();
        double totalSpent = 0;
        System.out.printf("Bought furniture:\n");

        while (!input.equals("Purchase")) {

            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                System.out.printf("%s\n", matcher.group("furnitureName"));
                totalSpent += Double.parseDouble(matcher.group("price")) * Integer.parseInt(matcher.group("quantity"));
            }
            input = scanner.nextLine();
        }
        System.out.printf("Total money spend: %.2f\n", totalSpent);
    }
}
