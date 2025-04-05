package D_Java_OOP.Y_ExamPreparations.ExamPrep_01.E02_MushroomKingdom;

public class Mushroom {

    private final String name;
    private final String flavor;
    private final boolean edible;
    private final int toxicity;

    public Mushroom(String name, String flavor, boolean edible, int toxicity) {
        this.name = name;
        this.flavor = flavor;
        this.edible = edible;
        this.toxicity = toxicity;
    }

    public String getName() {
        return name;
    }

    public String getFlavor() {
        return flavor;
    }

    public boolean isEdible() {
        return edible;
    }

    public int getToxicity() {
        return toxicity;
    }
}
