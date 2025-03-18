package C_Advanced.Y_ExamPreparation.ExamPrep_04.E03_Parrots;

public class Main {

/*Problem description: Your task is to create a repository which stores departments by creating the classes described below.

Parrot -> First, write a Java class Parrot with the following fields:
    •	name: String
    •	species: String
    •	available: boolean - true by default
The class constructor should receive (name, species). The class should also have the following methods:
    •	getName()
    •	getSpecies()
    •	isAvailable()
    •	setAvailable()
    •	Override the toString() method in the format:
        "Parrot ({species}): {name}"

Cage -> Next, write a Java class Cage that has data (a collection which stores the entity Parrot).
All entities inside the repository have the same fields. Also, the Cage class should have those fields:
    •	name: String
    •	capacity: int
    •	data: List<Parrot> that holds added parrots

The class constructor should receive (name, capacity), also it should initialize the data with a new instance of the collection.
Implement the following features:
    •	getName()
    •	getCapacity()
    •	add(Parrot parrot) method - adds an entity to the data if there is room for it
    •	remove(String name) method - removes a parrot by given name, if such exists, and returns boolean
    •	sellParrot(String name) method - sell (set its available property to false without removing it from the collection) the first parrot with the given name, also return the parrot
    •	sellParrotBySpecies(String species) method - sells and returns all parrots from that species as a List
    •	count() - returns the number of parrots
    •	report() - returns a String in the following format, including only not sold parrots:
        o	"Parrots available at {cageName}:
            {Parrot 1}
            {Parrot 2}
            (…)"
Constraints:
    •	The names of the parrots will be always unique.
    •	You will always have a parrot added before receiving methods manipulating the Cage’s parrots. */

    public static void main(String[] args) {
        
    }
}
