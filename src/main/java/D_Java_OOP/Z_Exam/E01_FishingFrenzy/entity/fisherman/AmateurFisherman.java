package D_Java_OOP.Z_Exam.E01_FishingFrenzy.entity.fisherman;

public class AmateurFisherman extends BaseFisherman {

    public static final int AMATEUR_FISHERMAN_INITIAL_BAIT = 50;

    public AmateurFisherman(String name) {
        super(name, AMATEUR_FISHERMAN_INITIAL_BAIT);
    }
}
