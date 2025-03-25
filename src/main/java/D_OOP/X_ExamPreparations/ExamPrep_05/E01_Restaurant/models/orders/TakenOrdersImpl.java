package D_OOP.X_ExamPreparations.ExamPrep_05.E01_Restaurant.models.orders;

import java.util.*;
/*The TakenOrdersImpl class holds a collection of orders. It should be instantiated.
Data:
    •	ordersList – a collection of Strings */

public class TakenOrdersImpl implements TakenOrders {

    private List<String> ordersList;

    public TakenOrdersImpl() {
        this.ordersList = new ArrayList<>();
    }

    @Override
    public Collection<String> getOrdersList() {
        return this.ordersList;
    }
}
