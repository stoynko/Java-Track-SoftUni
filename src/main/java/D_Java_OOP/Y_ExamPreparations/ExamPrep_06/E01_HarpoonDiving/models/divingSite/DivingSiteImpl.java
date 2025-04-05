package D_Java_OOP.Y_ExamPreparations.ExamPrep_06.E01_HarpoonDiving.models.divingSite;

import D_Java_OOP.Y_ExamPreparations.ExamPrep_06.E01_HarpoonDiving.common.*;

import java.util.*;

public class DivingSiteImpl implements DivingSite {

    private String name;
    private Collection<String> seaCreatures;

    public DivingSiteImpl(String name) {
        this.name = name;
        this.seaCreatures = new ArrayList<>();
    }

    @Override
    public Collection<String> getSeaCreatures() {
        return this.seaCreatures;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new NullPointerException(ExceptionMessages.SITE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }
}
