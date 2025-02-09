package C_Advanced.Y_ExamPreparation.ExamPrep_05.E03_WorldOfTanks;

public class Main {

/*Problem description:
Your task is to create a repository that stores Tanks by creating the classes described below.

Tank: First, write a class Tank with the following properties:
    •	brand: String
    •	model: String
    •	weight: int
    •	barrelCaliber: int
    •	armor: int

The class constructor should receive the brand, model, weight, barrelCaliber and armor. You need to create the appropriate getters and setters.
All Tank's brand and model combinations should be unique. Override the toString() method in the following format:
    •	Brand: {tank brand}, Model: {tank model}, Weight: {tank weight}kg, Barrel caliber: {tank barrel caliber}mm, Armor: {tank armor thickness}mm
Terrain: Next, write a class Terrain. The Terrain class should have those properties:
    •	type: String
    •	List<Tank>: tanks
    •	area: int

The class constructor should receive type and area. Also, it should initialise the Tanks with a new collection instance. Implement the following features:
    •	Method addTank(Tank tank) – adds an entity to the collection of Tanks. If the Tank with the same combination of brand and model exists on the Terrain,
    return the following String: "Tank with this brand and model already exists!"
        o	If the Terrain type is "Swamp" and the weight of the tank you are trying to add to this Terrain is more than 14000 return the following String:	"This {tank brand} is too heavy for this terrain!"
        o	If the Tank is added successfully to the Terrain return the following String: "Tank {tank brand} {tank model} added."
    •	Method removeTank(String brand, String model) – removes a Tank by given brand and model, if such exists, and returns boolean (true if it is removed, otherwise – false)
    •	Method getTanksByBarrelCaliberMoreThan(int barrelCaliber)– returns String that lists the Tanks that meet the search criteria (with barrel caliber more than the searched one)
        in the following format: Tanks with caliber more than {barrel caliber}mm: {Tank brand1}, {Tank brand2}, …{Tank brandN}"
        o	If there are no Tanks matching the requested caliber on the Terrain, return: "There are no tanks with the specified caliber."
    •	Method getTankByBrandAndModel(String brand, String model) – returns the matching Tank, if such exists, otherwise – returns null.
    •	Method getTheMostArmoredTank() – returns String –  the tank with the thickest armor in the following format:
        "{tank brand} {tank model} is the most armored tank with {armor thickness}mm. armor thickness."
    •	Method getCount() – returns the count of Tanks on the given Terrain.
    •	Method getStatistics() – returns a String in the following format (print the Tanks in order of addition):
            "Tanks located in the {terrain type (lowercased)}:
            -- {tank brand1} {tank model1}
            -- {tank brand2} {tank model2}
            (…)
            -- {tank brandN} {tank modelN}"
        o	If there are no Tanks on some of the Terrains print only this text: "There are no tanks in the {terrain type (lowercased)}."

Constraints:
    •	You will always have a Tank added before receiving methods manipulating the Terrain's tanks. */

    public static void main(String[] args) {

    }
}
