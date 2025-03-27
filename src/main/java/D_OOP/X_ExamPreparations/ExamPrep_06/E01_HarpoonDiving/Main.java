package D_OOP.X_ExamPreparations.ExamPrep_06.E01_HarpoonDiving;

import D_OOP.X_ExamPreparations.ExamPrep_06.E01_HarpoonDiving.core.*;

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
