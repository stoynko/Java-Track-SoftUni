package D_Java_OOP.Y_ExamPreparations.ExamPrep_04.E02_DolphinsPlay;

public class Dolphin {
    private String type;
    private String name;
    private int energy;



    public Dolphin(String type, String name, int energy) {
        this.type = type;
        this.name = name;
        this.energy = energy;
    }

    public String getName() {
        return name;
    }

    public int getEnergy() {
        return energy;
    }

    public String getType() {
        return type;
    }
}
