package D_OOP.X_ExamPreparations.ExamPrep_02.E01_Climbers;

import D_OOP.X_ExamPreparations.ExamPrep_02.E01_Climbers.core.*;

public class Main {

    public static void main(String[] args) {

        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
