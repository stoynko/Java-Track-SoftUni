package D_OOP.X_ExamPreparations.ExamPrep_05.E01_HighQualityStructureAndBusinessLogic.models.client;

import java.util.Collection;

public interface Client {

    Collection<String> getClientOrders();

    String getName();
}
