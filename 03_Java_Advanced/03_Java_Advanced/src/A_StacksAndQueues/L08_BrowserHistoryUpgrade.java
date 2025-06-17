package A_StacksAndQueues;

import java.util.*;

public class L08_BrowserHistoryUpgrade {

/*Extend "Browser History" with a "forward" instruction, which visits URLs that were navigated away from by "back".
Each forward instruction visits the next most recent such URL. If normal navigation happens,
all potential forward URLs are removed until a new back instruction is given if the forward instruction can't be executed,
print:  "no next URLs".*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> browserBackwardHistory = new ArrayDeque<>();
        ArrayDeque<String> browserForwardHistory = new ArrayDeque<>();
        String input = scanner.nextLine();
        String currentURL = "";
        boolean firstEntry = false;

        while (!input.equals("Home")) {

            switch (input) {
                case "back" -> {
                    if (!browserBackwardHistory.isEmpty()) {
                        browserForwardHistory.push(currentURL);
                        currentURL = browserBackwardHistory.pop();
                        System.out.println(currentURL);
                    } else {
                        System.out.println("no previous URLs");
                    }
                }
                case "forward" -> {
                    if (!browserForwardHistory.isEmpty()) {
                        browserBackwardHistory.push(currentURL);
                        currentURL = browserForwardHistory.pop();
                        System.out.println(currentURL);
                    } else {
                        System.out.println("no next URLs");
                    }
                }
                default -> {
                    if (firstEntry) {
                        browserBackwardHistory.push(currentURL);
                    }
                    currentURL = input;
                    firstEntry = true;
                    System.out.println(currentURL);
                    browserForwardHistory.clear();
                }
            }
            input = scanner.nextLine();
        }
    }
}
