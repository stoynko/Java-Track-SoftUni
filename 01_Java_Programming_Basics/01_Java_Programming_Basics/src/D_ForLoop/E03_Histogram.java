package D_ForLoop;

import java.util.*;

public class E03_Histogram {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int p4 = 0;
        int p5 = 0;

        for (int i = 1; i <= n; i++) {
            int input = Integer.parseInt(scanner.nextLine());
            if (input < 200) {
                p1++;
            } else if (input >= 200 && input <= 399) {
                p2++;
            } else if (input >= 400 && input <= 599) {
                p3++;
            } else if (input >= 600 && input <= 799) {
                p4++;
            } else if (input >= 800 && input <= 1000) {
                p5++;
            }
        }
        double p1result = (double) p1 / n * 100;
        double p2result = (double) p2 / n * 100;
        double p3result = (double) p3 / n * 100;
        double p4result = (double) p4 / n * 100;
        double p5result = (double) p5 / n * 100;

        System.out.printf("%.2f%%\n", p1result);
        System.out.printf("%.2f%%\n", p2result);
        System.out.printf("%.2f%%\n", p3result);
        System.out.printf("%.2f%%\n", p4result);
        System.out.printf("%.2f%%\n", p5result);
    }
}
