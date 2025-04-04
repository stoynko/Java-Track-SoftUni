package D_OOP.X_ExamPreparations.ExamPrep_10.E01_ChristmasStore.entities.delicacies;

public class Stolen extends BaseDelicacy {

    public static final double INITIAL_STOLEN_PORTION = 250.0;

    public Stolen(String name, double price) {
        super(name, INITIAL_STOLEN_PORTION, price);
    }
}
