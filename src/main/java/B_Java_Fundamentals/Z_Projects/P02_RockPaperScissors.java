package B_Java_Fundamentals.Z_Projects;

import java.util.*;

public class P02_RockPaperScissors {

    public static void main(String[] args) {

        System.out.println("Choose [r]ock, [p]aper or [s]cissors:");
        final String ROCK = "rock";
        final String PAPER = "paper";
        final String SCISSORS = "scissors";
        Scanner scanner = new Scanner(System.in);
        String playerInput = scanner.nextLine();
        String playerMove = "";

        while (true) {
            if (playerInput.equals("r") || playerInput.equals("rock")) {
                playerMove = "rock";
                break;
            } else if (playerInput.equals("p") || playerInput.equals("paper")) {
                playerMove = "paper";
                break;
            } else if (playerInput.equals("s") || playerInput.equals("scissors")) {
                playerMove = "scissors";
                break;
            } else {
                System.out.println("Invalid input. Please try again...");
                playerInput = scanner.nextLine();
            }
        }

        Random random = new Random();
        int randomNumber = random.nextInt(3);
        String computerMove = switch (randomNumber) {
            case 0 -> "rock";
            case 1 -> "paper";
            case 2 -> "scissors";
            default -> "";
        };
        System.out.printf("You chose %s.%n", playerMove);
        System.out.printf("The computer chose %s.%n", computerMove);
        String result = "";
        if (playerMove.equals(computerMove)) {
            result = "Draw..";
        } else if (playerMove.equals("rock") && computerMove.equals("scissors") ||
                playerMove.equals("paper") && computerMove.equals("rock") ||
                playerMove.equals("scissors") && computerMove.equals("paper")) {
            result = "You win!";
        } else {
            result = "You lose!";
        }
        System.out.printf("Outcome: %s", result);
    }
}
