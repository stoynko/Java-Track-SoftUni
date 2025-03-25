package D_OOP.X_ExamPreparations.ExamPrep_05.E01_Restaurant;
import D_OOP.X_ExamPreparations.ExamPrep_05.E01_Restaurant.core.*;

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
