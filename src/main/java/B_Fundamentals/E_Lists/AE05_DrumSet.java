package B_Fundamentals.E_Lists;

import java.util.*;
import java.util.stream.*;

public class AE05_DrumSet {

/*You will receive Gabsy's savings, the money she can spend on new drums. Next, you receive a sequence of integers which represent the initial quality of each drum in Gabsy's drum set.
Until you receive the command "Hit it again, Gabsy!", you will be receiving an integer: the hit power Gabsy applies on each drum while practicing.  When the power is applied,
you should decrease the value of the drum's quality with the current power. When a certain drum reaches 0 quality, it breaks. Then Gabsy should buy a replacement. She needs to buy the same model.
Therefore, its quality will be the same as the initial quality of the broken drum. The price is calculated by the formula: {initialQuality} * 3.
Gabsy will always replace her broken drums until the moment she can no longer afford them. If she doesn't have enough money for a replacement, the broken drum is removed from the drum set.
When you receive the command "Hit it again, Gabsy!", the program ends, and you should print the current state of the drum set. On the second line, you should print the remaining money in Gabsy's savings account.

Input:
    •	On the first line, you receive the savings – a floating-point number.
    •	On the second line, you receive the drum set: a sequence of integers separated by spaces.
    •	Until you receive the command "Hit it again, Gabsy!" you will be receiving integers – the hit power Gabsy applies on each drum.
Output:
    •	On the first line, you should print each drum in the drum set, separated by space.
    •	Then you must print the money that is left on the second line in the format "Gabsy has {money left}lv.", formatted with two digits after the decimal point.
Constraints:
    •	The savings – the floating-point number in the range [0.00, 10000.00].
    •	The quality of each drum in the drum set – is an integer in the range [1, 1000].
    •	The hit power will be in the range [0, 1000].
    •	Allowed working time / memory: 100ms / 16MB.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double savings = Double.parseDouble(scanner.nextLine());
        List<Integer> initialQuality = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> newQuality = new ArrayList<>(initialQuality);
        String input = scanner.nextLine();

        while (!input.equals("Hit it again, Gabsy!")) {
            int hitPower = Integer.parseInt(input);
            for (int index = 0; index <= newQuality.size() - 1; index++) {
                newQuality.set(index, newQuality.get(index) - hitPower);
                if (newQuality.get(index) <= 0) {
                    double cost = initialQuality.get(index) * 3;
                    if (savings >= cost) {
                        newQuality.set(index, initialQuality.get(index));
                        savings -= cost;
                    } else {
                        newQuality.remove(index);
                        initialQuality.remove(index);
                        index--;
                    }
                }
            }
            input = scanner.nextLine();
        }
        System.out.println(newQuality.toString().replaceAll("[\\[\\],]", ""));
        System.out.printf("Gabsy has %.2flv.", savings);
    }
}
