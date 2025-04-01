package D_OOP.X_ExamPreparations.ExamPrep_08.E01_VehicleShop.models.worker;

public class SecondShift extends BaseWorker {

    public static final int SECOND_SHIFT_WORKER_INITIAL_STRENGTH = 70;
    public static final int SECOND_SHIFT_WORKER_ADDITIONAL_STRENGTH_LOSS = 5;

    public SecondShift(String name) {
        super(name, SECOND_SHIFT_WORKER_INITIAL_STRENGTH);
    }

    @Override
    public void working() {
        int currentStrength = super.getStrength();
        int updatedStrength = currentStrength - (INITIAL_STRENGTH_LOSS + SECOND_SHIFT_WORKER_ADDITIONAL_STRENGTH_LOSS);
        if (updatedStrength < 0) {
            updatedStrength = 0;
        }
        super.setStrength(updatedStrength);
    }
}
