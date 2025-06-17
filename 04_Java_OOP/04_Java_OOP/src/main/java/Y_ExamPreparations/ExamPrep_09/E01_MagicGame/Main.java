package Y_ExamPreparations.ExamPrep_09.E01_MagicGame;

import Y_ExamPreparations.ExamPrep_09.E01_MagicGame.core.Engine;
import Y_ExamPreparations.ExamPrep_09.E01_MagicGame.core.EngineImpl;

public class Main {

/* You are given interfaces, and you have to implement their functionality in the correct classes.
There are 3 types of entities in the application: Magic, Magicians, and Region. There should also be MagicRepositoryImpl and MagicianRepositoryImpl.

MagicImpl: MagicImpl is a base class of any type of magic and it should not be able to be instantiated.
Data:
    • name – String
        o If the name is null or whitespace, throw a NullPointerException with a message: "Magic cannot be null or empty."
        o All names are unique.
    • bulletsCount – int
        o If the bullet count is below zero, throw an IllegalArgumentException with a message: "Bullets cannot be below 0."
Behavior:
    • int fire(). The fire() method fires the number of bullets the Magic has and reduces its available amount. RedMagic can fire only 1 bullet and the BlackMagic only 10 at once, not more, not less.
       If there are not enough bullets, the method should return 0.
Constructor:
    • A Magic should take the following values upon initialization: String name, int bulletsCount

Child Classes: There are two types of Magic.

    • RedMagic
        o RedMagic can fire() 1 bullet at a time.
        o The constructor should take the following values upon initialization: String name, int bulletsCount

    • BlackMagic
        o BlackMagic can fire() 10 bullets at a time.
        o The constructor should take the following values upon initialization: String name, int bulletsCount

MagicianImpl: MagicianImpl is a base class for any type of magician, and it should not be able to be instantiated.

Data:
    • username - String
        o If the username is null or whitespace, throw a NullPointerException with a message: "Username cannot be null or empty."
        o All names are unique.

    • health -  int
        o If the health is below 0, throw an IllegalArgumentException with a message: "Magician health cannot be below 0."

    • protection -  int
        o If the protection is below 0, throw an IllegalArgumentException with a message: "Magician protection cannot be below 0."

    • isAlive -  boolean
        o If the health is above zero.

    • magic -  Magic
        o If the magic object is null, throw a NullPointerException with a message: "Magic cannot be null."

Behavior:
    • void takeDamage(int points). The takeDamage() method decreases the Magician's protection and health. First, you need to reduce the protection.
       If the protection reaches 0, transfer the damage to health points. If the health points are less than or equal to zero, the magician is dead.
Constructor:
    • A Magician should take the following values upon initialization: String username, int health, int protection, Magic magic

Child Classes: There are two types of Magician.

Wizard:
    • The constructor should take the following values upon initialization: String username, int health, int protection, Magic magic

BlackWidow
    • The constructor should take the following values upon initialization: String username, int health, int protection, Magic magic

RegionImpl: The RegionImpl is the ground where the wizard fights happen.

Behavior:
    • String start(Collection<Magician> magicians)
        o Separates the magicians into two types - Wizard and Black Widow. The game continues until one of the teams is completely dead (all magicians have 0 health).
	Both magician groups take a turn shooting at each other – first is the Wizards, then the Black Widows inflict damage equal to their bullet fired from their Magic.
	Make sure the Magician has enough bullets before he/she tries to attack! The damage they deal comes from each magic property of each Magician.
	If Wizards win return "Wizards win!" otherwise return "Black widows win!"

MagicRepositoryImpl: The magic repository is a repository for all magics in the game.
Data:
    • data - a Collection of magics

Behavior:

    • void addMagic(Magic magic)
        o If the magic is null, throw a NullPointerException with a message: "Cannot add null in Magic Repository."
        o Adds magic to the collection.
    • boolean removeMagic(Magic magic)
        o Removes magic from the collection. Returns true if the removal was successful, otherwise - false.
    • Magic findByName(String name)
        o Returns the first magic with the given name, if there is such a magic. Otherwise, returns null.

MagicianRepositoryImpl: The magician repository is a repository for all magicians in the game.
Data:
    • data - a collection of magicians

Behavior:
    • void addMagician(Magician magician)
        o If the magician is null, throw a NullPointerException with a message: "Cannot add null in Magician Repository.".
        o Adds a magician to the collection.
    • boolean removeMagician(Magician magician)
        o Removes a magician from the collection. Returns true if the removal was successful, otherwise - false.
    • Magician findByName(String name)
        o Returns the first magician with the given username, if there is such a magician. Otherwise, returns null.


The Controller Class:
The business logic of the program should be concentrated around several commands. You are given interfaces that you must implement in the correct classes.
Note: The ControllerImpl class SHOULD NOT handle exceptions! The tests are designed to expect exceptions, not messages!
The first interface is Controller. You must create a ControllerImpl class, which implements the interface and implements all its methods. The given methods should have the following logic:

Data:
You need to keep track of some things; this is why you need some private fields in your controller class:
    • magics - MagicRepositoryImpl
    • magicians – MagicianRepositoryImpl
    • region - Region

Commands:
There are several commands, which control the business logic of the application. They are stated below.

    • AddMagic Command (type - String, name - String, bulletsCount - int)
        o Adds a Magic and adds it to the MagicRepositoryImpl. Valid types are "RedMagic" and "BlackMagic".
        o If the Magic type is invalid, you have to throw an IllegalArgumentException with the following message: "Invalid magic type!"
        o If the Magic is added successfully, the method should return the following String: "Successfully added magic {magicName}."

    • AddMagician Command (type – String, username – String, health – int, protection – int, magicName – String)
        o Creates a Magician of the given type and adds it to the MagicianRepositoryImpl. Valid types are: "Wizard" and "BlackWidow".
        o If the magic is not found throw NullPointerException with a message: "Magic cannot be found!"
        o If the magician type is invalid, throw an IllegalArgumentException with the message: "Invalid magician type!"
        o The method should return the following String if the operation is successful: "Successfully added magician {username}."

    • StartGame Command
        o The game starts with all magicians that are alive! Returns the result from the start() method.

    • Report Command
        o Returns information about each magician separated with a new line. Order then by health ascending, then by username alphabetically, then by type alphabetically.
		You can use the overridden .toString() Magician method.
			"{magician type}: {magician username}
			Health: {magician health}
			Protection: {magician protection}
			Magic: {magician magic name}"

Input / Output:
You are provided with one interface, which will help with the correct execution process of your program.
The interface is Engine and the class implementing this interface should read the input and when the program finishes, this class should print the output.
The Main method is complete. Do not add anything to it.

Input:

Below, you can see the format in which each command will be given in the input:
    • AddMagic {type} {name} {bulletsCount}
    • AddMagician {type} {username} {health} {protection} {magicName}
    • StartGame
    • Report
    • Exit

Output: Print the output from each command when issued. If an exception is thrown during any of the commands' execution, print the exception message. */

    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
