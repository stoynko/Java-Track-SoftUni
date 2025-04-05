package C_Java_Advanced.A_StacksAndQueues;

import java.util.*;

public class E10_Robotics {

/*Somewhere in the future, there will be a robotics factory. The current project is assembly-line robots.
Each robot has a processing time, the time it needs to process a product. When a robot is free,
it should take a product for processing and log its name, product, and processing start time.
Each robot processes a product coming from the assembly line. A product comes from the line each second
(so the first product should appear at [start time + 1 second]). If a product passes the line and there is no free robot to take it,
it should be queued at the end of the line again. The robots are standing in the line in the order of their appearance.

    Input:
        •	On the first line, you will get the names of the robots and their processing times in the format
        "robotName-processTime;robotName-processTime;robotName-processTime".
        •	On the second line, you will get the starting time in the format "hh:mm:ss".
        •	Next, until the "End" command, you will get a product on each line.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        String[] robotData = scanner.nextLine().split(";");
        String[] robots = new String[robotData.length];
        int[] processTime = new int[robotData.length];
        int[] remainingTime = new int[robotData.length]; // Tracks robot's remaining busy time

        for (int i = 0; i < robotData.length; i++) {
            String[] data = robotData[i].split("-");
            robots[i] = data[0];
            processTime[i] = Integer.parseInt(data[1]);
        }

        String[] timeParts = scanner.nextLine().split(":");
        int startTimeInSeconds = Integer.parseInt(timeParts[0]) * 3600
                + Integer.parseInt(timeParts[1]) * 60
                + Integer.parseInt(timeParts[2]);


        ArrayDeque<String> productsQueue = new ArrayDeque<>();
        String productInput;
        while (!(productInput = scanner.nextLine()).equals("End")) {
            productsQueue.offer(productInput);
        }

        int currentTime = startTimeInSeconds;

        while (!productsQueue.isEmpty()) {
            currentTime++;
            String currentProduct = productsQueue.poll();
            boolean isAssigned = false;

            for (int currentRobot = 0; currentRobot < robots.length; currentRobot++) {
                if (remainingTime[currentRobot] == 0) {
                    remainingTime[currentRobot] = processTime[currentRobot];
                    printAssignment(robots[currentRobot], currentProduct, currentTime);
                    isAssigned = true;
                    break;
                }
            }

            for (int i = 0; i < robots.length; i++) {
                if (remainingTime[i] > 0) {
                    remainingTime[i]--;
                }
            }

            if (!isAssigned) {
                productsQueue.offer(currentProduct);
            }
        }
    }

    private static void printAssignment(String robotName, String product, int currentTime) {
        int hours = (currentTime / 3600) % 24;
        int minutes = (currentTime / 60) % 60;
        int seconds = currentTime % 60;
        System.out.printf("%s - %s [%02d:%02d:%02d]%n", robotName, product, hours, minutes, seconds);
    }
}