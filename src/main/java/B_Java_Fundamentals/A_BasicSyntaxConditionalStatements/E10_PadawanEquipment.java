package B_Java_Fundamentals.A_BasicSyntaxConditionalStatements;

import java.util.*;

public class E10_PadawanEquipment {

/*Yoda is starting his newly created Jedi academy. So, he asked Master George Lucas to buy the needed equipment.
The number of items depends on how many students will sign up. The equipment for the Padawan contains lightsabers, belts, and robes.
You will be given the amount of money George Lucas has, the number of students, and the prices of each item.
You have to help George Lucas calculate if the money he has is enough to buy all of the equipment or how much more money he needs.
Because the lightsabers sometimes break, George Lucas should buy 10% more, rounded up to the next integer. Also, every sixth belt is free.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double balance = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double lightsaberPrice = Double.parseDouble(scanner.nextLine());
        double robePrice = Double.parseDouble(scanner.nextLine());
        double beltPrice = Double.parseDouble(scanner.nextLine());

        double totalCosts = (Math.ceil(students + (students * 0.1)) * lightsaberPrice) + (students * robePrice) + ((students - (students / 6)) * beltPrice);

        if (totalCosts > balance) {
            double difference = totalCosts - balance;
            System.out.printf("George Lucas will need %.2flv more.", difference);
        } else {
            System.out.printf("The money is enough - it would cost %.2flv.", totalCosts);
        }
    }
}