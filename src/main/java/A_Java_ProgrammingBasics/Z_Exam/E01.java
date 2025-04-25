package A_Java_ProgrammingBasics.Z_Exam;

import java.util.*;

public class E01 {

/* За да са здрави котките, храненето им трябва да следва определена диета. Напишете програма, която изчислява котешкото процентно разпределение на макроелементите в храната за един ден и
пресмята колко средно калории дава един грам от тази храна. Макроелементите са: мазнини, протеини и въглехидрати.
Разполагате с общия брой калории, които котката трябва да приеме за един ден.

Известно е, че:
    •	1 грам мазнини = 9 калории
    •	1 грам протеини = 4 калории
    •	1 грам въглехидрати = 4 калории

За да разберете колко калории дава един грам храна на котката, ще трябва да направите изчисления с реалното тегло на храната, тъй като тя съдържа вода.
Трябва да се изчислят грамовете на мазнините, протеините и въглехидратите. Тяхната сума дава общото тегло на храната и от него трябва да извадим процентите вода.

От конзолата се прочитат 5 реда:
    •	Процент на мазнините - цяло число в интервала [0…100]
    •	Процент на протеините - цяло число в интервала [0…100]
    •	Процент на въглехидратите - цяло число в интервала [0…100]
    •	Общ брой калории - цяло число в интервала [1000…15000]
    •	Процент на съдържанието на вода - цяло число в интервала [0…100]

Пояснение: Когато правим подобни изчисления с проценти има голям шанс резултатът да не е цяло число!  */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int percentageFat = Integer.parseInt(scanner.nextLine());
        int percentageProtein = Integer.parseInt(scanner.nextLine());
        int percentageCarbs = Integer.parseInt(scanner.nextLine());
        int totalCalories = Integer.parseInt(scanner.nextLine());
        int percentageWater = Integer.parseInt(scanner.nextLine());


        double totalFats = (((double) percentageFat / 100) * totalCalories) / 9;
        double totalProteins = (((double) percentageProtein / 100) * totalCalories) / 4;
        double totalCarbs = (((double) percentageCarbs / 100) * totalCalories) / 4;
        double totalWeight = totalFats + totalProteins + totalCarbs;

        double caloriesPerGram = totalCalories / totalWeight;
        double calories = ((100 - (double) percentageWater) / 100) * caloriesPerGram;
        System.out.printf("%.4f", calories);
    }
}
