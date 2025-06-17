package Y_ExamPreparations.ExamPrep_06.E01_HarpoonDiving;

import D_Java_OOP.Y_ExamPreparations.ExamPrep_06.E01_HarpoonDiving.core.*;

public class Main {

/*You are given 4 interfaces and must implement their functionalities in the correct classes.
There are 4 types of entities in the application: Diver, Diving, DivingSite, SeaCatch. There are also 2 repositories: a DiverRepository and a DivingSiteRepository.

Diver: BaseDiver is a base class or any type of diver and should not be instantiated.
Data:
    • name – String
        o If the value of the name is either null or empty (containing only whitespaces), throw a NullPointerException with the following message: "Diver name cannot be null or empty."
        o The values of the names are unique.
    • oxygen –  double
        o The oxygen of а diver.
        o If the oxygen is a negative number, throw an IllegalArgumentException with the following message: "Cannot create Diver with negative oxygen."
    • seaCatch – SeaCatch
        o A SeaCatch field type.
Behavior:
    • void shoot(). The shoot() method decreases the diver's oxygen. Keep in mind that some Diver kinds can implement the method differently.
        o The method decreases the diver's oxygen by 30 units.
        o The oxygen value should not drop below zero.
        o Set the value to be zero if the oxygen value drops below zero.
    • boolean canDive(). The canDive() method returns a boolean. Tell us if the oxygen is more than zero.
Constructor:
    • A BaseDiver should take the following values upon initialization: String name, double oxygen

Child Classes: There are several concrete types of BaseDiver.
    • OpenWaterDiver
        o Has 30 initial units of oxygen.
        o The constructor should take the following values upon initialization: String name
    • DeepWaterDiver
        o Has 90 initial units of oxygen.
        o The constructor should take the following values upon initialization: String name
    • WreckDiver
        o Has an initial 150 units of oxygen.
        o The constructor should take the following values upon initialization: String name

    • SeaCatch: The BaseSeaCatch class holds a collection of sea creatures. It should be instantiated.
        o seaCreatures – a collection of Strings
        o Constructor: The constructor should not take any values upon initialization.

DivingSite: The DivingSiteImpl class holds information about the sea creatures that can be caught. It should be instantiated.
Data:
    • name – String
        o If the value of the name is either null or empty (containing only whitespaces), throw a NullPointerException with the following message: "Invalid name!"
    • seaCreatures – a collection of Strings
Constructor:
    • The constructor should take the following values upon initialization: String name

Diving: The DivingImpl class holds the main action, which is the searching method.
Behavior:
    • void searching(DivingSite divingSite, Collection<Diver> divers)
        o Divers cannot dive on site if their oxygen is equal to or below 0.
        o They dive into the water and start searching the site for sea creatures one by one.
        o If they find a sea creature, they shoot it, and their oxygen is decreased.
        o They add the creature to their catch. The sea creature should then be removed from the diving site.
        o Divers cannot continue shooting if their oxygen drops to 0.
        o If their oxygen drops to 0, the next diver starts diving.

DiverRepository: The DiverRepository class is a repository for divers.
Data:
    • divers – a collection of divers
Behavior:
    • void add(Diver diver)
        o Adds a diver to the collection.
        o Every diver is unique in the collection.
        o It is guaranteed that there will not be a diver with the same name.
    • boolean remove(Diver diver)
        o Removes a diver from the collection. Returns true if the deletion was successful.
    • Diver byName(String name)
        o Returns a diver with that name.
        o If the driver is not in the collection, return null.
    • Collection<Diver> getCollection()
        o Returns an unmodifiable collection of divers.

DivingSiteRepository: The DivingSiteRepository class is a repository for diving sites.
Data:
    • sites – a collection of diving sites
Behavior:
    • void add(DivingSite divingSite)
        o Adds a site for diving.
        o Every site is unique in the collection.
        o It is guaranteed that there will not be a site with the same name.
    • boolean remove(DivingSite divingSite)
        o Removes a site from the collection. Returns true if the deletion was successful.
    • DivingSite byName(String name)
        o Returns a site with that name.
        o If the site is not in the collection, return null.
    • Collection<DivingSite> getCollection()
        o Returns an unmodifiable collection of sites.

The Controller Class:
The business logic of the program should be concentrated around several commands. You are given interfaces that you must implement in the correct classes.
Note: The ControllerImpl class SHOULD NOT handle exceptions! The tests are designed to expect exceptions, not messages! The interface is Controller. You must create a ControllerImpl class,
which implements the interface and implements all its methods. The constructor of ControllerImpl does not take any arguments. It should be instantiated.
The given methods should have the following logic:

Commands: There are several commands, which control the business logic of the application. They are stated below.
    • AddDiver Command
        o kind – String
        o diverName – String
	  Functionality:
        o Creates a diver with the given name of the given kind and saves it in the repository.
        o If the kind is invalid, throw an IllegalArgumentException with the following message: "Diver kind doesn't exist."
        o Otherwise, the method should return the following message: "Added {kind}: {diverName}."
    • AddDivingSite Command
        o siteName - String
        o seaCreatures – String... (seaCreatures)
      Functionality:
        o Create a diving site with the provided sea creatures and name and save it in the repository.
        o The method should return the following message: "Added site: {siteName}."
    • RemoveDiver Command
        o diverName – String
      Functionality:
        o Remove the diver from diving by removing them from the repository.
        o If a diver with that name doesn’t exist, throw IllegalArgumentException with the following message: "Diver {diverName} doesn't exist."
        o If a diver is successfully excluded, remove them from the repository and return the following message: "Diver {diverName} has removed!"
    • StartDiving Command
        o siteName - String
      Functionality:
        o When the start diving command is called, the action happens. After picking only the divers that have oxygen above 30 units, the diving at the given site begins.
        o If you don't have any suitable divers, throw an IllegalArgumentException with the following message: "You must have at least one diver to start diving."
        o After a diving, you must return the following message with the name of the diving site and the count of the diver/s that was/were removed from the diving:
          "The dive took place at {siteName}. {removedDiverCount} diver/s was/were removed on this dive."
    • GetStatistics Command
      Functionality:
        o Returns the information about the divers in the following format:
		  "The dive took place at {count} site/s.
           Diver's statistics:
           Name: {diverName}
           Oxygen: {diverOxygen}
           Diver's catch: {seaCreature1, seaCreature2, seaCreature3, …, seaCreaturen}
           …
           Name: {diverName}
           Oxygen: {diverOxygen}
           Diver's catch: {seaCreature1, seaCreature2, seaCreature3, …, seaCreaturen}"
        o If the divers don't have any catch, print "None" in their place
		.
Input / Output: You are provided with one interface, which will help you with the correct execution process of your program.
The interface is called Engine and its implementational class should read the input. When the program finishes, the class should print the output to the console.


These are the input commands:
    • AddDiver {diverKind} {diverName}
    • AddDivingSite {siteName} {String... (seaCreatures)}
    • RemoveDiver {diverName}
    • StartDiving {siteName}
    • GetStatistics
    • Exit

Output: Print the output from each command when issued. If an exception is thrown during any of the commands' execution, print the exception message. */

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
