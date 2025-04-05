package B_Java_Fundamentals.A_BasicSyntaxConditionalStatements;

import java.util.*;

public class E11_RageExpenses {

/*As a MOBA challenger player, Peter has the bad habit of trashing his PC when he loses a game and rage quits.
His gaming setup consists of a headset, mouse, keyboard, and display. You will receive Peter's lost games count.
Every second lost game, Peter trashes his headset. Every third lost game, Peter trashes his mouse.
When Peter trashes both his mouse and headset in the same lost game, he also trashes his keyboard.
Every second time when he trashes his keyboard, he also trashes his display.
You will receive the price of each item in his gaming setup. Calculate his rage expenses for renewing his gaming equipment.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int gamesLost = Integer.parseInt(scanner.nextLine());
        double priceHeadset = Double.parseDouble(scanner.nextLine());
        double priceMouse = Double.parseDouble(scanner.nextLine());
        double priceKeyboard = Double.parseDouble(scanner.nextLine());
        double priceDisplay = Double.parseDouble(scanner.nextLine());

        int counterHeadset = 0;
        int counterMouse = 0;
        int counterKeyboard = 0;
        int counterDisplay = 0;

        for (int gameCount = 1; gameCount <= gamesLost; gameCount++) {
            if (gameCount % 2 == 0) {
                counterHeadset++;
            }
            if (gameCount % 3 == 0) {
                counterMouse++;
            }
            if (gameCount % 6 == 0) {
                counterKeyboard++;
            }
            if (gameCount % 12 == 0) {
                counterDisplay++;
            }
        }
        double expenses = (counterHeadset * priceHeadset) + (counterMouse * priceMouse) + (counterKeyboard * priceKeyboard) + (counterDisplay * priceDisplay);

        System.out.printf("Rage expenses: %.2f lv.", expenses);
    }
}