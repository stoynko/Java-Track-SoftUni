package A_BasicSyntaxConditionalStatements;

import java.util.*;

public class AE05_Messages {

/*Write a program that emulates typing an SMS, following this guide:

 1	   2    3
      abc  def
 4     5    6
ghi   jkl  mno
 7     8    9
pqrs  tuv  wxyz
       0
     space

Following the guide, 2 becomes "a", 22 becomes "b" and so on.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rowCount = Integer.parseInt(scanner.nextLine());
        StringBuilder message = new StringBuilder();

        for (int row = 1; row <= rowCount; row++) {
            String input = scanner.nextLine();
            String mainDigit = String.valueOf(input.charAt(0));
            int digitCount = -1;
            for (int currentCharacter = 0; currentCharacter <= input.length() - 1; currentCharacter++) {
                String currentChar = String.valueOf(input.charAt(currentCharacter));
                if (currentChar.equals(mainDigit)) {
                    digitCount++;
                }
            }

            switch (mainDigit) {
                case "2" -> {
                    String key2 = "abc";
                    message.append(key2.charAt(digitCount));
                }
                case "3" -> {
                    String key3 = "def";
                    message.append(key3.charAt(digitCount));
                }
                case "4" -> {
                    String key4 = "ghi";
                    message.append(key4.charAt(digitCount));
                }
                case "5" -> {
                    String key5 = "jkl";
                    message.append(key5.charAt(digitCount));
                }
                case "6" -> {
                    String key6 = "mno";
                    message.append(key6.charAt(digitCount));
                }
                case "7" -> {
                    String key7 = "pqrs";
                    message.append(key7.charAt(digitCount));
                }
                case "8" -> {
                    String key8 = "tuv";
                    message.append(key8.charAt(digitCount));
                }
                case "9" -> {
                    String key9 = "wxyz";
                    message.append(key9.charAt(digitCount));
                }
                case "0" -> {
                    message.append(" ");
                }
            }
        }
        System.out.println(message);
    }
}