package C_SetsAndDictionariesAdvanced;

import java.util.*;

public class E05_Phonebook {

/*Write a program that receives some info from the console about people and their phone numbers.
You are free to choose how the data is entered. Each entry should have just one name and one number (both of them strings).
If you receive a name that already exists in the phonebook, simply update its number.
After filling this simple phonebook, upon receiving the command "search", your program should be able to perform a search of contact by
name and print her details in the format "{name} -> {number}". In case the contact isn't found, print "Contact {name} does not exist.".*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, String> phonebook = new HashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("search")) {

            String name = input.split("-")[0];
            String phoneNumber = input.split("-")[1];

            if (!phonebook.containsKey(name)){
                phonebook.put(name, phoneNumber);
            } else {
                phonebook.put(name, phoneNumber);
            }
            input = scanner.nextLine();
        }

        if (input.equals("search")) {

            String name = scanner.nextLine();
            while (!name.equals("stop")) {

                if (phonebook.containsKey(name)){
                    System.out.printf("%s -> %s\n", name, phonebook.get(name));
                } else {
                    System.out.printf("Contact %s does not exist.\n", name);
                }

                name = scanner.nextLine();
            }
        }
    }
}
