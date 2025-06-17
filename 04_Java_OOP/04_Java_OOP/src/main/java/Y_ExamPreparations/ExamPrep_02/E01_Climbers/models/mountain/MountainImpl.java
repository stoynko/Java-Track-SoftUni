package Y_ExamPreparations.ExamPrep_02.E01_Climbers.models.mountain;

import Y_ExamPreparations.ExamPrep_02.E01_Climbers.common.ExceptionMessages;

import java.util.ArrayList;
import java.util.Collection;

public class MountainImpl implements Mountain {

    private String name;
    private Collection<String> peaksList;

    public MountainImpl(String name) {
        setName(name);
        this.peaksList = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Collection<String> getPeaksList() {
        return this.peaksList;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new NullPointerException(ExceptionMessages.MOUNTAIN_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }
}
