package B_Java_Fundamentals.Z_Projects;

import java.util.*;

public class P01_GuessTheNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random randomNumber = new Random();
        byte computerNumber = (byte) randomNumber.nextInt((100) + 1);
        byte playerInput = 0;
        boolean isFound = false;

        while (true) {
            byte counter = 0;
            System.out.println("Guess a number (1-100): ");
            String input = scanner.nextLine();
            for (int i = 0; i < input.length(); i++) {

                byte currentCharASCII = (byte) input.charAt(i);
                if (currentCharASCII >= 48 && currentCharASCII <= 57) {
                    counter++;
                    if (counter == input.length()) {
                        playerInput = Byte.parseByte(input);
                        if (playerInput >= 1 && playerInput <= 100) {
                            if (playerInput == computerNumber) {
                                System.out.println("You guessed it!");
                                isFound = true;
                                break;
                            } else if (playerInput < computerNumber) {
                                System.out.println("Too Low...");
                                continue;
                            } else {
                                System.out.println("Too High...");
                                continue;
                            }
                        } else {
                            System.out.println("Invalid input.");
                            continue;
                        }
                    }
                } else {
                    System.out.println("Invalid input.");
                    continue;
                }
            }
            if (isFound) {
                break;
            } else {
                continue;
            }
        }
    }
}
