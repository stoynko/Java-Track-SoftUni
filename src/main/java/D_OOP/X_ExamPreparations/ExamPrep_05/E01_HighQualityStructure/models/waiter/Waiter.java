package D_OOP.X_ExamPreparations.ExamPrep_05.E01_HighQualityStructure.models.waiter;

import D_OOP.X_ExamPreparations.ExamPrep_05.E01_HighQualityStructure.models.orders.*;

public interface Waiter {

    String getName();

    int getEfficiency();

    boolean canWork();

    TakenOrders takenOrders();

    void work();
}
