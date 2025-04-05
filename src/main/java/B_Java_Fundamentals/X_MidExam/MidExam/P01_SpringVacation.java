package B_Java_Fundamentals.X_MidExam.MidExam;

import java.util.*;

public class P01_SpringVacation {

/*A group of friends decides to go on a trip for a few days during spring vacation. They have a certain budget.
Your task is to calculate their expenses during the trip and find out if they will have enough money to finish the vacation.
Create a program that calculates traveling expenses by entering the following information:

    •	Days of the vacation
    •	Budget for the whole group
    •	The number of people
    •	Price for fuel per kilometer - it's the price for fuel that their car consumes per kilometer
    •	Food expenses per person for a day
    •	Hotel room (accommodation) price for one night per person

Before starting the trip, the group pays the total price for food and accommodation. If the group is larger than 10, it receives a 25% discount on the accommodation expenses.
Every day, they travel some distance, and you should calculate the expenses for the traveled kilometers. At the end of every third and every fifth day,
they have some additional expenses, which are 40% of the current value of the expenses. At the end of every seventh day, they receive a small amount of money for their expenses -
equal to the result of the calculation currentExpenses / numberOfPeople. If the expenses exceed the budget at some point, stop calculating and print the following message:
"Not enough money to continue the trip. You need {money}$ more."

If the budget is enough: "You have reached the destination. You have {money}$ budget left."

Print the result formatted 2 digits after the decimal separator.
Note: We accept that the days of the vacations to be equal to the number of nights in the hotel.
Input:
    •	On the 1st line, you are going to receive the days of the trip - an integer in the range [1…20].
    •	On the 2nd line - the budget - a real number in the range [0.00 - 100000.00].
    •	On the 3rd line - the number of people - an integer in the range [1 - 20].
    •	On the 4th line - the price for fuel per kilometer - a real number in the range [0.00 - 2.00].
    •	On the 5th line - food expenses per person for a day - a real number in the range [0.00 - 50.00].
    •	On the 6th line - the room's price for a night per person - a real number in the range [0.00 - 1000.00].
    •	On the next n lines - one for each of the days - the traveled distance in kilometers per day - a real number in the range [0.00 - 1000.00].

Output:
    •	Print the result formatted 2 digits after the decimal separator.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int totalDays = Integer.parseInt(scanner.nextLine()); // 10
        double budget = Double.parseDouble(scanner.nextLine()); // 20 500
        int people = Integer.parseInt(scanner.nextLine()); // 11
        double fuelPricePerKm = Double.parseDouble(scanner.nextLine()); // 1.2
        double foodPricePerDay = Double.parseDouble(scanner.nextLine()); // 8
        double roomPricePerNight = Double.parseDouble(scanner.nextLine()); // 13
        double totalPriceFoodAccomodation; // 10 * 11  * (13 + 8) = 2310
        if (people > 10) { // true
            totalPriceFoodAccomodation = (totalDays * people * ((roomPricePerNight * 0.75) + foodPricePerDay));
        } else {
            totalPriceFoodAccomodation = (totalDays * people * (roomPricePerNight + foodPricePerDay));
        }
        double currentExpenses = 0;
        currentExpenses += totalPriceFoodAccomodation; // = 1,732.5
        double additionalExpenses;
        boolean isEnough = true;

        for (int currentDay = 1; currentDay <= totalDays; currentDay++) {
            double traveledKm = Double.parseDouble(scanner.nextLine());
            currentExpenses += (traveledKm * fuelPricePerKm);
            if (currentDay % 3 == 0 || currentDay % 5 == 0) {
                currentExpenses += currentExpenses * 0.4;
            }
            if (currentExpenses > budget) {
                isEnough = false;
                break;
            }
            if (currentDay % 7 == 0) {
                currentExpenses -= currentExpenses / people;
            }
        }
        if (isEnough) {
            System.out.printf("You have reached the destination. You have %.2f$ budget left.", budget - currentExpenses);
        } else {
            System.out.printf("Not enough money to continue the trip. You need %.2f$ more.", Math.abs(currentExpenses - budget));
        }

    }
}
