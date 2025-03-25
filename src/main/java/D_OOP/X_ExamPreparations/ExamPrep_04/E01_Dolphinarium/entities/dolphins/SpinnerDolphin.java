package D_OOP.X_ExamPreparations.ExamPrep_04.E01_Dolphinarium.entities.dolphins;

public class SpinnerDolphin extends BaseDolphin {

    private static final int SPINNER_DOLPHIN_JUMP_ENERGY_CONSUMPTION = 40;

    public SpinnerDolphin(String name, int energy) {
        super(name, energy);
    }

    @Override
    public void jump() {
        int currentEnergy = super.getEnergy();
        super.setEnergy(currentEnergy - SPINNER_DOLPHIN_JUMP_ENERGY_CONSUMPTION - BASE_JUMP_ENERGY_CONSUMPTION);
    }
}
