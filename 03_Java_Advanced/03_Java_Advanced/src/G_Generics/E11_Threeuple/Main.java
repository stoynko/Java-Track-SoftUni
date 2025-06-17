package G_Generics.E11_Threeuple;

import java.util.*;

public class Main {

/*Now you are aware of a Class, which is probably a bad practice to use. Anyway, it is a nice example of using generics.
Our next task is to create another Tuple. This time, our task is harder. Create a Class Threeuple.
Its name tells us that it will no longer hold just a pair of objects. The task is simple, our Threeuple should hold three objects.
Make it have getters and setters. You can even extend the previous class.

Input (the input consists of three lines):
    •	The first one holds a name, an address, and a town. Format of the input: "{first name} {last name} {address} {town}"
    •	The second line holds a name, beer liters, and a Boolean variable - drunk or not. Format: "{name} {liters of beer} {drunk or not}"
    •	The last line will hold a name, a bank balance (double), and a bank name. Format: "{name} {account balance} {bank name}"
Output:
    •	Print the Threeuples objects in format: "{firstElement} -> {secondElement} -> {thirdElement}"*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String name = input.split("\\s+")[0] + " " + input.split("\\s+")[1];
        String address = input.split("\\s+")[2];
        String town = input.split("\\s+")[3];
        Threeuple<String, String, String> threeupleA = new Threeuple<>(name, address, town);
        System.out.println(threeupleA);

        input = scanner.nextLine();
        name = input.split("\\s+")[0];
        int liters = Integer.parseInt(input.split("\\s+")[1]);
        boolean isDrunk = false;
        if (input.split("\\s+")[2].equals("drunk")) {
            isDrunk = true;
        }
        Threeuple<String, Integer, Boolean> threeupleB = new Threeuple<>(name, liters, isDrunk);
        System.out.println(threeupleB);

        input = scanner.nextLine();
        name = input.split("\\s+")[0];
        double accountBalance = Double.parseDouble(input.split("\\s+")[1]);
        String bankName = input.split("\\s+")[2];
        Threeuple<String, Double, String> threeupleC = new Threeuple<>(name, accountBalance, bankName);
        System.out.println(threeupleC);
    }
}
