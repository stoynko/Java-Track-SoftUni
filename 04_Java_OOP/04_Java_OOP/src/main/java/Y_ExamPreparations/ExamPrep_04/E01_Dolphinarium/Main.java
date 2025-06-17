package Y_ExamPreparations.ExamPrep_04.E01_Dolphinarium;

import D_Java_OOP.Y_ExamPreparations.ExamPrep_04.E01_Dolphinarium.core.*;

public class Main {

/*You are given 3 interfaces and you must implement their functionalities in the correct classes.
There are 3 types of entities in the application: Pool, Dolphin, and Food. There should also be FoodRepository.

Food: BaseFood is a base class of any type of food and it should not be able to be instantiated.
Data:
    •	calories - int
        o	The amount of calories in each food.
Constructor:
    •	A Food should take the following values upon initialization: (int calories)

Child Classes: There are three concrete types of Food.

    •	Squid (The constructor should take no values upon initialization.)
        o	Has 175 calories.
    •	Herring (The constructor should take no values upon initialization.)
        o	Has 200 calories.
    •	Mackerel (The constructor should take no values upon initialization.)
        o	Has 305 calories.

Dolphin: BaseDolphin is a base class of any type of dolphin and it should not be able to be instantiated.
Data:
    •	name - String
        o	If the name is null or whitespace, throw a NullPointerException with a message: "Dolphin name cannot be null or empty."
        o	All names are unique.
    •	energy- int
        o	The energy of the Dolphin.
        o	It is guaranteed that you will receive only positive values
        o	If the energy drops below 0 (zero) set it to 0 (zero)
Behavior:
    •	void jump()
        o	The jump() method decreases the Dolphin’s energy initially by 10 units.
            Each Dolphin implements the method differently and reduces the energy by additional units depending on its type.
    •	void eat(Food food)
        The eat() method increases the dolphin’s energy by the value of calories contained in the food he ate:
        o	If a dolphin eats Squid – his energy increases by 175;
        o	If a dolphin eats a Herring – his energy increases by 200;
        o	If a dolphin eats Mackerel – his energy increases by 305;
Constructor:
    •	A Dolphin should take the following values upon initialization: String name, int energy

Child Classes: There are several concrete types of Dolphin.

    •	BottleNoseDolphin (Can only swim in DeepWaterPool)
        o	The constructor should take the following values upon initialization: String name, int energy
        Behavior:
        o	void jump(): The method decreases the dolphin’s energy by an additional 190 units
    •	SpottedDolphin (Can swim in DeepWaterPool as well as in ShallowWaterPool)
        o	The constructor should take the following values upon initialization: String name, int energy
        Behavior:
        o	void jump(): The method decreases the dolphin’s energy by an additional 90 units.
    •	SpinnerDolphin (Can only swim in ShallowWaterPool)
        o	The constructor should take the following values upon initialization: String name, int energy
        Behavior:
        o	void jump(): The method decreases the dolphin’s energy by an additional 40 units.

Pool: BasePool is a base class of any type of Pool and it should not be able to be instantiated.
Data:
    •	name - String
        o	If the name is null or whitespace, throw a NullPointerException with a message: "Pool name cannot be null or empty."
        o	All names are unique.
    •	capacity -  int
        o	The number of Dolphin аn Pool can have.
    •	foods - Collection<Food>
    •	dolphins - Collection<Dolphin>
Constructor:
    •	An Pool should take the following values upon initialization: String name, int capacity
Behavior:
    •	void addDolphin(Dolphin dolphin)
        o	Adds an Dolphin in the Pool if there is the capacity for it.
        o	If there is not enough capacity to add the Dolphin to the Pool throw an IllegalStateException with the following message: "Not enough capacity."
        o	If the energy  of the dolphin is below or equal to 0, throw an IllegalArgumentException with the message: "Dolphin energy cannot be below or equal to 0."
    •	void removeDolphin(Dolphin dolphin)
        o	Removes an Dolphin from the Pool.
    •	void addFood(Food food)
        o	Adds a Food in the Pool.

Child Classes: There are 2 concrete types of Pool.
    •	DeepWaterPool
        o	Has 5 capacity.
        o	The constructor should take the following values upon initialization: String name
    •	ShallowWaterPool
        o	Has 2 capacity.
        o	The constructor should take the following values upon initialization: String name

FoodRepository: The FoodRepositoryImpl is a repository for the foods that are in the Pool.
Data:
    •	foods - Collection<Food>
Behavior
    •	void add(Food food)
        o	Adds food to the collection. It is possible to add the same type of food more than once.
    •	boolean remove(Food food)
        o	Removes food from the collection. Returns true if the deletion was successful, otherwise - false.
    •	Food findByType(String type)
        o	Returns the first food of the given type, if there is one. Otherwise, returns null.

Task 2: Business Logic (150 points)
The Controller Class
The business logic of the program should be concentrated around several commands. You are given interfaces, which you have to implement in the correct classes.
Note: The ControllerImpl class SHOULD NOT handle exceptions! The tests are designed to expect exceptions, not messages!
The first interface is Controller. You must create a ControllerImpl class, which implements the interface and implements all its methods.
The constructor of ControllerImpl does not take any arguments. The given methods should have the following logic:

Data:
You need to keep track of some things, this is why you need some private fields in your controller class:
    •	foodRepository - FoodRepository
    •	pools - a Collection of Pool

Commands:
There are several commands, which control the business logic of the application. They are stated below. The Pool name passed to the methods will always be valid!
    •	AddPool Command
        Parameters:
        •	poolType - String
        •	poolName - String
        Functionality:
        o	Adds an Pool in the collection. Valid types are: "DeepWaterPool" and "ShallowWaterPool".
        o	If the Pool type is invalid, you have to throw a NullPointerException with the following message: "Invalid Pool type."
        o	If there is a Pool with the same name, you have to throw a NullPointerException with the following message: "Pool already exists."
        o	If the Pool is added successfully, the method should return the following String: "Successfully added {poolType} {poolName}."
    •	BuyFood Command
        Parameters:
        o	foodType - String
        Functionality:
        o	Buys a food of the given type and adds it to the FoodRepository. Valid types are: "Squid", "Herring" and "Mackerel".
            If the food type is invalid, throw an IllegalArgumentException with the message: "Invalid food type."
        o	The method should return the following string if the operation is successful: "Successfully bought food {foodType}."
        o	It's acceptable to buy food from the same type more than once.
    •	AddFoodToPool Command
        Parameters:
        o	poolName - String
        o	foodType - String
        Functionality:
        o	Adds the desired Food to the Pool with the given name. You must remove the Food from the FoodRepository if the insert succeeds.
        o	If there is no such food, in the FoodRepository you have to throw an IllegalArgumentException with the following message: "There isn't a food of type {foodType} in repository."
        o	If no exceptions are thrown return the String: "Successfully added {foodType} to {poolName}."
    •	AddDolphin Command
        Parameters:
        o	poolName - String
        o	dolphinType - String
        o	dolphinName - String
        o	energy - int
        Functionality:
        o	Adds the desired Dolphin to the Pool with the given name. Valid Dolphin types are "BottleNoseDolphin", "SpottedDolphin" and "SpinnerDolphin".
        o	If the Dolphin type is invalid, you have to throw an IllegalArgumentException with the following message: "Invalid dolphin type."
        o	If the Dolphin name already exists,you have to throw an IllegalArgumentException with the following message: "Dolphin already exists."
        o	If no errors are thrown, return one of the following strings:
            "This pool is not suitable." - if the Dolphin cannot swim in the Pool
            "Successfully added {dolphinType} {dolphinName} to {poolName}." - if the Dolphin is added successfully to the Pool
    •	FeedDolphins Command
        Parameters:
        o	poolName – String
        o	foodType - String
        Functionality:
        o	Feeds all Dolphin in the Pool with the given name.
        o	If there is such foodType added in the given pool, returns a string with information about how many dolphins were successfully fed,
            in the following format: "{fedDolphinsCount} dolphin/s in pool {poolName} was/were fed." otherwise throw an IllegalArgumentException with the following
            message: "There is no such food for this pool."
        o	After a successful feeding, you have to remove the food that dolphins ate from foods collection of the given pool.
    •	PlayWithDolphins Command
        Parameters:
        o	poolName – String
        Functionality:
        o	This command makes the dolphins start playing by jumping. Each jump reduced the dolphin's energy (each dolphin in the given pool jumps once with
            every command) by an amount depending on the type of dolphin. If the dolphin's energy reaches 0 (zero) or less you have to remove the current
            dolphin from the pool. Keep track of removed dolphins. Finally, print the message:
            "There was a play with dolphin/s in {poolName}. {countOfRemovedDolphins} dolphins was/were removed!"
        o	If there are no dolphins in the given pool throw an IllegalArgumentException with the following message: "There are no dolphins to play with."
    •	GetStatistics Command
        Functionality:
        o	Returns information about each Pool.
                "Dolphins in pool {poolName}:
                {dolphinName1 - dolphinEnergy1}, {dolphinName2 – dolphinEnergy2}, {dolphinName3 – dolphinEnergy3}, (…)"
        o	If there are no dolphins in some pool, print:
                "Dolphins in pool {poolName}:
                 none"
    •	Exit Command
        o	 Functionality: Ends the program.

Input / Output:
You are provided with one interface, which will help you with the correct execution process of your program.
The interface is Engine and the class implementing this interface should read the input and when the program finishes, this class should print the output.

Input:
Below, you can see the format in which each command will be given in the input:
    •	AddPool {poolType} {poolName}
    •	BuyFood {foodType}
    •	AddFoodToPool {poolName} {foodType}
    •	AddDolphin {poolName} {dolphinType} {dolphinName} {energy}
    •	FeedDolphins {String poolName}, {String food}
    •	PlayWithDolphins {String poolName}
    •	GetStatistics
    •	Exit
Output:

Print the output from each command when issued. If an exception is thrown during any of the commands' execution, print the exception message. */

    public static void main(String[] args) {

        Engine engine = new EngineImpl();
        Controller controller = new ControllerImpl();
        engine.run();
    }
}
