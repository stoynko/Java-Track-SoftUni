package D_Java_OOP.Y_ExamPreparations.ExamPrep_01.E01_MushroomPicking.entities.places;

import D_Java_OOP.Y_ExamPreparations.ExamPrep_01.E01_MushroomPicking.common.ExceptionMessages;
import D_Java_OOP.Y_ExamPreparations.ExamPrep_01.E01_MushroomPicking.entities.pickers.Picker;

import java.util.ArrayList;
import java.util.Collection;

public class PlaceImpl implements Place {

    private String name;
    private Collection<String> mushrooms;
    private Collection<Picker> pickers;

    public PlaceImpl(String name) {
        this.name = name;
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
