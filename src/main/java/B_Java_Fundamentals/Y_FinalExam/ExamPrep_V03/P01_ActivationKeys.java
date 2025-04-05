package B_Java_Fundamentals.Y_FinalExam.ExamPrep_V03;

import java.util.*;

public class P01_ActivationKeys {

/*You are about to make some good money, but first, you need to think of a way to verify who paid for your product and who didn't.
You have decided to let people use the software for a free trial period and then require an activation key to continue using the product.
Before you can cash out, the last step is to design a program that creates unique activation keys for each user. So, waste no more time and start typing!

The first line of the input will be your raw activation key. It will consist of letters and numbers only.
After that, until the "Generate" command is given, you will be receiving strings with instructions for different operations that need to be performed upon the raw activation key.

There are several types of instructions, split by ">>>":
    •	"Contains>>>{substring}":
        o	If the raw activation key contains the given substring, prints: "{raw activation key} contains {substring}".
                o	Otherwise, prints: "Substring not found!"
    •	"Flip>>>Upper/Lower>>>{startIndex}>>>{endIndex}":
        o	Changes the substring between the given indices (the end index is exclusive) to upper or lower case and then prints the activation key.
        o	All given indexes will be valid.
    •	"Slice>>>{startIndex}>>>{endIndex}":
        o	Deletes the characters between the start and end indices (the end index is exclusive) and prints the activation key.
                o	Both indices will be valid.
Input
    •	The first line of the input will be a string consisting of letters and numbers only.
    •	After the first line, until the "Generate" command is given, you will be receiving strings.
Output
    •	After the "Generate" command is received, print:
        o	"Your activation key is: {activation key}"*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String rawActivationKey = scanner.nextLine();
        StringBuilder activationKey = new StringBuilder(rawActivationKey);
        String input = scanner.nextLine();

        while (!input.equals("Generate")) {

            String command = input.split(">>>")[0];

            switch (command) {
                case "Contains" -> {
                    String substring = input.split(">>>")[1];
                    if (activationKey.toString().contains(substring)) {
                        System.out.printf("%s contains %s\n", activationKey, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                }
                case "Flip" -> {
                    String modifier = input.split(">>>")[1];
                    int indexStart = Integer.parseInt(input.split(">>>")[2]);
                    int indexEnd = Integer.parseInt(input.split(">>>")[3]);
                    String substring = "";
                    if (modifier.equals("Upper")) {
                        substring = activationKey.substring(indexStart, indexEnd).toUpperCase();
                    } else {
                        substring = activationKey.substring(indexStart, indexEnd).toLowerCase();
                    }
                    activationKey.replace(indexStart, indexEnd, substring);
                    System.out.println(activationKey);
                }
                case "Slice" -> {
                    int indexStart = Integer.parseInt(input.split(">>>")[1]);
                    int indexEnd = Integer.parseInt(input.split(">>>")[2]);
                    activationKey = new StringBuilder(activationKey.delete(indexStart, indexEnd));
                    System.out.println(activationKey);
                }
            }
            input = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s", activationKey);
    }
}