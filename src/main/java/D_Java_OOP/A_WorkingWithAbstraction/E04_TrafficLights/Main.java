package D_Java_OOP.A_WorkingWithAbstraction.E04_TrafficLights;

import java.util.*;

public class Main {

/*Implement a simple state machine in the form of a traffic light.
Every traffic light has three possible signals - red, green, and yellow. Each traffic light can be updated,
which changes the color of its signal (e.g. if it is currently red, it changes to green, if it is green it changes
to yellow). The order of signals is red -> green -> yellow -> red and so on.

On the first line, you will be given multiple traffic light signals in the format "RED GREEN YELLOW".
They may be 3, more, or less than 3. You need to make as many traffic lights as there are signals in the input.
On the second line, you will receive the n number of times you need to change each traffic light's signal.

Your output should consist of n number of lines, including each updated traffic light's signal. */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] colorSignals = scanner.nextLine().split(" ");
        List<TrafficLight> trafficLights = Arrays.stream(colorSignals)
                                            .map(TrafficSignal::valueOf)
                                            .map(TrafficLight::new)
                                            .toList();

        int iterations = Integer.parseInt(scanner.nextLine());

        for (int iteration = 1; iteration <= iterations ; iteration++) {

            trafficLights.stream().forEach(trafficLight -> {
                trafficLight.changeSignal();
                System.out.print(trafficLight.getColor() + " ");
            });
            System.out.println();
        }
    }
}
