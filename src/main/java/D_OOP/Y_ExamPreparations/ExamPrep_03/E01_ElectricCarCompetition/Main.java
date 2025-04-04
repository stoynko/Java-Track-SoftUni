package D_OOP.Y_ExamPreparations.ExamPrep_03.E01_ElectricCarCompetition;

import D_OOP.Y_ExamPreparations.ExamPrep_03.E01_ElectricCarCompetition.core.*;

public class Main {

/*You are given 3 interfaces and you must implement their functionalities in the correct classes.
The application has 3 types of entities: Destination, Car and Competition. There is also 1 repository: a DestinationRepository.

Destination: BaseDestination is a base class or any type of destination and should not be instantiated.
Data:
    •	name – String
        o	If the value of the name is either null or empty (containing only whitespaces), throw an IllegalArgumentException with the following message: "Destination name cannot be null or empty."
    •	distance –  int
        o	The required distance cars must travel to reach the desired destination and finish the competition.
        o	If the distance is a negative number, throw an IllegalArgumentException with the following message: "Distance cannot be a negative number!"
    •	cars – a collection of Cars
        o	the added cars that will take part in the competition to the selected destination.
Constructor:
    •	A BaseDestination should take the following values upon initialization: String name, int distance

Child Classes:
    •	There are several concrete types of BaseDestination:
        o	Lake: It requires a travel of 25 km to be reached.
            The constructor should take the following values upon initialization: String name
        o	Mountain: It requires a travel of 60 km to be reached.
            The constructor should take the following values upon initialization: String name
        o	SeaSide: It requires a travel of 80 km to be reached.
            The constructor should take the following values upon initialization: String name

Car: The BaseCar class is a base class or any type of car and should not be instantiated.
Data:
    •	model – String
        o	If the value of the model is either null or empty (containing only whitespaces), throw a NullPointerException
            with the following message: "Car model cannot be null or empty."
    •	batteryCapacity – int
    •	mileage – int
        o	Total kilometers travelled in a single voyage
        o	The initial value is 0 km.
Constructor:
    •	The constructor should take the following values upon initialization: String model, int batteryCapacity
Behavior:
    •	void drive()
        The drive() method reduces the car's battery capacity and at the same time increases the car's mileage.
        o	The method reduces the car's battery capacity by 15 kWh.
            and increases the car's mileage by 25 km
        o	The battery capacity value should not drop below zero.
        o	Set the value to zero if the battery capacity value drops below zero.

Child Classes:
    •	There are several concrete types of BaseCar:
        o	Tesla: Has an initial battery capacity of 85 kWh.
            The constructor should take the following values upon initialization: String model
        o	Hyundai: Has an initial battery capacity of 60 kWh.
            The constructor should take the following values upon initialization: String model
        o	VW: Has an initial battery capacity of 50 kWh.
            The constructor should take the following values upon initialization: String model
        o	Dacia: Has an initial battery capacity of 30 kWh.
            The constructor should take the following values upon initialization: String model

Competition:
The CompetitionImpl class holds the main action, which is the startVoyage method. Behavior:

        •	void startVoyage(Destination destination, Collection<Car> cars)
            Here is how the startVoyage method works: A destination is provided, which includes the required distance that cars must travel.
            For each car in the destination's car collection, perform the following:
            o	Continuously drive the car while its mileage is less than the destination distance.
            o	Each car can only continue driving if its battery capacity is 15 kWh or more.
            o	If the car meets either of the following conditions, stop the current car and proceed to the next car in the collection:
            o	The mileage of the car meets or exceeds the destination's distance (the car has finished the voyage).
            o	The battery capacity of the car drops to zero or below (before reaching the destination),
                it can no longer continue (the car has NOT finished the voyage).

            Edge Cases:
            o	If a car is close to completing the required distance, but its battery capacity falls below 15 kWh it will stop even if the remaining distance is
                small enough to be covered in the next move (has NOT finished the voyage).
            Example: If the destination requires 80 km, but after reaching 75 km the car's battery drops below 15 kWh, the car will not be able to complete the journey.
            o	If the final move causes the car's mileage to meet or exceed the destination's distance just as the battery runs out (drops to 0),
                the car will be considered to have finished the voyage.

DestinationRepository:
    •	The DestinationRepository class is a repository for the destinations.
Data:
    •	destinations – a collection of Destinations
Behavior:
    •	void add(Destination destination)
        o	Adds a destination to the collection.
        o	Every destination is unique in the collection.
    •	boolean remove(Destination destination)
        o	Removes a destination from the collection. Returns true if the deletion was successful.
    •	Destination byName(String name)
        o	Returns a destination with that name.
        o	If the destination is not in the collection, return null.
    •	Collection<Destination> getCollection()
        o	Returns an unmodifiable collection of destinations.

Task 2: Business Logic (150 points)
The Controller Class:
The business logic of the program should be concentrated around several commands. You are given interfaces that you must implement in the correct classes.
Note: The ControllerImpl class SHOULD NOT handle exceptions! The tests are designed to expect exceptions, not messages!
The interface is Controller. You must create a ControllerImpl class, which implements the interface and implements all its methods.
The constructor of ControllerImpl does not take any arguments. It should be instantiated. The given methods should have the following logic:

Commands
There are several commands, which control the business logic of the application. They are stated below.
    •	AddDestination Command
        Parametars:
        o	destinationType – String
        o	destinationName – String
        Functionality:
        o	Creates a Destination with the given name of the given type and saves it in the repository.
            If the type is invalid, throw an IllegalArgumentException with the following message: "Invalid destination!"
        o	If a destination with this name already exists in the repository, throw an IllegalArgumentException with the following message: "The destination with this name already exists!"
        o	Otherwise, the method should return the following message: "Successfully added destination {destinationType} {destinationName}."
    •	AddCar Command
        Parameters:
        o	destinationName - String
        o	carBrand – String
        o	carModel - String
        Functionality:
        o	Create a Car with the provided brand and model and be prepared for the competition by adding it to the given destination's collection of cars.
            If the destination does not exist in the repository, throw a NullPointerException with the following message: "The destination does not exist!"
        o	The combination of brand (type of the car – Tesla, VW, Dacia, Hyundai) and model must be unique.
            If a car with the same brand and model already exists in the collection of the destination's cars, throw an IllegalArgumentException with the following
            message: "A car with this brand and model already exists!"
        o	If a Car brand is invalid, throw an IllegalArgumentException with the following message: "Invalid car!"
        o	If an addition is successful, the method should return the following message: "Successfully added car {carBrand} {carModel}."
    •	ReachDestination Command
        Parameters:
        o	destinationName – String
        o	Only existing destinations are guaranteed to be used.
        o	Еach destination maintains its separate collection of cars.
        o	It is guaranteed that there will always be cars added to the destination's collection of cars before the competition starts
        Functionality:
        When this command is called, the action happens. The competition for the selected destination begins:
        o	You start the competition.
        o	Keep track of the number of dropped out cars.
        o	After the competition is over, you must return the following message with the name of the reached destination and the count of the cars that
            had dropped out of the competition: "The voyage to {destinationName} is over. {droppedCarsCount} cars dropped out of the voyage."
    •	GetStatistics Command
        Functionality:
        o	Returns the information about the destinations.
            Print the destinations in the order of addition.
            Print the car(s) at the respective destination in the order of addition
            The printed statistics should be in the following format:
                "Cars that took part in competition to %s:
                *{carBrand1} {carModel1}
                **Battery capacity: {carBatteryCapacity1}kWh.
                **Mileage: {carMileage1}km.
                *{carBrand2} {carModel2}
                **Battery capacity: {carBatteryCapacity2}kWh.
                **Mileage: {carMileage2}km.
                …
                *{carBrandn} {carModeln}
                **Battery capacity: {carBatteryCapacityn}kWh.
                **Mileage: {carMileagen}km.
                **Battery capacity: {carBatteryCapacityn}kWh.
                **Mileage: {carMileagen}km."

Input / Output:
You are provided with one interface, which will help you with the correct execution process of your program.
The interface is called Engine and its implementational class should read the input. When the program finishes, the class should print the output to the console.

Input:
These are the input commands:
    •	AddDestination {destinationType} {destinationName}
    •	AddCar {destinationName} {carBrand} {carModel}
    •	ReachDestination {destinationName}
    •	GetStatistics
    •	Exit
Output:
Print the output from each command when issued. If an exception is thrown during any of the commands' execution, print the exception message. */

    public static void main(String[] args) {

        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}