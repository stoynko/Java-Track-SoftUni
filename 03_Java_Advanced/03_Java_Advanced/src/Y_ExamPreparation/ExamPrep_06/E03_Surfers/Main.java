package Y_ExamPreparation.ExamPrep_06.E03_Surfers;

public class Main {

/*Surfer
First, write a class Surfer with the following properties:
    •	name: String
    •	age: int
    •	experience: int
    •	ownsASurfBoard: Boolean (note that it must be a Boolean not boolean)
    •	money: int

The class constructor should receive the name, age, experience, ownsASurfBoard, and money. You need to create the appropriate getters and setters. All Surfer names will be unique.
It is guaranteed that there will be no duplicates of names.
Override the toString() method in the following format:
    o	"Surfer {surfer name} is {surfer age} years old and has {surfer experience} years surfing experience."

Beach:
Next, write a class Beach. The Beach class should have those properties:
    •	name: String
    •	surfboardsForRent: int
    •	surfers: List<Surfer>
The class constructor should receive name, and surfboardsForRent. Also, it should initialise the Surfers with a new collection instance. Implement the following features:
    •	Method addSurfer(Surfer surfer) – adds an entity to the collection of surfers if the surfer has his surfboard or he has enough money to rent it.
        If the surfer does not have his surfboard, the beach offers the possibility to rent a surfboard for 50 units of money. If a surfboard is rented,
        the total number of surfboards for rent on the given beach decreases by one. If the surfer does not have enough money to rent a surfboard return the following String:
        o	"{surfer name} has not enough money to rent a surfboard."
            o	If the surfboards on this beach have run out return the following String:
        o	"There are no free surfboards."
            o	If the surfer is added successfully to the beach return the following String:
        o	"Surfer {surfer name} added."
    •	Method removeSurfer(String name) – removes a Surfer by given name, if such exists, and returns boolean (true if it is removed, otherwise – false)
    •	Method getMostExperiencedSurfer()– returns String - the most experienced Surfer by age of experience in the given beach return: "{surfer name} is most experienced surfer with {surfer experience} years experience."
        If there are no surfers on the beach, return:
        o	"There are no surfers."
    •	Method getSurfer(String name) – returns the Surfer with the given name, otherwise – returns null
    •	Method getCount() – returns the count of Surfers in the given beach
    •	Method getSurfersWithPersonalSurfboards() – returns String –  returns the list of surfers in the given beach who have their surfboards in the following format:
        o	"Surfers who have their own surfboards: {surfer name1}, {surfer name2}, …{surfer namen}". If there are no surfers on the beach, return: "There are no surfers."
    •	Method getReport() – returns a String in the following format (print the Surfers in order of addition):
        o	"Beach {beach name} was visited by the following surfers:
            1. {surfer name} with {surfer experience} years experience.
            2. {surfer name} with {surfer experience} years experience.
               (…)
            n.	{surfer name} with {surfer experience} years experience."
        If the surfer has 0 years of experience return:
            n. {surfer name} with no experience.

If there are no Surfers on some beaches print only this text:
    o	"There are no surfers on {beach name} beach."

Constraints:
    •	The name of the Surfer will always be unique.
    •	You will always have a Surfer added before receiving methods manipulating the Beach's surfers.*/

    public static void main(String[] args) {

    }
}
