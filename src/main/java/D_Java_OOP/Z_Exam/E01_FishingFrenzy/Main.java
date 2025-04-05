package D_Java_OOP.Z_Exam.E01_FishingFrenzy;

import D_Java_OOP.Z_Exam.E01_FishingFrenzy.core.Controller;
import D_Java_OOP.Z_Exam.E01_FishingFrenzy.core.ControllerImpl;
import D_Java_OOP.Z_Exam.E01_FishingFrenzy.core.Engine;
import D_Java_OOP.Z_Exam.E01_FishingFrenzy.core.EngineImpl;

public class Main {

    public static void main(String[] args) {

        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}