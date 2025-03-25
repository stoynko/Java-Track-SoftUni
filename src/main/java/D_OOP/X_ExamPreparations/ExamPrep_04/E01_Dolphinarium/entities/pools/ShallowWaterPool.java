package D_OOP.X_ExamPreparations.ExamPrep_04.E01_Dolphinarium.entities.pools;

public class ShallowWaterPool extends BasePool {
    public static final int SHALLOW_WATER_POOL_CAPACITY = 2;

    public ShallowWaterPool(String name) {
        super(name, SHALLOW_WATER_POOL_CAPACITY);
    }
}
