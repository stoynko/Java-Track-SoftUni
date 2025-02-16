package C_Advanced.Z_Exam.E03_MajesticShips;

public class Main {

/*Your task is to create a repository that stores Ships by creating the classes described below.
Ship
First, write a class Ship with the following properties:
    •	name: String
    •	type: String
    •	tonnage: int
    •	draft: int
The class constructor should receive the name, type, tonnage and draft. You need to create the appropriate getters and setters.
Override the toString() method in the following format:
    •	"Name: {ship name}, Type: {ship type}, Tonnage: {ship tonnage} tons, Draft: {ship draft} meters."

Harbor
Next, write a class Harbor. The Harbor class should have those properties:
    •	location: String
    •	minDepth: int
    •	List<Ship>: ships
The class constructor should receive location and minDepth. Also, it should initialise the Ships with a new collection instance.

Implement the following features:
    •	Method addShip(Ship ship) – adds an entity to the collection of Ships in the Harbor.
            o	If the Ship with the same name exists in the Harbor, return the following String: "Ship with this name already exists!"
            o	If the ship's draft exceeds the harbor's minimal depth, return the following String: "The ship {ship name} cannot dock due to draft limitations!"
            o	If the Ship is added successfully to the Harbor return the following String: "Ship {ship name} added to the harbor."
    •	Method removeShip(String name) – removes a Ship by given name, if such exists, and returns boolean (true if it is removed, otherwise – false)
    •	Method getShipsByType(String type)– returns String a list of Ships that match the searched type, print on one row in the following format:
            o	"Ships of type {ship type}: {ship1 name}, {ship2 name}, …{shipn name}"
        If no ships match, return:
            o	"There are no ships of the requested type."
    •	Method getShipByName(String name) – returns the Ship object if found, otherwise – returns null.
    •	Method getLargestShip() – returns String –  describing the largest Ship by tonnage in the following format:
            o	"{ship name} is the largest ship with a tonnage of {ship tonnage} tons."
        If there are no Ships print:
            o	"No ships in the harbor."
    •	Method getCount() – returns the count of Ships in the given Harbor.
    •	Method getStatistics() – returns a String in the following format (print the Ships in order of addition):
        o	"Ships docked in {harbor location}:
            * {ship1 name}
            * {ship1 name}
            (…)
            * {shipn name}"

If there are no Ships in some of the Harbors print:
        o	"No ships docked in {harbor location}."

Constraints:
    •	You will always have a Ship added before receiving methods manipulating the Harbor's Ships. */

    public static void main(String[] args) {

    }
}
