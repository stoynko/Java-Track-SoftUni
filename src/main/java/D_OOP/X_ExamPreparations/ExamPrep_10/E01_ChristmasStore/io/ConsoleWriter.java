package D_OOP.X_ExamPreparations.ExamPrep_10.E01_ChristmasStore.io;

import D_OOP.X_ExamPreparations.ExamPrep_10.E01_ChristmasStore.io.interfaces.*;

public class ConsoleWriter implements OutputWriter {
    public void writeLine(String text) {
        System.out.println(text);
    }
}
