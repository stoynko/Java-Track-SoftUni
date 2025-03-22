package D_OOP.X_ExamPreparations.ExamPrep_05.E01_HighQualityStructure.models.working;

import D_OOP.X_ExamPreparations.ExamPrep_05.E01_HighQualityStructure.models.client.*;
import D_OOP.X_ExamPreparations.ExamPrep_05.E01_HighQualityStructure.models.waiter.*;

import java.util.Collection;

public interface Working {

    void takingOrders(Client client, Collection<Waiter> waiters);

}
