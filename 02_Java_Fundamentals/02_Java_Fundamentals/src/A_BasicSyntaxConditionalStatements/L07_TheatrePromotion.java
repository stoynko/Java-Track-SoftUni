package A_BasicSyntaxConditionalStatements;

import java.util.*;

public class L07_TheatrePromotion {

/*A theatre is having a ticket sale, but they need a program to calculate the price of a single ticket.
If the given age does not fit one of the categories, you should print "Error!". You can see the prices in the table below:

Day / Age	0 <= age <= 18	  18 < age <= 64	64 < age <= 122

Weekday	         12$	           18$	             12$
Weekend	         15$	           20$	             15$
Holiday	          5$	           12$	             10$

The input comes in two lines. On the first line, you will receive the type of day. On the second – is the age of the person.
Print the ticket price according to the table, or "Error!" if the age is not in the table.

Constraints:
    •	The age will be in the interval [-1000…1000].
    •	The type of day will always be valid.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String dayType = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        int price = 0;
        boolean isValid = true;

        if (age >= 0 && age <= 18) {
            switch (dayType) {
                case "Weekday" -> price = 12;
                case "Weekend" -> price = 15;
                case "Holiday" -> price = 5;
            }
        } else if (age > 64 && age <= 122) {
            switch (dayType) {
                case "Weekday" -> price = 12;
                case "Weekend" -> price = 15;
                case "Holiday" -> price = 10;
            }
        } else if (age > 18 && age <= 64) {
            switch (dayType) {
                case "Weekday" -> price = 18;
                case "Weekend" -> price = 20;
                case "Holiday" -> price = 12;
            }
        } else {
            isValid = false;
        }
        if (isValid)
            System.out.printf("%d$", price);
        else
            System.out.println("Error!");
    }
}