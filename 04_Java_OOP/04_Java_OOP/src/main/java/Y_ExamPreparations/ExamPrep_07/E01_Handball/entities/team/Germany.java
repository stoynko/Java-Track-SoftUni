package Y_ExamPreparations.ExamPrep_07.E01_Handball.entities.team;

public class Germany extends BaseTeam {

    public static final int INDOOR_ADVANTAGE = 145;

    public Germany(String name, String country, int advantage) {
        super(name, country, advantage);
    }

    @Override
    public void play() {
        int currentAdvantage = super.getAdvantage();
        super.setAdvantage(currentAdvantage + INDOOR_ADVANTAGE);
    }
}
