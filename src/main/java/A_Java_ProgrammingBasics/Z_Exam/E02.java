package A_Java_ProgrammingBasics.Z_Exam;

import java.util.*;

public class E02 {

/* Като един истински запалянко Пепи решил да се подготви за световното първенство, като си закупи екип на любимия си футболен отбор.
В магазина, в който пазарувал предлагали тениски, шорти, чорапи и бутонки. Знае се, че цената на шортите е 75% от цената на тениските,
а цената на чорапите е 20% от цената на шортите. Бутонките струват два пъти колкото тениската и шортите взети заедно.
Тъй като Пепи редовно пазарува от този магазин, той има карта за отстъпка на стойност 15% от общата сума на покупката.
Ако сметката на Пепи е по-висока или равна на дадена сума, той получава подарък – точно копие на топката от световното.
Напишете програма, която изчислява дали Пепи е спечелил топката.

Входът се чете от конзолата и съдържа точно 2 реда:
    •	На първия ред - цената на тениската – реално число в интервала [1.00 ... 1000.00]
    •	На втория ред - сумата, която трябва да достигне, за да спечели топка – реално число в интервала [100.00 ... 10 000.00]

На конзолата се отпечатват два реда:
    •	Ако топката Е спечелена:
        o   "Yes, he will earn the world-cup replica ball!"
        o	"His sum is {сумата} lv."
    •	Ако  топката НЕ Е спечелена:
        o   "No, he will not earn the world-cup replica ball."
        o	"He needs {недостигащи пари} lv. more."

Резултатът да бъде форматиран до втората цифра след десетичната запетая.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double tShirtPrice = Double.parseDouble(scanner.nextLine());
        double targetPrice = Double.parseDouble(scanner.nextLine());

        double shortsPrice = tShirtPrice * 0.75;
        double socksPrice = shortsPrice * 0.2;
        double shoesPrice = (shortsPrice + tShirtPrice) * 2;
        double total = (tShirtPrice + shortsPrice + socksPrice + shoesPrice) - ((tShirtPrice + shortsPrice + socksPrice + shoesPrice) * 0.15);

        if (total >= targetPrice) {
            System.out.println("Yes, he will earn the world-cup replica ball!");
            System.out.printf("His sum is %.2f lv.", total);
        } else {
            System.out.println("No, he will not earn the world-cup replica ball.");
            System.out.printf("He needs %.2f lv. more.", targetPrice - total);
        }
    }
}
