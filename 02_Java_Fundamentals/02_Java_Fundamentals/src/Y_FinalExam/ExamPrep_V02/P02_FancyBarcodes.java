package Y_FinalExam.ExamPrep_V02;

import java.util.*;
import java.util.regex.*;

public class P02_FancyBarcodes {

/*Your first task is to determine if the given sequence of characters is a valid barcode or not.
Each line must not contain anything else but a valid barcode. A barcode is valid when:
    •	It is surrounded by a "@" followed by one or more "#"
    •	It is at least 6 characters long (without the surrounding "@" or "#")
    •	It starts with a capital letter
    •	It contains only letters (lower and upper case) and digits
    •	It ends with a capital letter
Examples of valid barcodes: @###Che46sE@##, @#FreshFisH@#, @###Brea0D@###, @##Che46sE@##
Examples of invalid barcodes: ##InvaliDiteM##, @InvalidIteM@, @#Invalid_IteM@#
Next, you have to determine the product group of the item from the barcode. The product group is obtained by concatenating all the digits found in the barcode.
If there are no digits present in the barcode, the default product group is "00".
Examples:
    @#FreshFisH@# -> product group: 00
    @###Brea0D@### -> product group: 0
    @##Che4s6E@## -> product group: 46
Input:
    •	On the first line, you will be given an integer n – the count of barcodes that you will be receiving next.
    •	On the following n lines, you will receive different strings.
Output:
    •	For each barcode that you process, you need to print a message.
If the barcode is invalid:
    •	"Invalid barcode"
If the barcode is valid:
    •	"Product group: {product group}"*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String regex = "([@][#]+)(?<body>[A-Z]([A-Za-z0-9]+){4,}[A-Z])([@][#]+)";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 1; i <= n; i++) {

            Matcher matcher = pattern.matcher(scanner.nextLine());

            if (matcher.find()) {
                StringBuilder productGroup = new StringBuilder();
                for (char c : matcher.group("body").toCharArray()) {
                    if (Character.isDigit(c)) {
                        productGroup.append(c);
                    }
                }
                if (productGroup.isEmpty()) {
                    productGroup.append("00");
                }
                System.out.printf("Product group: %s\n", productGroup);
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}