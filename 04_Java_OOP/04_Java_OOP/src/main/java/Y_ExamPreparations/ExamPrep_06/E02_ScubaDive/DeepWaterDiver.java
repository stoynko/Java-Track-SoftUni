package Y_ExamPreparations.ExamPrep_06.E02_ScubaDive;

public class DeepWaterDiver {
    private final String name;
    private final double oxygen;

    public DeepWaterDiver(String name, double oxygen) {
        this.name = name;
        this.oxygen = oxygen;
    }

    public String getName() {
        return this.name;
    }

    public double getOxygen() {
        return this.oxygen;
    }
}
