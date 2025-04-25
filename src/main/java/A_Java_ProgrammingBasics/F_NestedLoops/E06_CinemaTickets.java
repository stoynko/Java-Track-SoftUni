package A_Java_ProgrammingBasics.F_NestedLoops;

import java.util.*;

public class E06_CinemaTickets {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String movieInput = scanner.nextLine();
        String movieName = "";
        int ticketGlobalCounter = 0;
        int studentCounter = 0;
        int standardCounter = 0;
        int kidCounter = 0;

        while (!movieInput.equals("Finish")) {
            movieName = movieInput;
            int availableTickets = Integer.parseInt(scanner.nextLine());
            int ticketMovieCounter = 0;
            int theatreCapacity = availableTickets;
            String ticketInput = "";

            while (availableTickets > 0 && !ticketInput.equals("End")) {
                ticketInput = scanner.nextLine();
                switch (ticketInput) {
                    case "student":
                        ticketMovieCounter++;
                        ticketGlobalCounter++;
                        studentCounter++;
                        availableTickets--;
                        break;
                    case "standard":
                        ticketMovieCounter++;
                        ticketGlobalCounter++;
                        standardCounter++;
                        availableTickets--;
                        break;
                    case "kid":
                        ticketMovieCounter++;
                        ticketGlobalCounter++;
                        kidCounter++;
                        availableTickets--;
                        break;
                    default:
                        break;
                }
            }
            if (availableTickets == 0) {
                System.out.printf("%s - 100.00%% full.\n", movieName);
            } else {
                System.out.printf("%s - %.2f%% full.\n", movieName, ((double) ticketMovieCounter / theatreCapacity) * 100);
            }
            movieInput = scanner.nextLine();
        }
        System.out.printf("Total tickets: %d\n", ticketGlobalCounter);
        System.out.printf("%.2f%% student tickets.\n", (double) studentCounter / ticketGlobalCounter * 100);
        System.out.printf("%.2f%% standard tickets.\n", (double) standardCounter / ticketGlobalCounter * 100);
        System.out.printf("%.2f%% kids tickets.\n", (double) kidCounter / ticketGlobalCounter * 100);
    }
}