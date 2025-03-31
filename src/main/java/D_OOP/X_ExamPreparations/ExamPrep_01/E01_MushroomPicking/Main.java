package D_OOP.X_ExamPreparations.ExamPrep_01.E01_MushroomPicking;

import D_OOP.X_ExamPreparations.ExamPrep_01.E01_MushroomPicking.core.Controller;
import D_OOP.X_ExamPreparations.ExamPrep_01.E01_MushroomPicking.core.ControllerImpl;
import D_OOP.X_ExamPreparations.ExamPrep_01.E01_MushroomPicking.core.Engine;
import D_OOP.X_ExamPreparations.ExamPrep_01.E01_MushroomPicking.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}