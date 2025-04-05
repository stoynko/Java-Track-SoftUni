package D_Java_OOP.Y_ExamPreparations.ExamPrep_04.E01_Dolphinarium.entities.dolphins;

public class SpottedDolphin extends BaseDolphin {

    private static final int SPOTTED_DOLPHIN_JUMP_ENERGY_CONSUMPTION = 90;

    public SpottedDolphin(String name, int energy) {
        super(name, energy);
    }

    @Override
    public void jump() {
        int currentEnergy = super.getEnergy();
        super.setEnergy(currentEnergy - SPOTTED_DOLPHIN_JUMP_ENERGY_CONSUMPTION - BASE_JUMP_ENERGY_CONSUMPTION);
    }
}
