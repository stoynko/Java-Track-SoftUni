package D_OOP.X_ExamPreparations.ExamPrep_01.E01_MushroomPicking.entities.action;

import D_OOP.X_ExamPreparations.ExamPrep_01.E01_MushroomPicking.entities.pickers.Picker;
import D_OOP.X_ExamPreparations.ExamPrep_01.E01_MushroomPicking.entities.places.Place;

import java.util.Iterator;

public class ActionImpl implements Action {

    public ActionImpl() {
    }

    @Override
    public void startPicking(Place place) {
        for (Picker picker : place.getPickers()) {
            Iterator<String> mushroomIterator = place.getMushrooms().iterator();
            while (picker.getVitality() > 0 && mushroomIterator.hasNext()) {
                String mushroom = mushroomIterator.next();
                picker.getBag().getMushrooms().add(mushroom);
                if (mushroom.startsWith("poisonous")) {
                    picker.getBag().getMushrooms().clear();
                }
                picker.pick();
                mushroomIterator.remove();
            }
        }
    }
}
