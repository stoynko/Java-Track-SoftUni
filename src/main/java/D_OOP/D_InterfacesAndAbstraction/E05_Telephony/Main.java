package D_OOP.D_InterfacesAndAbstraction.E05_Telephony;

import java.util.*;
import java.util.stream.*;

public class Main {

/*You have a business - manufacturing cell phones. But you have no software developers, so you call your friends and ask them to help
you create cell phone software. They agree and you start working on the project. The project consists of one main model - a Smartphone.
Each of your smartphones should have functionalities of calling other phones and browsing on the world wide web.
Your friends are very busy, so you decide to write the code on your own. Here is the mandatory assignment:

You should have a model - Smartphone and two separate functionalities which your smartphone has -
to call other phones and to browse the world wide web. You should end up with one class and two interfaces.

<<Interface>>                   <<Interface>>
Callable                        Browsable
+	call(): String              +	browse(): String

Smartphone
    -	numbers: List<String>
    -	urls: List<String>
    +	Smartphone(List<String>, List<String>)
    +	call(): String
    +	browse(): String

The input comes from the console. It will hold two lines:
    •	First line: phone numbers to call (String), separated by spaces.
    •	Second line: sites to visit (String), separated by spaces.
Output:
    •	First, call all numbers in the order of input then browse all sites in order of input.
    •	The functionality of calling phones is printing on the console the number which is being called in the format:
        "Calling... {number}".
    •	The functionality of the browser should print on the console the site in the format:
        "Browsing: {site}!" (pay attention to the exclamation mark when printing URLs).
    •	If there is a number in the input of the URLs, print: "Invalid URL!" and continue printing the rest of the URLs.
    •	If there is a character different from a digit in a number, print: "Invalid number!" and continue to the next number.
Constraints
    •	Each site's URL should consist only of letters and symbols (No digits are allowed in the URL address). */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> phoneNumbers = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toUnmodifiableList());
        List<String> sitesToVisit = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toUnmodifiableList());
        Smartphone smartphone = new Smartphone(phoneNumbers, sitesToVisit);

        System.out.println(smartphone.call());
        System.out.println(smartphone.browse());
    }
}
