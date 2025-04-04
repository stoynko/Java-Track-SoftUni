package D_OOP.Y_ExamPreparations.ExamPrep_05.E01_Restaurant.models.waiter;
import D_OOP.Y_ExamPreparations.ExamPrep_05.E01_Restaurant.models.orders.*;

public interface Waiter {

    String getName();

    int getEfficiency();

    boolean canWork();

    TakenOrders takenOrders();

    void work();
}
