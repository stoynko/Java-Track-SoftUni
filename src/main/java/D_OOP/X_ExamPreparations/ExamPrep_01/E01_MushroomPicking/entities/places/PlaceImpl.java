package D_OOP.X_ExamPreparations.ExamPrep_01.E01_MushroomPicking.entities.places;

import D_OOP.X_ExamPreparations.ExamPrep_01.E01_MushroomPicking.common.*;
import D_OOP.X_ExamPreparations.ExamPrep_01.E01_MushroomPicking.entities.pickers.*;

import java.util.*;

public class PlaceImpl implements Place {

    private String name;
    private Collection<String> mushrooms;
    private Collection<Picker> pickers;

    public PlaceImpl(String name) {
        setName(name);
        this.mushrooms = new ArrayList<>();
        this.pickers = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessages.PLACE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Collection<String> getMushrooms() {
        return this.mushrooms;
    }

    @Override
    public Collection<Picker> getPickers() {
        return this.pickers;
    }
}
