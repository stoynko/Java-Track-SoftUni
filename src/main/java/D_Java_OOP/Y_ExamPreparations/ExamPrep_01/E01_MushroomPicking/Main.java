package D_Java_OOP.Y_ExamPreparations.ExamPrep_01.E01_MushroomPicking;

import D_Java_OOP.Y_ExamPreparations.ExamPrep_01.E01_MushroomPicking.core.Controller;
import D_Java_OOP.Y_ExamPreparations.ExamPrep_01.E01_MushroomPicking.core.ControllerImpl;
import D_Java_OOP.Y_ExamPreparations.ExamPrep_01.E01_MushroomPicking.core.Engine;
import D_Java_OOP.Y_ExamPreparations.ExamPrep_01.E01_MushroomPicking.core.EngineImpl;

public class Main {
/*You are given 4 interfaces and you must implement their functionalities in the correct classes.
There are 4 types of entities in the application: Bag, Picker, Place, Action. There is also 1 repository: a PlaceRepository.

Bag: The BagImpl class holds a collection of mushrooms. It should be instantiated.
Data:
    • mushrooms – a collection of Strings
Constructor: The constructor should not take any values upon an initialization.

Picker: BasePicker is a base class or any type of Picker and should not be instantiated.
Data:
    • name – String
        o If the value of the name is either null or empty (containing only whitespaces), throw a IllegalArgumentException with the following message: "Picker name cannot be null or empty."
        o The values of the names are unique.
    • vitality – int
        o The vitality of а Picker.
        o If the vitality is a negative number, throw an IllegalArgumentException with the following message: "Cannot create Picker with negative vitality."
    • bag – Bag
        o A Bag field type. It is necessary to initialize a new BagImpl instance.
Constructor:
    • A BasePicker should take the following values upon initialization: String name, int vitality
Behavior
    • void pick(). The pick() method decreases the Picker's vitality.
        o The method decreases the Picker's vitality by 10 units.
        o The vitality value should not drop below zero.
        o Set the value to zero if the vitality value goes below zero.

Child Classes: There are several concrete types of BasePicker.
JuniorPicker:
    • Has 30 initial units of vitality.
    • The constructor should take the following values upon an initialization: String name
ExperiencedPicker:
    • Has 60 initial units of vitality.
    • The constructor should take the following values upon an initialization: String name

Place: The PlaceImpl class holds information about the mushrooms that can be found and picked. It should be instantiated.
Data:
    • name – String
        o If the value of the name is either null or empty (containing only whitespaces), throw a IllegalArgumentException with the following message: "Place name cannot be null or empty."
    • mushrooms – a collection of Strings
    • pickers – a collection of Pickers
Constructor:
    • The constructor should take the following values upon initialization: String name

Action: The ActionImpl class holds the main action, which is the startPicking method.
Behavior:
•	void startPicking(Place place)
        o Pickers cannot start picking if their vitality is below 0.
        o They visit the given place and start picking mushrooms one by one.
        o If they find a mushroom, picking it and their vitality is decreased.
        o They add the mushroom to their Bag. The mushroom should then be removed from the place.
        o If some picker picks a poisonous mushroom (some mushrooms in the place's collection of mushrooms start with the word "poisonous"),
		  he should drop out all the picked mushrooms so far from his Bag and continue picking.
        o Pickers cannot continue collecting mushrooms if their vitality drops to 0.
        o If their vitality drops to 0, the next Picker starts inspecting.

PlaceRepository: The PlaceRepository class is a repository for places.
Data:
    • places – a collection of Places
Behavior:
    • void add(Place place)
        o Adds a place for picking.
        o Every place is unique in the collection.
        o It is guaranteed that there will not be a place with the same name.
    • boolean remove(Place place)
        o Removes a place from the collection. Returns true if the deletion was successful.
    • Place byName(String name)
        o Return a place with that name.
        o If the place is not in the collection, return null.
    • Collection<Place> getCollection()
        o Returns an unmodifiable collection of places.

The business logic of the program should be concentrated around several commands. You are given interfaces that you must implement in the correct classes.
Note: The ControllerImpl class SHOULD NOT handle exceptions! The tests are designed to expect exceptions, not messages!
The interface is Controller. You must create a ControllerImpl class, which implements the interface and implements all its methods.
The constructor of ControllerImpl does not take any arguments. It should be instantiated. The given methods should have the following logic:

Commands: There are several commands, which control the business logic of the application. They are stated below.

    • AddPlace Command (placeName - String, mushrooms – String... (mushrooms(Varargs))
        o Create a place with the provided mushrooms and name and save it in the repository. All places' names will be unique.
        o The method should return the following message: "Place {placeName} added."

    • AddPicker Command (placeName – String, pickerType – String, pickerName – String)
        o Creates a Picker with the given name of the given type and saves it to the collection of pickers in the given place. Pickers will always be added to existing picking places.
        o If a Picker with the same name already exists in the location, throw an IllegalArgumentException with the following message: "Picker with this name already exists in this location."
        o If the Picker type is invalid, throw an IllegalArgumentException with the following message: "Invalid picker."
        o Otherwise, the method should return the following message: "{pickerType} {pickerName} added."

    • StartPicking Command (placeName - String)
        o When the startPicking command is called, the action happens.
        o If the Place where you are trying to start picking does not exist, in the place repository,
	      throw a NullPointerException with the following message: "{placeName} does not exist in the place repository."
        o Otherwise, you should start picking mushrooms in the given place by calling each of the pickers one by one.
        o After the picking is over, you must return the following message with the name of the visited place: "Place {placeName} was visited."

    • GetStatistics Command
        o Returns the information about the Pickers in the following format:
        o If the Picker does not have any mushrooms in his Bag, print "none" in their place.
			"Pickers in the {placeName1}:
			Name: {pickerName1}
			Vitality: {pickerVitality1}
			Bag mushrooms: {mushroom1, mushroom2, mushroom3, …, mushroomN}
			…
			Name: {pickerNameN}
			Vitality: {pickerVitalityN}
			Bag mushrooms: {mushroom1, mushroom2, mushroom3, …, mushroomN}"

Input / Output:
You are provided with one interface, which will help you with the correct execution process of your program.
The interface is called Engine and its implementation class should read the input. When the program finishes, the class should print the output to the console.

Input:
These are the input commands:
    • AddPlace {placeName} {String... (mushrooms(Varargs))}
    • AddPicker {placeName} {pickerType} {pickerName}
    • StartPicking {placeName}
    • GetStatistics
    • Exit

Output: Print the output from each command when issued. If an exception is thrown during any of the commands' execution, print the exception message. */
    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}