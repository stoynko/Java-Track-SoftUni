package D_OOP.X_ExamPreparations.ExamPrep_05.E01_Restaurant.models.working;
import D_OOP.X_ExamPreparations.ExamPrep_05.E01_Restaurant.models.client.*;
import D_OOP.X_ExamPreparations.ExamPrep_05.E01_Restaurant.models.waiter.*;

import java.util.*;

public interface Working {

    void takingOrders(Client client, Collection<Waiter> waiters);

}
