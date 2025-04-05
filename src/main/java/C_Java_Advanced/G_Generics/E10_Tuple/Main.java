package C_Java_Advanced.G_Generics.E10_Tuple;

import java.util.*;

public class Main {

/*There is something really annoying in the C# - language. It is called a Tuple. It is a class that contains two objects.
The first one is item1, and the second one is item2. It is kind of like a Map.Entry except - it simply has items that are neither key nor value.
The annoyance comes from the fact that you have no idea what these objects hold. The class name is telling you nothing,
the methods which it has – too. So let's say we could try to implement it in Java, just for practicing generics.
Create a class Tuple, which is holding two objects. As we said, the first one will be an item1, and the second one - an item2.
The tricky part here is to make the class hold generics. This means that when you create a new object of class - Tuple,
there should be a way to explicitly specify both the items type separately.

Input (the input consists of three lines):
    •	The first one is holding a person's name and an address. They are separated by space.
        Your task is to collect them in the tuple and print them on the console. Format: "{first name} {last name} {address}"
    •	The second line holds a person's name and the amount of beer he can drink. Format: "{name} {liters of beer}"
    •	The last line will hold an Integer and a Double. Format: "{Integer} {Double}"

Output:
    •	Print the tuples items in format: "{item1} -> {item2}"

Constraints:
    •	Use the good practices we have learned. Create the class and make it have getters and setters for its class variables.
    The input will be valid, no need to check it explicitly! */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] firstInput = scanner.nextLine().split("\\s+");
        Tuple<String, String> tupleA = new Tuple<>(firstInput[0] + " " + firstInput[1], firstInput[2]);
        String[] secondInput = scanner.nextLine().split("\\s+");
        Tuple<String, Integer> tupleB = new Tuple<>(secondInput[0], Integer.parseInt(secondInput[1]));
        String[] thirdInput = scanner.nextLine().split("\\s+");
        Tuple<Integer, Double> tupleC = new Tuple<>(Integer.parseInt(thirdInput[0]), Double.parseDouble(thirdInput[1]));
        System.out.println(tupleA);
        System.out.println(tupleB);
        System.out.println(tupleC);
    }
}
