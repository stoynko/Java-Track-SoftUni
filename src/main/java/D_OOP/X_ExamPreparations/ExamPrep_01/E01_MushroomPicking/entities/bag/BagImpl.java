package D_OOP.X_ExamPreparations.ExamPrep_01.E01_MushroomPicking.entities.bag;

import java.util.*;

public class BagImpl implements Bag {

    Collection<String> mushrooms;

    public BagImpl() {
        this.mushrooms = new ArrayList<>();
    }

    @Override
    public Collection<String> getMushrooms() {
        return this.mushrooms;
    }
}
