package B_DataTypesAndVariables;

import java.util.*;

public class AE06_BalancedBrackets {

/*You will receive n lines. On those lines, you will receive one of the following:
    •	Opening bracket – "("
    •	Closing bracket – ")"
    •	Random string

Your task is to find out if the brackets are balanced. That means after every closing bracket should follow an opening one.
Nested parentheses are not valid, and if two consecutive opening brackets exist, the expression should be marked as unbalanced.

    •	On the first line, you will receive n – the number of lines that will follow.
    •	On the next n lines, you will receive "(", ")" or another string.

You must print "BALANCED" if the parentheses are balanced and "UNBALANCED" otherwise.

Constraints:
    •	n will be in the interval [1…20].
    •	The length of the stings will be between [1…100] characters.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        byte rowCount = Byte.parseByte(scanner.nextLine());

        byte openingCounter = 0;
        boolean isBalanced = true;

        for (int i = 1; i <= rowCount; i++) {

            String input = scanner.nextLine();
            if (input.length() == 1) {
                if (input.equals("(")) {
                    openingCounter++;
                } else if (input.equals(")")) {
                    if (openingCounter > 0) {
                        openingCounter--;
                    } else {
                        isBalanced = false;
                    }
                }
            }
        }
        if (isBalanced && openingCounter == 0) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}