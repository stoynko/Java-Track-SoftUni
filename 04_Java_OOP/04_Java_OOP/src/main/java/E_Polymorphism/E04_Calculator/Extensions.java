package E_Polymorphism.E04_Calculator;

public class Extensions {

    public static InputInterpreter buildInterpreter(CalculationEngine engine) {
        return new InputInterpreter(engine);
    }
}
