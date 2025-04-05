package D_Java_OOP.Y_ExamPreparations.ExamPrep_04.E01_Dolphinarium.entities.dolphins;

public class BottleNoseDolphin extends BaseDolphin {

    private static final int BOTTLE_NOSE_DOLPHIN_JUMP_ENERGY_CONSUMPTION = 190;

    public BottleNoseDolphin(String name, int energy) {
        super(name, energy);
    }

    @Override
    public void jump() {
        int currentEnergy = super.getEnergy();
        super.setEnergy(currentEnergy - BOTTLE_NOSE_DOLPHIN_JUMP_ENERGY_CONSUMPTION - BASE_JUMP_ENERGY_CONSUMPTION);
    }
}
