package D_OOP.Y_ExamPreparations.ExamPrep_07.E01_Handball.entities.team;

public class Bulgaria extends BaseTeam {

    public static final int OUTDOOR_ADVANTAGE = 115;

    public Bulgaria(String name, String country, int advantage) {
        super(name, country, advantage);
    }

    @Override
    public void play() {
        int currentAdvantage = super.getAdvantage();
        super.setAdvantage(currentAdvantage + OUTDOOR_ADVANTAGE);
    }
}
