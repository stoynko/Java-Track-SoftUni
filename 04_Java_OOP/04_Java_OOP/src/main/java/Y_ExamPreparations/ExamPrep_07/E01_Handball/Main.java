package Y_ExamPreparations.ExamPrep_07.E01_Handball;

import D_Java_OOP.Y_ExamPreparations.ExamPrep_07.E01_Handball.core.*;

public class Main {

/*You are given 3 interfaces and must implement their functionalities in the correct classes The application has 3 types of entities: Gameplay, Team, Equipment. There should also be Repository.

Equipment: BaseEquipment is a base class of any type of equipment, and it should not be able to be instantiated.
Data:
    • protection - int
    • price - double
        o The price of the equipment.
Constructor:
    • An Equipment should take the following values upon initialization: (int protection, double price)

Child Classes: There are two concrete types of Equipments.
    • Kneepad:
        o It has 120 protection, and its price is 15.
        o Constructors should take no values upon initialization.
    • ElbowPad
        o It has 90 protection, and its price is 25.
        o Constructors should take no values upon initialization.

Team: BaseTeam is a base class of any type of team, and it should not be able to be instantiated.
Data:
    • name -  String
        o If the name is null or whitespace, throw a NullPointerException with a message: "Team name cannot be null or empty."
        o All names are unique.
    • country -  String
        o If the country is null or whitespace, throw a NullPointerException with а message: "Team country cannot be null or empty."
    • advantage -  int
        o The advantage of the Team.
        o If the advantage is below or equal to 0, throw an IllegalArgumentException with а message: "Team avantage cannot be below or equal to 0."
Behavior:
    • void play(). The play() method increases the Team’s advantage.
      Keep in mind that different types of Team can implement the method differently.
Constructor:
    • A team should take the following values upon initialization: (String name, String country, int advantage)

Child Classes: There are several concrete types of Team.
    • Bulgaria
        o I can only play Outdoor!
        o The constructor should take the following values upon initialization: (String name, String country, int advantage)
        o Behavior: void play()
            o The method increases the team’s advantage by 115.
    • Germany
        o I can only play Indoor!
        o The constructor should take the following values upon initialization: (String name, String country, int advantage)
        o Behavior: void play()
            o The method increases the team’s advantage by 145.

Gameplay: BaseGameplay is a base class of any type of Gameplay, and it should not be able to be instantiated.
Data:
    • name -  String
        o If the name is null or whitespace, throw a NullPointerException with a message: "Gameplay name cannot be null or empty."
        o All names are unique.
    • capacity -  int
        o The numbers of Team а Gameplay can have.
    • equipments -  Collection<Equipment>
    • teams -  Collection<Team>
Behavior:
    • Constructor
        o A Gameplay should take the following values upon initialization: String name, int capacity
    • int allProtection()
        o Returns the sum of each equipment’s protection in the Gameplay.
    • void addTeam(Team team)
        o Adds a Team on the Team. No need to check for empty space.
    • void removeTeam(Team team)
        o Removes a Team from the Gameplay.
    • void addEquipment(Equipment equipment)
        o Adds an Equipment in the Gameplay.
    • void teamsInGameplay()
        o The teamsInGameplay() method calls all teams to play in the gameplay.
    • String toString()
        o Returns a String with information about the Gameplay in the format below. If the Gameplay doesn't have a team, print "none" instead.
			"{gameplayName} {gameplayType}
			Team: {teamName1} {teamName2} (…) / Team: none
			Equipment: {equipmentsCount}, Protection: {allProtection}"

Child Classes: There are 2 concrete types of Gameplay.
    • Outdoor
        o Has 150 capacity.
        o The constructor should take the following values upon initialization: String name
    • Indoor
        o Has 250 capacity.
        o The constructor should take the following values upon initialization: String name

Repository: The EquipmentRepository is a repository for the equipment that is in the gameplay.
Data:
    • equipments - Collection<Equipment>
Behavior:
    • void аdd(Equipment equipment)
        o Added equipment to the collection.
    • boolean remove(Equipment equipment)
        o Removes equipment from the collection. Returns true if the deletion was successful, otherwise - false.
    • Equipment findByType(String type)
        o Returns the first equipment of the given type, if there is. Otherwise, returns null.


The Controller Class
The business logic of the program should be concentrated around several commands. You are given interfaces that you must implement in the correct classes.
Note: The ControllerImpl class SHOULD NOT handle exceptions! The tests are designed to expect exceptions, not messages!
The first interface is Controller. You must create a ControllerImpl class, which implements the interface and implements all its methods.
The constructor of ControllerImpl does not take any arguments. It should be instantiated. The given methods should have the following logic:

Data: You need to keep track of some things, and this is why you need some private fields in your controller class.
    • equipment - Repository
    • gameplays - a collection of Gameplay

Commands: There are several commands which control the business logic of the application. They are stated below. The Gameplay name passed to the methods will always be valid!
    • AddGameplay Command (gameplayType - String, gameplayName - String)
        o Adds a Gameplay. Valid types are: "Outdoor" and "Indoor".
        o If the Gameplay type is invalid, you have to throw a NullPointerException with the following message: "Invalid gameplay type."
        o If the Gameplay is added successfully, the method should return the following String: "Successfully added {gameplayType}."
    • AddEquipment Command (type - String)
        o Creates equipment of the given type and adds it to the Repository. Valid types are "Kneepad" and "ElbowPad".
        o If the equipment type is invalid, throw an IllegalArgumentException with a message: "Invalid equipment type."
        o The method should return the following String if the operation is successful: "Successfully added {equipmentType}."
    • EquipmentRequirement Command (gameplayName - String, equipmentType - String)
        o Adds the desired Equipment to the Gameplay with the given name. You have to remove the Equipment from Repository if the insert is successful.
        o If there is no such equipment, you have to throw an IllegalArgumentException with the following message: "There isn't an equipment of type {equpmentType}."
        o If no exceptions are thrown return the String: "Successfully added {equpmentType} to {gameplayName}."
    • AddTeam Command (gameplayName - String, teamType - String, teamName - String, country - String, advantage - int)
        o Check if the team type is valid. Valid Team types are: "Bulgaria", "Germany". Adds the desired Team to the Gameplay with the given name.
        o If the Team type is invalid, you have to throw an IllegalArgumentException with the following message: "Invalid team type." - if the Team type is invalid.
        o If no errors are thrown, return one of the following strings: "The coverage of the terrain is not suitable." - if the Team cannot play in the Gameplay
        o "Successfully added {teamType} to {gameplayName}." - if the Team is added successfully in the Gameplay
    • PlayInGameplay Command (gameplayName - String)
        o All teams with given name must be on the Gameplay.
        o Returns a string with information about how many teams were successfully played in the following format: "Teams that have played: {playedCount}"
    • PercentAdvantage Command (gameplayName - String)
        o Calculates the value of the Gameplay with the given name. It is calculated by the sum of all Team’s advantages in the Gameplay.
        o Return a string in the following format: "The advantage of Gameplay {gameplayName} is {value}."
    • GetStatistics Command
    • Returns information about each gameplay. You can use the overridden .toString() Gameplay method.
		"{gameplayName} {gameplayType}
		Team: {teamName1} {teamName2} (…) / Team: none
		Equipment: {equipmentsCount}, Protection: {allProtection}
		{gameplayName} {gameplayType}
		Team: {teamName1} {teamName2} (…) / Team: none
		Equipment: {equipmentsCount}, Protection: {allProtection}
		(…)"

    • Exit Command
        o Ends the program.

Input / Output:
You are provided with one interface, which will help you with the correct execution process of your program.
The interface is Engine, and the class implementing this interface should read the input, and when the program finishes,
this class should print the output.

Input: Below, you can see the format in which each command will be given in the input.
    • AddGameplay {gameplayType} {gameplayName}
    • AddEquipment {equipmentType}
    • EquipmentRequirement {gameplayName} {equipmentType}
    • AddTeam {gameplayName} {teamType} {teamName} {country} {advantage}
    • PlayInGameplay {gameplayName}
    • PercentAdvantage {gameplayName}
    • GetStatistics
    • Exit */

    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
