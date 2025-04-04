package D_OOP.Y_ExamPreparations.ExamPrep_01.E01_MushroomPicking.core;

import D_OOP.Y_ExamPreparations.ExamPrep_01.E01_MushroomPicking.common.*;
import D_OOP.Y_ExamPreparations.ExamPrep_01.E01_MushroomPicking.entities.action.*;
import D_OOP.Y_ExamPreparations.ExamPrep_01.E01_MushroomPicking.entities.pickers.*;
import D_OOP.Y_ExamPreparations.ExamPrep_01.E01_MushroomPicking.entities.places.*;
import D_OOP.Y_ExamPreparations.ExamPrep_01.E01_MushroomPicking.repositories.*;

public class ControllerImpl implements Controller {

    private Repository<Place> placeRepository;
    private Action action;

    public ControllerImpl() {
        this.placeRepository = new PlaceRepository();
        this.action = new ActionImpl();
    }

    @Override
    public String addPlace(String placeName, String... mushrooms) {

        Place place = new PlaceImpl(placeName);
        for (String mushroom : mushrooms) {
            place.getMushrooms().add(mushroom);
        }
        this.placeRepository.add(place);

        return String.format(ConstantMessages.PLACE_ADDED, placeName);
    }

    @Override
    public String addPicker(String placeName, String pickerType, String pickerName) {
        Place place = this.placeRepository.byName(placeName);
        boolean pickerExists = place.getPickers().stream().anyMatch(picker -> picker.getName().equals(pickerName));
        if (pickerExists) {
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_PICKER);
        }
        Picker picker;
        switch (pickerType) {
            case "JuniorPicker":
                picker = new JuniorPicker(pickerName);
                break;
            case "ExperiencedPicker":
                picker = new ExperiencedPicker(pickerName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_PICKER);
        }
        place.getPickers().add(picker);
        return String.format(String.format(ConstantMessages.PICKER_ADDED, pickerType, pickerName));
    }

    @Override
    public String startPicking(String placeName) {
        Place place = this.placeRepository.byName(placeName);
        if (place == null) {
            throw new NullPointerException(String.format(ExceptionMessages.NON_EXISTING_PLACE, placeName));
        }
        action.startPicking(place);
        return String.format(ConstantMessages.PLACE_VISITED, placeName);
    }

    @Override
    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        for (Place place : this.placeRepository.getCollection()) {
            output.append(String.format("Pickers in the %s:", place.getName())).append(System.lineSeparator());;
            for (Picker picker : place.getPickers()) {
                output.append(String.format("Name: %s", picker.getName())).append(System.lineSeparator());
                output.append(String.format("Vitality: %d", picker.getVitality())).append(System.lineSeparator());
                output.append("Bag mushrooms: ");
                if (picker.getBag().getMushrooms().isEmpty()) {
                    output.append("none");
                } else {
                    String collectedMushrooms = String.join(", ", picker.getBag().getMushrooms());
                    output.append(collectedMushrooms);
                }
                output.append(System.lineSeparator());
            }
        }
        return output.toString().trim();
    }
}
