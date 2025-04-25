package A_Java_ProgrammingBasics.F_NestedLoops;

public class L02_MultiplicationTable {

    public static void main(String[] args) {

        for (int x = 1; x <= 10; x++) {
            for (int y = 1; y <= 10; y++) {
                int result = x * y;
                System.out.printf("%d * %d = %d\n", x, y, result);
            }
        }
    }
}