package D_OOP.X_ExamPreparations.ExamPrep_02.E01_Climbers;

import D_OOP.X_ExamPreparations.ExamPrep_02.E01_Climbers.core.*;

public class Main {

/*/*You are given 4 interfaces and must implement their functionalities in the correct classes.
There are 4 types of entities in the application: Climber, Climbing, Mountain and Roster. There are also 2 repositories: a ClimberRepository and a MountainRepository.

Climber: BaseClimber is a base class or any type of Climber and should not be instantiated.
Data:
    • name – String
        o If the value of the name is either null or empty (containing only whitespaces), throw a NullPointerException with the following message: "Climber name cannot be null or empty."
        o The values of the names are unique.
    • strength –  double
        o The strength of а Climber.
        o If the strength is a negative number, throw an IllegalArgumentException with the following message: "Cannot create Climber with negative strength."
    • roster – Roster
        o A Roster field type.

Behaviour:
    • void climb(). The climb() method decreases the climber's strength. Keep in mind that some Climber types can implement the method differently.
        o The method decreases the climber's strength depending on Climber type:
        o for Climber of type WallClimber by 30 units.
        o for Climber of type RockClimber by 60 units.
        o The strength value should not drop below zero.
        o Set the value to be zero if the strength value drops below zero.
    • boolean canClimb(). The canClimb() method returns a boolean. Tell us if the strength is more than zero.
Constructor:
    • A BaseClimber should take the following values upon initialization: String name, double strength

Child Classes: There are several concrete types of BaseClimber.
    • WallClimber
        o Has 90 initial units of strength.
        o The constructor should take the following values upon initialization: String name
    • RockClimber
        o Has 120 initial units of strength.
        o The constructor should take the following values upon initialization: String name

Roster: The RosterImpl class holds a collection of peaks. It should be instantiated.
    • Data
        o peaks – a collection of Strings
    • Constructor: The constructor should not take any values upon initialization.

Mountain: The MountainImpl class holds information about the peaks that can be conquered. It should be instantiated.
Data:
    • name – String
        o	If the value of the name is either null or empty (containing only whitespaces), throw a NullPointerException with the following message: "Invalid name!"
    • peaksList – a collection of Strings
Constructor:
    • The constructor should take the following values upon initialization: String name

Climbing: The ClimbingImpl class holds the main action, which is the conqueringPeaks method.
Behaviour:
    • void conqueringPeaks(Mountain mountain, Collection<Climber> climbers)
        o Climbers cannot climb peaks if their strength is equal to or below 0.
        o They start climbing and conquering peaks, one by one.
        o If they conquer a peak, they add it to their roster of conquered peaks and their strength is decreased.
        o The conquered peak should then be removed from the peaks list of the current mountain.
        o Climbers cannot continue climbing if their strength drops to 0. If their strength drops to 0, the next climber starts climbing.

ClimberRepository: The ClimberRepository class is a repository for climbers.
Data:
    • climbers – a collection of climbers
Behaviour:
    • void add(Climber climber)
        o Adds a climber to the collection.
        o Every climber is unique in the collection.
        o It is guaranteed that there will not be a climber with the same name.
    • boolean remove(Climber climber)
        o Removes a climber from the collection. Returns true if the deletion was successful.
    • Climber byName(String name)
        o Returns a climber with that name.
        o If the climber is not in the collection, return null.
    • Collection<Climber> getCollection()
        o Returns an unmodifiable collection of climbers.

MountainRepository: The MountainRepository class is a repository for mountains.
Data:
    • mountains – a collection of mountains
Behavior:
    • void add(Mountain mountain)
        o Adds a mountain to the collection.
        o Every mountain is unique in the collection.
        o It is guaranteed that there will not be a mountain with the same name.
    • boolean remove(Mountain mountain)
        o Removes a mountain from the collection. Returns true if the deletion was successful.
    • Mountain byName(String name)
        o Returns a mountain with that name.
        o If the mountain is not in the collection, return null.
    • Collection<Mountain> getCollection()
        o Returns an unmodifiable collection of mountains.

The Controller Class:
The business logic of the program should be concentrated around several commands. You are given interfaces that you must implement in the correct classes.
Note: The ControllerImpl class SHOULD NOT handle exceptions! The tests are designed to expect exceptions, not messages! The interface is Controller. You must create a ControllerImpl class,
which implements the interface and implements all its methods. The constructor of ControllerImpl does not take any arguments. It should be instantiated. The given methods should have the following logic:

Commands: There are several commands, which control the business logic of the application. They are stated below.

    • AddClimber Command
        o type – String
        o climberName – String
       Functionality:
        o Creates a climber with the given name of the given type and saves it in the repository.
        o If the type is invalid, throw an IllegalArgumentException with the following message: "Climber type doesn't exist."
        o Otherwise, the method should return the following message: "Added {type}: {climberName}."

    • AddMountain Command
        o mountainName - String
        o peaks – String... (peaks)
       Functionality:
        o Create a mountain with the provided peaks and name and save it in the repository.
        o The method should return the following message: "Added Mountain: {mountainName}."
    • RemoveClimber Command
        o climberName – String
       Functionality
        o Remove the climber from climbing by removing them from the repository.
        o If a climber with that name doesn’t exist, throw IllegalArgumentException with the following message: "Climber {climberName} doesn't exist."
        o If a climbers is successfully removed, remove them from the repository and return the following message: "Climber {climberName} was removed!"
    • StartClimbing Command
        o mountainName - String
       Functionality:
        o When the start climbing command is called, the climbing at the given mountain begins.
        o If you don't have any climbers, throw an IllegalArgumentException with the following message: "You must have at least one climber to start climbing."
        o After climbing, you must return the following message with the name of the climbed mountain and the count of the climber/s that was/were removed from the climbing:
          "The climb took place at {mountainName}. {removedClimberCount} climber/s was/were removed from this climb."
    • GetStatistics Command
      Functionality:
        o Returns the information about the climbers in the following format:
          "{count} mountain/s was/were climbed.
          Climber's statistics:
          Name: {climberName}
          Strength: {climberStrength}
          Conquered peaks: {peak1, peak2, peak3, …, peakn}
          …
          Name: {climberName}
          Strength: {climberStrength}
          Conquered peaks: {peak1, peak2, peak3, …, peakn}"
        o If the climbers don't conquer any peak, print "None" in their place.

Input / Output:
You are provided with one interface, which will help you with the correct execution process of your program. The interface is called Engine and its implementational class should read the input.
When the program finishes, the class should print the output to the console.

Input:
These are the input commands:
    •	AddClimber {climberType} {climberName}
    •	AddMountain {mountainName} {String... (peaks)}
    •	RemoveClimber {climberName}
    •	StartClimbing {mountainName}
    •	GetStatistics
    •	Exit
Output: Print the output from each command when issued. If an exception is thrown during any of the commands' execution, print the exception message. */

    public static void main(String[] args) {

        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
