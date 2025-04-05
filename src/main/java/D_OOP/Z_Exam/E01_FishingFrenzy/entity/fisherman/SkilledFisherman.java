package D_OOP.Z_Exam.E01_FishingFrenzy.entity.fisherman;

public class SkilledFisherman extends BaseFisherman {

    public static final int SKILLED_FISHERMAN_INITIAL_BAIT = 100;

    public SkilledFisherman(String name) {
        super(name, SKILLED_FISHERMAN_INITIAL_BAIT);
    }
}
