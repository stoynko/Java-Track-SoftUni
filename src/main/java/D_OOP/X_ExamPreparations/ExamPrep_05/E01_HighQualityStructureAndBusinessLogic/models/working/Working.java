package D_OOP.X_ExamPreparations.ExamPrep_05.E01_HighQualityStructureAndBusinessLogic.models.working;
import D_OOP.X_ExamPreparations.ExamPrep_05.E01_HighQualityStructureAndBusinessLogic.models.client.*;
import D_OOP.X_ExamPreparations.ExamPrep_05.E01_HighQualityStructureAndBusinessLogic.models.waiter.*;

import java.util.*;

public interface Working {

    void takingOrders(Client client, Collection<Waiter> waiters);

}
