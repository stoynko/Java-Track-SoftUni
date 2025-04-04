package D_OOP.Y_ExamPreparations.ExamPrep_06.E01_HarpoonDiving.models.seaCatch;

import java.util.*;

public class BaseSeaCatch implements SeaCatch {

    private Collection<String> seaCreatures;

    public BaseSeaCatch() {
        this.seaCreatures = new ArrayList<>();
    }

    @Override
    public Collection<String> getSeaCreatures() {
        return this.seaCreatures;
    }
}
