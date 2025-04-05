package C_Java_Advanced.Y_ExamPreparation.ExamPrep_02;

import java.util.*;

public class E01_ClimbThePeaks {

/*Alex is a vlogger and he wants to make videos, climbing the five highest peaks in Pirin mountain in just one week. He will take his video set, a tent and his backpack to
the mountain. The backpack fits food portions for one week, exactly. His daily stamina is also limited.  Your task is to trace his adventure and to create a post for his profile
@alexaroundtheworld, at the end of the journey.You will have to keep information for all the conquered peaks, if any.
Every day, Alex will use one portion of his daily food supplies and will exhaust one of his daily stamina. First, you will be given a sequence of numbers,
representing the quantities of the daily portions of food supplies in his backpack. Afterward, you will be given another sequence of numbers,
representing the quantities of the daily stamina he will have at his disposal for the next seven days. You have to sum the quantity of the last daily food portion with the
quantity of the first daily stamina. He will start climbing from the first peak in the table below to the last one.
    •	If the sum is equal or greater than the corresponding Mountain Peak’s Difficulty level from the table below, it means that the peak is conquered. In this case, you should remove both quantities from the sequences and continue with the next ones towards the next peak.
    •	If the sum is less than the corresponding Mountain Peak’s Difficulty level from the table below, the peak remains unconquered. You should remove both quantities from the sequences. Alex will have to sleep in his tent. On the next day he will try the same peak once again.

      Mountain Peaks            Difficulty level
        Vihren	                       80
        Kutelo	                       90
        Banski Suhodol	               100
        Polezhan	                   60
        Kamenitza	                   70

Alex will try to conquer as much peaks as he can in seven days. If he manages to climb all the peaks earlier (before the seventh day),
the adventure is over and the output is printed on the Console. Finally, print on the Console all the conquered peaks(in the order of climbing).

Input:
    •	On the first line, you will receive the food portions quantities, separated by a comma and a single space (", ").
    •	On the second line, you will receive the stamina quantities, separated by a comma and a single space (", ").
Output:
    •	On the first line – print whether Alex managed to reach his goal and climb all the peaks in his list:
        o	If he managed to conquer all: "Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK"
        o	If he didn't manage to climb all of the peaks: "Alex failed! He has to organize his journey better next time -> @PIRINWINS"
    •	Then, in either case, if Alex fails or succeeds in completing the climbing adventure, you should print all conquered peaks (in the order of climbing), if there are any:
        Conquered peaks:
        {peak1}
        {peak2}
        …
        {peakn}
            o	If there are no conquered peaks do not print this message.
Constraints:
    •	All of the given numbers will be valid integers in the range [0…100]. */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> foodPortionsStack = new ArrayDeque<>();
        ArrayDeque<Integer> dailyStaminaQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(foodPortionsStack::push);
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(dailyStaminaQueue::offer);
        List<String> mountainPeeks = new ArrayList<>(List.of("Vihren", "Kutelo", "Banski Suhodol", "Polezhan", "Kamenitza"));
        List<String> conqueredPeeks = new ArrayList<>();
        List<Integer> mountainDifficulty = new ArrayList<>(List.of(80, 90, 100, 60, 70));
        int day = 0;
        boolean conqueredAll = false;

        while (day <= 7 && !conqueredAll && !foodPortionsStack.isEmpty() && !dailyStaminaQueue.isEmpty()) {
            day += 1;

            int foodQuantity = foodPortionsStack.pop();
            int dailyStamina = dailyStaminaQueue.poll();
            int sum = foodQuantity + dailyStamina;

            if (!mountainPeeks.isEmpty()) {
                while (sum >= mountainDifficulty.get(0)) {
                    sum -= mountainDifficulty.get(0);
                    conqueredPeeks.add(mountainPeeks.get(0));
                    mountainPeeks.remove(mountainPeeks.get(0));
                    mountainDifficulty.remove(0);
                    if (mountainPeeks.isEmpty()) {
                        conqueredAll = true;
                        break;
                    }
                }
            }

        }

        System.out.println(conqueredPeeks.size() == 5 ?
                "Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK" :
                "Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        if (!conqueredPeeks.isEmpty()) {
            System.out.println("Conquered peaks:");
            conqueredPeeks.forEach(System.out::println);
        }
    }
}
