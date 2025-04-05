package D_Java_OOP.Y_ExamPreparations.ExamPrep_02.E01_Climbers.models.climber;

public class WallClimber extends BaseClimber {

    public static final double WALL_CLIMBER_INITIAL_STRENGTH = 90;

    public WallClimber(String name) {
        super(name, WALL_CLIMBER_INITIAL_STRENGTH);
    }
}
