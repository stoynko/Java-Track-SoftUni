package D_OOP.X_ExamPreparations.ExamPrep_02.E01_Climbers.models.climbing;

import D_OOP.X_ExamPreparations.ExamPrep_02.E01_Climbers.models.climber.Climber;
import D_OOP.X_ExamPreparations.ExamPrep_02.E01_Climbers.models.mountain.Mountain;

import java.util.*;
import java.util.stream.*;

public class ClimbingImpl implements Climbing {

    public ClimbingImpl() {
    }

    @Override
    public void conqueringPeaks(Mountain mountain, Collection<Climber> climbers) {

/*  •	Climbers cannot climb peaks if their strength is equal to or below 0.
    •	They start climbing and conquering peaks, one by one.
    •	If they conquer a peak, they add it to their roster of conquered peaks and their strength is decreased.
    •	The conquered peak should then be removed from the peaks list of the current mountain.
    •	Climbers cannot continue climbing if their strength drops to 0.
        o	If their strength drops to 0, the next climber starts climbing. */

        Iterator<Climber> climberIterator = climbers.iterator();
        Collection<String> peaks = mountain.getPeaksList();

        while (climberIterator.hasNext()) {
            Climber climber = climberIterator.next();
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
