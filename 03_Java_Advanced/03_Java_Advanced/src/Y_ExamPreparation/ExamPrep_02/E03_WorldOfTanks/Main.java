package Y_ExamPreparation.ExamPrep_02.E03_WorldOfTanks;

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

        //Initialize the repositories
        Terrain swamp = new Terrain("Swamp", 400);
        Terrain valley = new Terrain("Valley", 1400);
        Terrain gorge = new Terrain("Gorge", 800);
        Terrain desert = new Terrain("Desert", 200);
//Initialize entities
        Tank mark = new Tank("Mark", "V", 29000, 57, 12);
        Tank renault = new Tank("Renault", "FT", 6500, 37, 22);
        Tank m4 = new Tank("M4", "Sherman", 30300, 105, 177);
        Tank tiger = new Tank("Tiger", "I", 54000, 88, 120);
        Tank schneider = new Tank("Schneider", "CA", 13600, 75, 30);

        System.out.println(swamp.addTank(mark));
//This Mark is too heavy for this terrain!
        System.out.println(swamp.addTank(renault));
//Tank Renault FT added.
        System.out.println(swamp.getTankByBrandAndModel("Renault", "FT"));
//Brand: Renault, Model: FT, Weight: 6500kg, Barrel caliber: 37mm, Armor: 22mm
        System.out.println(swamp.addTank(m4));
//This M4 is too heavy for this terrain!
        System.out.println(valley.addTank(renault));
//Tank Renault FT added.
        System.out.println(valley.addTank(tiger));
//Tank Tiger I added.
        System.out.println(valley.addTank(m4));
//Tank M4 Sherman added.
        System.out.println(valley.addTank(m4));
//Tank with this brand and model already exists!
        System.out.println(valley.getCount());
//3
        System.out.println(desert.addTank(schneider));
//Tank Schneider CA added.
        System.out.println(desert.removeTank("Panzer", "IV"));
//false
        System.out.println(desert.removeTank("Schneider", "CA"));
//true
        System.out.println(valley.getTheMostArmoredTank());
//M4 Sherman is the most armored tank with 177mm. armor thickness.
        System.out.println(valley.getTanksByBarrelCaliberMoreThan(80));
//Tanks with caliber more than 80mm: Tiger, M4
        System.out.println(swamp.getStatistics());
//Tanks located in the swamp:
//-- Renault FT
        System.out.println(valley.getStatistics());
//Tanks located in the valley:
//-- Renault F
//-- Tiger I
//-- M4 Sherman
        System.out.println(gorge.getStatistics());
//There are no tanks in the gorge.
        System.out.println(desert.getStatistics());
//There are no tanks in the desert.

    }
}
