package D_OOP.Y_ExamPreparations.ExamPrep_05.E01_Restaurant.core;
import D_OOP.Y_ExamPreparations.ExamPrep_05.E01_Restaurant.common.*;
import D_OOP.Y_ExamPreparations.ExamPrep_05.E01_Restaurant.models.client.*;
import D_OOP.Y_ExamPreparations.ExamPrep_05.E01_Restaurant.models.waiter.*;
import D_OOP.Y_ExamPreparations.ExamPrep_05.E01_Restaurant.models.working.*;
import D_OOP.Y_ExamPreparations.ExamPrep_05.E01_Restaurant.repositories.*;
import java.util.*;

/*The business logic of the program should be concentrated around several commands. You are given interfaces that you must implement in the correct classes.
Note: The ControllerImpl class SHOULD NOT handle exceptions! The tests are designed to expect exceptions, not messages!
The interface is Controller. You must create a ControllerImpl class, which implements the interface and implements all its methods.
The constructor of ControllerImpl does not take any arguments. It should be instantiated. The given methods should have the following logic:

Commands:
There are several commands, which control the business logic of the application. They are stated below.

    - AddWaiter Command
        Parameters:
            •	type – String
            •	waiterName – String
        Functionality:
            •	Creates a Waiter with the given name of the given type and saves it in the repository. If the type is invalid,
                throw an IllegalArgumentException with the following message: "Waiter type doesn't exist."
                Otherwise, the method should return the following message: "Added {type}: {waiterName}."
    - AddClient Command
        Parameters:
            •	clientName - String
            •	getClientOrders – String... (Varargs)
        Functionality:
            •	Create a client with the provided getClientOrders and name and save it in the repository.
                The method should return the following message: "Added Client: {clientName}."
    - RemoveWaiter Command
        Parameters:
            •	waiterName – String
        Functionality:
            •	Remove the Waiter from working by removing it from the repository. If a Waiter with that name doesn’t exist,
                throw IllegalArgumentException with the following message: "Waiter {waiterName} doesn't exist."
                If a Waiter is successfully removed, remove it from the repository and return the following message: "Waiter {waiterName} was removed!"
    - RemoveClient Command
        Parameters:
            •	clientName – String
        Functionality:
            •	Remove the Client by removing it from the repository. If a Client with that name doesn’t exist,
                throw IllegalArgumentException with the following message: " Client {clientName} doesn't exist."
                If a Client is successfully removed, remove it from the repository and return the following message:" Client {clientName} was removed!"
    - StartWorking Command
        Parameters:
            •	clientName - String
        Functionality:
            •	When the start working command is called, the waiter starts taking orders from the given client. If you don't have any Waiters,
                throw an IllegalArgumentException with the following message: "You must have at least one Waiter to start working."
                After finishing work, you must return the following message with the name of the served client: "Client {clientName} was served."
    - GetStatistics Command
        Functionality:
            •	Returns the information about the waiters in the following format:
                    If the waiters don't serve any clients, print "None" in their place.
                    "{total count of served clients} client/s was/were served.
                    Waiter's statistics:
                    Name: {waiterName}
                    Efficiency: {waiterEfficiency}
                    Taken orders: {order1, order2, order3, …, ordern}
                    …
                    Name: {waiterName}
                    Efficiency: {waiterEfficiency}
                    Taken orders: {order1, order2, order3, …, ordern}"

Input / Output:
You are provided with one interface, which will help you with the correct execution process of your program.
The interface is called Engine and its implementational class should read the input. When the program finishes, the class should print the output to the console.

Input:
These are the input commands:
    •	AddWaiter {waiterType} {waiterName}
    •	AddClient {clientName} {String... (getClientOrders)}
    •	RemoveWaiter {waiterName}
    •	StartWorking {clientName}
    •	GetStatistics
    •	Exit
Output:
    •	Print the output from each command when issued. If an exception is thrown during any of the commands' execution, print the exception message. */

public class ControllerImpl implements Controller {

    private ClientRepository clientsRepository;
    private WaiterRepository waitersRepository;
    private Working working;
    private int clientsServedCount = 0;

    public ControllerImpl() {
        this.clientsRepository = new ClientRepository();
        this.waitersRepository = new WaiterRepository();
        this.working = new WorkingImpl();
    }

    @Override
    public String addWaiter(String type, String waiterName) {

        Waiter waiter;
        switch (type) {
            case "FullTimeWaiter":
                waiter = new FullTimeWaiter(waiterName);
                break;
            case "HalfTimeWaiter":
                waiter = new HalfTimeWaiter(waiterName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.WAITER_INVALID_TYPE);
        }
        waitersRepository.add(waiter);
        return String.format(ConstantMessages.WAITER_ADDED, type, waiterName);
    }

    @Override
    public String addClient(String clientName, String... orders) {
        Client client = new ClientImpl(clientName);

        for (String order : orders) {
            client.getClientOrders().add(order);
        }

        clientsRepository.add(client);
        return String.format(ConstantMessages.CLIENT_ADDED, clientName);
    }

    @Override
    public String removeWaiter(String waiterName) {
        Waiter waiter = waitersRepository.byName(waiterName);
        if (waiter == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.WAITER_DOES_NOT_EXIST, waiterName));
        }
        waitersRepository.remove(waiter);
        return String.format(ConstantMessages.WAITER_REMOVE, waiterName);
    }

    @Override
    public String removeClient(String clientName) {

        Client client = clientsRepository.byName(clientName);
        if (client == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.CLIENT_DOES_NOT_EXIST, clientName));
        }

        clientsRepository.remove(client);
        return String.format(ConstantMessages.CLIENT_REMOVE, clientName);
    }

    @Override
    public String startWorking(String clientName) {

        Collection<Waiter> waitersList = waitersRepository.getCollection();

        if (waitersList.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.THERE_ARE_NO_WAITERS);
        }

        Client client = clientsRepository.byName(clientName);
        working.takingOrders(client, waitersList);
        clientsServedCount++;

        return String.format(ConstantMessages.ORDERS_SERVING, clientName);
    }

    @Override
    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("%d client/s was/were served.", clientsServedCount)).append(System.lineSeparator());
        output.append("Waiter's statistics:").append(System.lineSeparator());
        for (Waiter waiter : waitersRepository.getCollection()) {
            output.append(String.format("Name: %s", waiter.getName())).append(System.lineSeparator());
            output.append(String.format("Efficiency: %s", waiter.getEfficiency())).append(System.lineSeparator());
            Collection<String> waiterOrders = waiter.takenOrders().getOrdersList();
            if (waiterOrders.isEmpty()) {
                output.append("Taken orders: None");
            } else {
                String ordersOutput = String.join(", ", waiterOrders);
                output.append(String.format("Taken orders: %s", ordersOutput));
            }
            output.append(System.lineSeparator());
        }
        return output.toString();
    }
}
