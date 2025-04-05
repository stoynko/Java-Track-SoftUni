package C_Java_Advanced.A_StacksAndQueues;

import java.util.*;

public class L01_BrowserHistory {

/*Write a program that takes two types of browser instructions:
    •	Normal navigation: a URL is set, given by a string;
    •	The string "back" sets the current URL to the last set URL
After each instruction, the program should print the current URL. If the back instruction can't be executed, print
"no previous URLs".

The input ends with the "Home" command, and then you simply have to stop the program.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> browserBackwardHistory = new ArrayDeque<>();
        String input = scanner.nextLine();
        String currentURL = "";
        boolean firstEntry = false;

        while (!input.equals("Home")) {

            switch (input) {
                case "back" -> {
                    if (!browserBackwardHistory.isEmpty()) {
                        currentURL = browserBackwardHistory.pop();
                        System.out.println(currentURL);
                    } else {
                        System.out.println("no previous URLs");
                    }
                }
                default -> {
                    if (firstEntry) {
                        browserBackwardHistory.push(currentURL);
                    }
                    currentURL = input;
                    firstEntry = true;
                    System.out.println(currentURL);
                }
            }
            input = scanner.nextLine();
        }
    }
}
