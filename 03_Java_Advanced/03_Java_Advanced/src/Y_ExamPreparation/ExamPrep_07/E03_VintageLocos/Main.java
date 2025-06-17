package Y_ExamPreparation.ExamPrep_07.E03_VintageLocos;

public class Main {

/*Locomotive: First, write a class Locomotive with the following properties:
    •	name: String
    •	builder: String
    •	buildDate: LocalDate
    •	gauge: int
    •	weight: int
    •	maxSpeed: int
The class constructor should receive name, builder, buildDate, gauge, weight and maxSpeed. You need to create the appropriate getters and setters.
All locomotive names will be unique. It is guaranteed that there will be no duplicates of names.

Override the toString() method in the following format:
    o	"This {locomotive name} is made by {locomotive builder} at {locomotive build date in the format "dd.MM.yyyy"}."

TrainStation: Next, write a class TrainStation. The TrainStation class should have those properties:
    •	name: String
    •	capacity: int
    •	railGauge: int
    •	locomotives: List<Locomotive>

The class constructor should receive name, capacity and railGauge. Also, it should initialise the locomotives with a new collection instance. Implement the following features:
    •	Method addLocomotive(Locomotive locomotive) – adds an entity to the collection of locomotives if there is a space for it and if the rail gauge of the station matches
        the gauge of the locomotive, otherwise print: "This train station is full!"
        If the rail gauge of the station does not match the gauge of the locomotive print: "The rail gauge of this station does not match the locomotive gauge!
        Difference: {the difference between the station gauge and the locomotive gauge in absolute value} mm."
    •	Method getLocomotive(String name) – returns the locomotive with the given name, otherwise – returns null
    •	Method getCount() – returns the count of locomotives in the given train station
    •	Method getOldestLocomotive() – returns String – the name of the oldest Locomotive in the given train station. Otherwise print:
        "There are no locomotives."
    •	Method getStatistics() – returns a String in the following format (print the locomotives in order of addition):
        "Locomotives departed from {tain station name}:
        1. {locomotive name}
        2. {locomotive name}
        (…)
        n.	{locomotive name}"
        If there are no locomotives in some train stations print only this text: "There are no locomotives departing from {rail station name} station."

Constraints:
    •	The name, build date and max speed of the locomotive will always be unique.
    •	You will always have a locomotive added before receiving methods manipulating the TrainStation's locomotive. */

    public static void main(String[] args) {

    }
}
