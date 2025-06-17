package Y_ExamPreparation.ExamPrep_09.E03_Spacecraft;


public class Main {

/*our task is to create a repository that stores spacecraft by creating the classes described below.
Spacecraft:
First, write a class Spacecraft with the following properties:
•	name: String
•	missionType: String
•	target: String
•	objective: String
•	weight: int
The class constructor should receive name, missionType, target, objective and weight. You need to create the appropriate getters and setters.
All spacecraft names will be unique. It is guaranteed that there will be no duplicates of names. Override the toString() method in the following format:
•	The mission of {name} was to reach {target} and to {objective}

LaunchPad:
Next, write a class LaunchPad. The LaunchPad class should have those properties:
    •	name: String
    •	capacity: int
    •	spacecrafts: List<Spacecraft>
The class constructor should receive name and capacity. Also, it should initialise the spacecrafts with a new collection instance.
Implement the following features:
    •	Method addSpacecraft(Spacecraft spacecraft) – adds an entity to the data if a space for it, otherwise print: "This launchpad is at full capacity!"
    •	Method removeSpacecraft(String name) – removes a Spacecraft by given name, if such exists, and returns boolean
        (true if it is removed, otherwise – false)
    •	Method getHeaviestSpacecraft()– returns String the heaviest spacecraft by weight in the given launchpad in the following format:
        o	"{spaceCraft name} - {spaceCraft weight}kg."
    •	Method getSpacecraft(String name) – returns the spacecraft with the given name, otherwise – returns null
    •	Method getCount() – returns the count of spacecrafts in the given launchpad
    •	Method getSpacecraftsByMissionType(String missionType) – returns List – a collection of Spacecraft which holds the spacecrafts having the
        same missionType in the given launchpad. In case there are no spacecrafts to respond to this condition (missionType) print:
        o	"There are no spacecrafts to respond this criteria."
    •	Method getStatistics() – returns a String in the following format (print the spacecrafts in order of addition):
        o	"Spacecrafts launched from {launchpad name}:
            1. {spacecraft name}
            2. {spacecraft name}
               (…)
            n.	{spacecraft name}"
        If there are no spacecrafts in some launchpad print:
        o	"Spacecrafts launched from {launchpad name}: none"

Constraints:
    •	The name and weight of the spacecraft will always be unique.
    •	You will always have a spacecraft added before receiving methods manipulating the Launchpad's spacecraft. */

    public static void main(String[] args) {

    }
}