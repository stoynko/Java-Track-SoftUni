package D_OOP.X_ExamPreparations.ExamPrep_05.E01_HighQualityStructureAndBusinessLogic.models.waiter;
import D_OOP.X_ExamPreparations.ExamPrep_05.E01_HighQualityStructureAndBusinessLogic.common.*;
import D_OOP.X_ExamPreparations.ExamPrep_05.E01_HighQualityStructureAndBusinessLogic.models.orders.*;

/*Waiter:
BaseWaiter is a base class for any type of waiter and should not be instantiated.
    •	name – String
        o	If the value of the name is either null or empty (containing only whitespaces),
            throw a NullPointerException with the following message: "Waiter name cannot be null or empty."
        o	The values of the names are unique.
    •	efficiency – int
        o	The efficiency of a waiter.
        o	If the efficiency is a negative number, throw an IllegalArgumentException with the following message:
            "Cannot create Waiter with negative efficiency."
    •	takenOrders – TakenOrders
        o	A TakenOrders field type. */

public abstract class BaseWaiter implements Waiter {

    private String name;
    private int efficiency;
    private TakenOrders takenOrders;

    public BaseWaiter(String name, int efficiency) {
        setName(name);
        setEfficiency(efficiency);
        this.takenOrders = new TakenOrdersImpl();
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new NumberFormatException(ExceptionMessages.WAITER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setEfficiency(int efficiency) {
        if (efficiency < 0) {
            throw new IllegalArgumentException(ExceptionMessages.WAITER_EFFICIENCY_LESS_THAN_ZERO);
        }
        this.efficiency = efficiency;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getEfficiency() {
        return this.efficiency;
    }

    @Override
    public boolean canWork() {
        return this.efficiency > 0;
    }

    @Override
    public TakenOrders takenOrders() {
        return this.takenOrders;
    }

    @Override
    public abstract void work();
}
