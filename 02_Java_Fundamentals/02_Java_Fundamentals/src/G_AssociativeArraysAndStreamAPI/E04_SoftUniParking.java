package G_AssociativeArraysAndStreamAPI;

import java.util.*;

public class E04_SoftUniParking {

/*SoftUni just got a new parking lot. It's so fancy, it even has online parking validation. Except, the online service doesn't work.
It can only receive users' data but doesn't know what to do with it. Good thing you're on the dev team and know how to fix it, right?
Write a program that validates parking for an online service. Users can register to park and unregister to leave. The program receives 2 commands:

    •	"register {username} {licensePlateNumber}":
        o	The system only supports one car per user at the moment, so if a user tries to register another license plate using the same username,
            the system should print: "ERROR: already registered with plate number {licensePlateNumber}"
        o	If the aforementioned checks pass successfully, the plate can be registered, so the system should print:
            "{username} registered {licensePlateNumber} successfully"

    •	"unregister {username}":
        o	If the user is not present in the database, the system should print:
        "ERROR: user {username} not found"
        o	If the aforementioned check passes successfully, the system should print:
        "{username} unregistered successfully"

    After you execute all of the commands, print all the currently registered users and their license plates in the format: "{username} => {licensePlateNumber}"

Input:
    •	First line: n - number of commands – integer.
    •	Next n lines: commands in one of two possible formats:
        o	Register: "register {username} {licensePlateNumber}"
        o	Unregister: "unregister {username}"

The input will always be valid, and you do not need to check it explicitly.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberofCommands = Integer.parseInt(scanner.nextLine());
        Map<String, String> parkingData = new LinkedHashMap<>();

        for (int curentCommand = 1; curentCommand <= numberofCommands; curentCommand++) {

            String[] commands = scanner.nextLine().split("\\s+");
            String commandType = commands[0];
            String userName = commands[1];

            if (commandType.equals("register")) {
                if (parkingData.containsKey(userName)) {
                    System.out.printf("ERROR: already registered with plate number %s%n", parkingData.get(userName));
                } else {
                    String licensePlateNumber = commands[2];
                    parkingData.put(userName, licensePlateNumber);
                    System.out.printf("%s registered %s successfully%n", userName, licensePlateNumber);
                }

            } else if (commandType.equals("unregister")) {
                if (!parkingData.containsKey(userName)) {
                    System.out.printf("ERROR: user %s not found%n", userName);
                } else {
                    parkingData.remove(userName);
                    System.out.printf("%s unregistered successfully%n", userName);
                }
            }
        }

        for (Map.Entry<String, String> entry : parkingData.entrySet()) {
            System.out.printf("%s => %s%n", entry.getKey(), entry.getValue());
        }
    }
}
