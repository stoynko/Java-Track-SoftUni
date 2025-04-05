package D_Java_OOP.Y_ExamPreparations.ExamPrep_08.E01_VehicleShop.models.worker;

public class FirstShift extends BaseWorker {

    public static final int FIRST_SHIFT_WORKER_INITIAL_STRENGTH = 100;

    public FirstShift(String name) {
        super(name, FIRST_SHIFT_WORKER_INITIAL_STRENGTH);
    }
}
