package D_OOP.Y_ExamPreparations.ExamPrep_06.E01_HarpoonDiving.models.diving;

import D_OOP.Y_ExamPreparations.ExamPrep_06.E01_HarpoonDiving.models.diver.*;
import D_OOP.Y_ExamPreparations.ExamPrep_06.E01_HarpoonDiving.models.divingSite.*;

import java.util.*;

public class DivingImpl implements Diving {
    @Override

    public void searching(DivingSite divingSite, Collection<Diver> divers) {
        for (Diver diver : divers) {
            Iterator<String> seaCreature = divingSite.getSeaCreatures().iterator();
            while (diver.canDive() && seaCreature.hasNext()) {
                String creature = seaCreature.next();
                diver.shoot();
                diver.getSeaCatch().getSeaCreatures().add(creature);
                seaCreature.remove();
            }
        }
    }
}
