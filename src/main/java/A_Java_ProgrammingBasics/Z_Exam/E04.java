package A_Java_ProgrammingBasics.Z_Exam;

import java.util.*;

public class E04 {

/* Г-жа Иванова иска да отслабне след празниците. Започвайки тренировка, първия ден тя пробягва М километра.
Следващите N дни, тя увеличава дневната си норма с К%. За да успее да отслабне, тя трябва да избяга минимум 1 000 км.
Съставете програма, която при получени начални километри, брой дни и проценти, с които тя ще увеличава всеки ден нормата си,
ще проверява дали километрите, които тя е избягала са достатъчни. Ако километрите не са достатъчни, на конзолата да се изведат недостигащите километри.
Ако са достатъчни да се изведе съобщение в което г-жа Иванова е поздравена за добре свършената работа.

От конзолата се четат поредица от числа, всяко на отделен ред:
    •	На първия ред – N – брой дни, в които г-жа Иванова тренира  – цяло число в интервала [1...50]
    •	На втория ред – M – километрите, които е избягала първия ден – реално число в интервала [1.00…500.00]
    •	За всеки един ден на отделен ред:
        o   Процентите, с които се увеличава дневната си норма – цяло число в интервала [1…100]

Да се отпечата на конзолата 1 ред, както следва:
    •	Ако пробяганите километри са >= 1 000 км – да се отпечатва съобщение:
        "You've done a great job running {избяганите километри повече от 1000} more   kilometers!"
    •	Ако пробяганите километри са < 1 000 км – да се отпечата съобщение:
        "Sorry Mrs.Ivanova, you need to run {недостигащите километри} more kilometers"

Резултатът да се форматира до по-голямото цяло число. */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int workoutDays = Integer.parseInt(scanner.nextLine());
        int kmTarget = 1000;
        double goal = Double.parseDouble(scanner.nextLine());
        double kmRanTotal = 0;
        kmRanTotal += goal;

        for (int i = 1; i <= workoutDays; i++) {
            int percentageIncrease = Integer.parseInt(scanner.nextLine());
            double increaseInKm = ((double) percentageIncrease / 100) * goal;
            goal += increaseInKm;
            kmRanTotal += goal;
        }

        if (kmRanTotal >= kmTarget) {
            System.out.printf("You've done a great job running %f more kilometers!", Math.ceil(kmRanTotal - kmTarget));
        } else {
            System.out.printf("Sorry Mrs. Ivanova, you need to run %f more kilometers", Math.ceil(kmTarget - kmRanTotal));
        }
    }
}

