package D_OOP.Y_ExamPreparations.ExamPrep_05.E01_Restaurant.models.working;
import D_OOP.Y_ExamPreparations.ExamPrep_05.E01_Restaurant.models.client.*;
import D_OOP.Y_ExamPreparations.ExamPrep_05.E01_Restaurant.models.waiter.*;
import java.util.*;

/*The WorkingImpl class holds the main action, which is the takingOrders method.
Behaviour:
Here is how the takingOrders method works:
    •	Waiters cannot serve clients if their efficiency is equal to or below 0.
    •	They start working by taking orders from clients, one by one.
    •	If they take an order, they add it to their getOrders list and their efficiency is decreased.
    •	The taken order should then be removed from the getClientOrders list of the current client.
    •	Waiters cannot continue working if their efficiency drops to 0.
        o	If their efficiency drops to 0 they get tired and cannot take any more orders,
            and the next waiter starts working. */
public class WorkingImpl implements Working {

    @Override
    public void takingOrders(Client client, Collection<Waiter> waiters) {
        Collection<String> clientOrders = client.getClientOrders();
        for (Waiter waiter : waiters) {
            while (waiter.canWork() && clientOrders.iterator().hasNext()) {
                String currentOrder = clientOrders.iterator().next();
                waiter.takenOrders().getOrdersList().add(currentOrder);
                clientOrders.remove(currentOrder);
                waiter.work();
            }
        }
    }
}
