package Y_ExamPreparations.ExamPrep_05.E01_Restaurant.models.working;
import D_Java_OOP.Y_ExamPreparations.ExamPrep_05.E01_Restaurant.models.client.*;
import D_Java_OOP.Y_ExamPreparations.ExamPrep_05.E01_Restaurant.models.waiter.*;

import java.util.*;

public interface Working {

    void takingOrders(Client client, Collection<Waiter> waiters);

}
