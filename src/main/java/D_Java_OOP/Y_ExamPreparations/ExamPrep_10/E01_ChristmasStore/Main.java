package D_Java_OOP.Y_ExamPreparations.ExamPrep_10.E01_ChristmasStore;

import D_Java_OOP.Y_ExamPreparations.ExamPrep_10.E01_ChristmasStore.core.*;
import D_Java_OOP.Y_ExamPreparations.ExamPrep_10.E01_ChristmasStore.core.interfaces.*;
import D_Java_OOP.Y_ExamPreparations.ExamPrep_10.E01_ChristmasStore.entities.booths.interfaces.*;
import D_Java_OOP.Y_ExamPreparations.ExamPrep_10.E01_ChristmasStore.entities.cocktails.interfaces.*;
import D_Java_OOP.Y_ExamPreparations.ExamPrep_10.E01_ChristmasStore.entities.delicacies.interfaces.*;
import D_Java_OOP.Y_ExamPreparations.ExamPrep_10.E01_ChristmasStore.io.*;
import D_Java_OOP.Y_ExamPreparations.ExamPrep_10.E01_ChristmasStore.repositories.*;
import D_Java_OOP.Y_ExamPreparations.ExamPrep_10.E01_ChristmasStore.repositories.interfaces.*;

public class Main {

/*You are given 8 interfaces, and you must implement their functionality in the correct classes.
It is not required to implement your structure with Engine, ConsoleReader, ConsoleWriter, and enc. It's good practice but it's not required.
There are 3 types of entities and 3 repositories in the application: Booth, Delicacy, Cocktail, and a Repository for each of them:

Delicacy: BaseDelicacy is a base class for any type of Delicacy, and it should not be able to be instantiated.
Data:
    • name – String
        o If the name is null or whitespace, throw an IllegalArgumentException with the message "Name cannot be null or white space!"
    • portion – double
        o If the portion is less or equal to 0, throw an IllegalArgumentException with the message "Portion cannot be less or equal to zero!"
    • price – double
        o If the price is less or equal to 0, throw an IllegalArgumentException with the message "Price cannot be less or equal to zero!"
Behavior:
    • String toString(). Returns a String with information about each delicacy. The returned String must be in the following format:
        o "{current delicacy name}: {current portion - formatted to the second digit}g - {current price - formatted to the second digit}"
Constructor:
    • A BaseDelicacy should take the following values upon initialization: String name, double portion, double price

Child Classes: There are several concrete types of Delicacy:
    • Gingerbread:
        o The Gingerbread has a constant value for InitialGingerbreadPortion – 200.
    • Stolen
        o The Stolen has a constant value for InitialStolenPortion – 250.

Cocktail:
BaseCocktail is a base class for any type of Cocktail and it should not be able to be instantiated.
Data
    • name – String
        o If the name is null or whitespace, throw an IllegalArgumentException with the message "Name cannot be null or white space!"
    • size – int
        o If the size is less or equal to 0, throw an IllegalArgumentException with the message "Size cannot be less or equal to zero!"
    • price – double
        o If the price is less or equal to 0, throw an IllegalArgumentException with the message "Price cannot be less or equal to zero!"
    • brand – String
        o If the name is null or whitespace, throw an IllegalArgumentException with the message "Brand cannot be null or white space!"
Behavior:
    • String toString(). Returns a String with information about each cocktail. The returned String must be in the following format:
        o "{current cocktail name} {current brand name} - {current size}ml - {current price - formatted to the second digit}lv"
Constructor:
    • A BaseCocktail should take the following values upon initialization: String name, int size, double price, String brand

Child Classes: There are several concrete types of Cocktail:
    • MulledWine
        o The MulledWine has а constant value for mulledWinePrice – 3.50.
    • Hibernation
        o The Hibernation has а constant value for hibernationPrice – 4.50.

Booth: BaseBooth is a base class for different types of booths and should not be able to be instantiated.
Data:
    • delicacyOrders – Collection<Delicacy>
    • cocktailOrders – Collection<Cocktail>
    • boothNumber – int the booth number
    • capacity – int the booth capacity.
        o It can’t be less than zero. In these cases, throw an IllegalArgumentException with the message "Capacity has to be greater than 0!"
    • numberOfPeople – int the count of people who want a booth.
        o Cannot be less or equal to 0. In these cases, throw an IllegalArgumentException with message "Cannot place zero or less people!"
    • pricePerPerson – double the price per person for the booth.
    • isReserved – boolean returns true if the booth is reserved, otherwise false.
    • price – double calculates the price for all people.

Behavior:
    • void reserve(int numberOfPeople).
            o Reserve the booth with the count of people given and calculate the price of the booth.
    • double getBill()
        o Returns the bill for the booth, all of the ordered cocktails and delicacies.
    • void clear()
        o Removes all the ordered cocktails and delicacies and finally frees the booth, sets the count of people and price to 0.

Constructor:
    • A BaseBooth should take the following values upon initialization: int boothNumber, int capacity, double pricePerPerson

Child Classes: There are several concrete types of Booth:
    • OpenBooth
        o The OpenBooth has a constant value for pricePerPerson – 2.50.
    • PrivateBooth
        o The PrivateBooth has a constant value for pricePerPerson – 3.50.

Repository: The repository holds information about the entity.
Data:
    • models - A collection of T (entity)

Behavior:
    • void add(T model)
        o Adds an entity in the collection.
    • Collection<T> getAll()
        o Returns all entities (unmodifiable)

Child Repositories:
    • BoothRepository
        o T getByNumber(int boothNumber)
        o Returns an entity with that name.
    • DelicacyRepository
        o T getByName(String name)
        o Returns an entity with that name.
    • CocktailRepository
        o T getByName(String name)
        o Returns an entity with that name.

Child Classes: Create DelicacyRepositoryImpl, CocktailRepositoryImpl and BoothRepositoryImpl repositories.

The Controller Class:
The business logic of the program should be concentrated around several commands. You are given interfaces that you must implement in the correct classes.
Note: The ControllerImpl class SHOULD NOT handle exceptions! The tests are designed to expect exceptions, not messages! The first interface is Controller.
You must create a ControllerImpl class, which implements the interface and implements all its methods. The given methods should have the following logic:

Commands: There are several commands which control the business logic of the application. They are stated below.
The Field name passed to the methods will always be valid!

    • AddDelicacy Command (type – String, name –  String, price – double)
        o Creates a delicacy with the correct type. If the delicacy is created successfully, returns: "Added delicacy {delicacy name} - {delicacy type} to the pastry shop!"
        o If a delicacy with the given name already exists in the delicacy repository, throw an IllegalArgumentException with the message:
            "{type} {name} is already in the pastry shop!"

    • AddCocktail Command (type – String, name –  String, portion – int, brand – String)
        o Creates a cocktail with the correct type. If the cocktail is created successful, returns: "Added cocktail {cocktailName} - {cocktailBrand} to the pastry shop!”
        o If a cocktail with the given name already exists in the cocktail repository, throw an IllegalArgumentException with the message:
            "{type} {name} is already in the pastry shop!"

    • AddBooth Command (type – String, boothNumer – int, capacity – int)
        o Creates a booth with the correct type and returns: "Added booth number {boothNumber} in the pastry shop!"
        o If a booth with the given name already exists in the booth repository, throw an IllegalArgumentException with the message:
            "Booth {boothNumber} is already added to the pastry shop!"

    • ReserveBooth Command (numberOfPeople – int)
        o Finds a booth that is not reserved, and its capacity is enough for the number of people provided. If there is no such booth returns: "No available booth for {numberOfPeople} people!"
        o In the other case reserves the booth and return: "Booth {boothNumber} has been reserved for {numberOfPeople} people!"

    • LeaveBooth Command (boothNumber – int)
        o Finds the booth with the same booth number. Gets the bill for that booth, clears it and adds the sum to the total store income. The bill is not only the orders,
            but the reservation for the number of people as well. Finally returns:
            "Booth: {boothNumber}"
            "Bill: {booth bill:f2}"

    • GetIncome Command
        o Returns the total income for the pastry shop for all completed bills: "Income: {income:f2}lv"

Input / Output: You are provided with one interface, which will help with the correct execution process of your program.
The interface is Engine and the class implementing this interface should read the input and when the program finishes, this class should print the output.

Input: Below, you can see the format in which each command will be given in the input:
    • AddDelicacy {type} {name} {price}
    • AddCocktail {type} {name} {size} {brand}
    • AddBooth {type} {boothNumber} {capacity}
    • ReserveBooth {numberOfPeople}
    • LeaveBooth {boothNumber}
    • GetIncome
    • END

Output: Print the output from each command when issued. If an exception is thrown during any of the commands' execution, print the exception message. */

    public static void main(String[] args) {
        DelicacyRepository<Delicacy> delicacyRepository = new DelicacyRepositoryImpl();
        CocktailRepository<Cocktail> cocktailRepository = new CocktailRepositoryImpl();
        BoothRepository<Booth> boothRepository = new BoothRepositoryImpl();

        Controller controller = new ControllerImpl(delicacyRepository, cocktailRepository, boothRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();
    }
}
