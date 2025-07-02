package I_RegularExpressions;

import java.util.*;
import java.util.regex.*;

public class AE01_WinningTicket {

/* The lottery is exciting. What is not is checking a million tickets for winnings only by hand. So, you are given the task of creating a program that automatically checks if a ticket is a winner.
You are given a collection of tickets separated by commas and spaces. You need to check every one of them if it has a winning combination of symbols.
A valid ticket should have exactly 20 characters. The winning symbols are '@', '#', '$' and '^'. But for a ticket to be a winner,
the symbol should uninterruptedly repeat at least 6 times in both the ticket left half and the ticket right half.
For example, a valid winning ticket should be something like this: "Cash$$$$$$Ca$$$$$$sh"

The left half "Cash$$$$$$" contains "$$$$$$", which is also contained in the ticket right half "Ca$$$$$$sh". A winning ticket should contain symbols repeating up to 10 times in both halves, which is considered a Jackpot (for example: "$$$$$$$$$$$$$$$$$$$$").
Input:
The input will be read from the console. The input consists of a single line containing all tickets separated by commas and one or more white spaces in the format:
    •	"{ticket}, {ticket}, … {ticket}"
Output:

Print the result for every ticket in the order of their appearance, each on a separate line in the format:
    •	"invalid ticket" - Invalid ticket
    •	"ticket "{ticket}" - no match" - no match
    •	"ticket "{ticket}" - {match length}{match symbol}" - Match with length 6 to 9
    •	"ticket "{ticket}" - {match length}{match symbol} Jackpot!" - Match with length 10

Constraints:
    •	The number of tickets will be in the range [0 … 100].*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] ticketsCollection = Arrays.stream(scanner.nextLine().split(",")).map(String::trim).toArray(String[]::new);
        String regex = "(?<ticketLeft>(\\w*)?([@#$^]{5,10})(\\w*)?)(?<ticketRight>(\\w*)?([@#$^]{5,10})(\\w*)?)";
        Pattern pattern = Pattern.compile(regex);

        for (String ticket : ticketsCollection) {

            if (ticket.length() != 20) {
                System.out.println("invalid ticket");
            } else {
                Matcher matcher = pattern.matcher(ticket);

                if (matcher.find()) {

                    String leftHalf = filterTicket(matcher.group("ticketLeft"));
                    String rightHalf = filterTicket(matcher.group("ticketRight"));
                    int ticketPrize = 0;
                    char winningSymbol = ' ';

                    int cycles = Math.min(leftHalf.length(), rightHalf.length());
                    int currentMatches = 0;
                    char currentMostMatchedSymbol = ' ';
                    int mostMatches = 0;
                    char mostMatchedSymbol = ' ';
                    char lastChar = leftHalf.charAt(0);
                    for (int index = 0; index < cycles; index++) {

                        if (leftHalf.charAt(index) == rightHalf.charAt(index) && leftHalf.charAt(index) == lastChar) {
                            currentMatches++;
                            currentMostMatchedSymbol = leftHalf.charAt(index);
                            lastChar = leftHalf.charAt(index);
                        } else {
                            currentMatches = 0;
                            currentMostMatchedSymbol = ' ';
                            lastChar = leftHalf.charAt(index);
                        }
                        if (currentMatches > mostMatches) {
                            mostMatches = currentMatches;
                            mostMatchedSymbol = currentMostMatchedSymbol;
                        }

                    }

                    ticketPrize = mostMatches;
                    winningSymbol = mostMatchedSymbol;


                    if (ticketPrize >= 6 && ticketPrize < 10) {
                        System.out.printf("ticket \"%s\" - %d%c\n", ticket, ticketPrize, winningSymbol);
                    } else if (ticketPrize == 10) {
                        System.out.printf("ticket \"%s\" - %d%c Jackpot!\n", ticket, ticketPrize, winningSymbol);
                    } else if (ticketPrize == 0 || ticketPrize < 6) {
                        System.out.printf("ticket \"%s\" - no match\n", ticket);
                    }
                } else {
                    System.out.printf("ticket \"%s\" - no match\n", ticket);
                }
            }
        }
    }

    private static String filterTicket(String ticket) {
        return ticket.replaceAll("[^@#$^]", "");
    }
}