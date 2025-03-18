package B_Fundamentals.I_RegularExpressions;

import java.util.*;
import java.util.regex.*;

public class E06_ValidatePassword {

/*Your first task is to determine if the given sequence of characters is a valid online banking password.
Each line must not contain anything else but a valid password. A password is valid when:
    •	It is surrounded by a "_" followed by one or more "."
    •	It is at least 6 characters long (without the surrounding "_" or ".")
    •	It starts with a capital letter
    •	It contains only letters (lower and upper case) and digits
    •	It ends with a capital letter
         o   Examples of valid passwords: _...ChelseA_., _..Online1BankinG_., _.Valid1PasS_., _.A123f23A_.
         o   Examples of invalid passwords: __InvalidPass.., _Invalid_, _.Invalid.IteM_., _.pass1InvaliD_.
Next, you have to determine which group the password is from. The group is obtained by concatenating all the digits found in the password, if any. If there are no digits present in the password, the default group is "default".
    • Examples:
        o _...ChelseA_. -> group: default
        o _..Online1BankinG_. -> group: 1
        o _.A123f23A_.-> group: 12323
Input:
    • On the first line, you will be given an integer n – the count of passwords that you will be receiving next.
    • On the following n lines, you will receive different strings.
Output:
    • For each password that you process, you need to print a message.
        o If the password is invalid: "Invalid pass!"
        o If the password is valid: "Group: {group}"*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String regex = "\\.+(?<passwordBody>[A-Z][A-Za-z0-9]{4,}[A-Z])_\\.?";
        Pattern pattern = Pattern.compile(regex);
        int passwordsCount = Integer.parseInt(scanner.nextLine());

        for (int currentPassword = 1; currentPassword <= passwordsCount; currentPassword++) {

            StringBuilder concatenatedPassword = new StringBuilder();
            Matcher matcher = pattern.matcher(scanner.nextLine());

            if (matcher.find()) {
                for (char symbol : matcher.group("passwordBody").toCharArray()) {
                    if (Character.isDigit(symbol)) {
                        concatenatedPassword.append(symbol);
                    }
                }
                if (concatenatedPassword.isEmpty()) {
                    System.out.println("Group: default");
                } else {
                    System.out.printf("Group: %s\n", concatenatedPassword);
                }
            } else {
                System.out.println("Invalid pass!");
            }
        }
    }
}