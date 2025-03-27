package D_OOP.X_ExamPreparations.ExamPrep_02.E01_Climbers.models.climbing;

import D_OOP.X_ExamPreparations.ExamPrep_02.E01_Climbers.models.climber.*;
import D_OOP.X_ExamPreparations.ExamPrep_02.E01_Climbers.models.mountain.*;

import java.util.*;

public class ClimbingImpl implements Climbing {

    @Override
    public void conqueringPeaks(Mountain mountain, Collection<Climber> climbers) {
        Collection<String> peaks = mountain.getPeaksList();

        for (Climber climber : climbers) {
            Iterator<String> peaksIterator = peaks.iterator();
            while (climber.canClimb() && peaksIterator.hasNext()) {
                String peak = peaksIterator.next();
                climber.climb();
                climber.getRoster().getPeaks().add(peak);
                peaksIterator.remove();
            }
        }
    }
}
