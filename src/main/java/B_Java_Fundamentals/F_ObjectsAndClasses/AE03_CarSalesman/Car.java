package B_Java_Fundamentals.F_ObjectsAndClasses.AE03_CarSalesman;

public class Car {

    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public Car(String model, Engine engine, String weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {

        StringBuilder output = new StringBuilder();

        output.append(this.model + ":").append(System.lineSeparator())
                .append("  ").append(this.engine.getModel() + ":").append(System.lineSeparator())
                .append("    ").append("Power: " + this.engine.getPower()).append(System.lineSeparator())
                .append("    ").append("Displacement: " + this.engine.getDisplacement()).append(System.lineSeparator())
                .append("    ").append("Efficiency: " + this.engine.getEfficiency()).append(System.lineSeparator())
                .append("  ").append("Weight: " + this.weight).append(System.lineSeparator())
                .append("  ").append("Color: " + this.color).append(System.lineSeparator());

        return output.toString();
    }
}
