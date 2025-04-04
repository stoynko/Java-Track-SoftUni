package D_OOP.X_ExamPreparations.ExamPrep_10.E01_ChristmasStore.io;

import D_OOP.X_ExamPreparations.ExamPrep_10.E01_ChristmasStore.io.interfaces.*;

import java.io.*;

public class ConsoleReader  implements InputReader {
    private BufferedReader reader;

    public ConsoleReader() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readLine() throws IOException {
        return this.reader.readLine();
    }
}
