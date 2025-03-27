package D_OOP.X_ExamPreparations.ExamPrep_02.E01_Climbers.models.climbing;

import D_OOP.X_ExamPreparations.ExamPrep_02.E01_Climbers.models.climber.*;
import D_OOP.X_ExamPreparations.ExamPrep_02.E01_Climbers.models.mountain.*;

import java.util.Collection;

public interface Climbing {
    void conqueringPeaks(Mountain mountain, Collection<Climber> climbers);
}
