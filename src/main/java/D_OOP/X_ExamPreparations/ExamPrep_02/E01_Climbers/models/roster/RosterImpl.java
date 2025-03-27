package D_OOP.X_ExamPreparations.ExamPrep_02.E01_Climbers.models.roster;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RosterImpl implements Roster {

    private List<String> peaks;

    public RosterImpl() {
        this.peaks = new ArrayList<>();
    }

    @Override
    public Collection<String> getPeaks() {
        return this.peaks;
    }
}
