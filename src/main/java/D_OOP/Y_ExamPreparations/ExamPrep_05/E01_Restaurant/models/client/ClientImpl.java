package D_OOP.Y_ExamPreparations.ExamPrep_05.E01_Restaurant.models.client;

/*The ClientImpl class holds information about the client orders that can be ordered. It should be instantiated.
Data:
    •	name – String
        o	If the value of the name is either null or empty (containing only whitespaces),
            throw a NullPointerException with the following message: "Invalid name!"
    •	clientOrders– a collection of Strings
Constructor:
The constructor should take the following values upon initialization:
    •	String name */

import D_OOP.Y_ExamPreparations.ExamPrep_05.E01_Restaurant.common.*;

import java.util.*;

public class ClientImpl implements Client {

    private String name;
    private List<String> clientOrders;

    public ClientImpl(String name) {
        setName(name);
        this.clientOrders = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new NullPointerException(ExceptionMessages.CLIENT_DOES_NOT_EXIST);
        }
        this.name = name;
    }

    @Override
    public Collection<String> getClientOrders() {
        return this.clientOrders;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
