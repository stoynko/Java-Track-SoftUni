package D_ForLoop;

public class E01_Numbers_Ending_In_7 {

    public static void main(String[] args) {

        for (int i = 7; i < 1000; i++) {
            if (i % 10 == 7) {
                System.out.println(i);
            }
        }
    }
}