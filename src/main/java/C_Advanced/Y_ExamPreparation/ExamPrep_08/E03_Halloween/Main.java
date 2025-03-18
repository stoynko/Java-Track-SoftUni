package C_Advanced.Y_ExamPreparation.ExamPrep_08.E03_Halloween;

public class Main {

/*Problem description
Your task is to create a repository that stores items by creating the classes described below.
Kid : First, write a Java class Kid with the following fields:
    •	name: String
    •	age: int
    •	street: String
The class constructor should receive a name, an age, and the street it’s from. You need to create the appropriate getters and setters.
The class should override the toString() method in the following format: "{name}, {age} years old, from {street}"

House: Next, write a Java class House with data (a collection that stores the Kids). All entities inside the repository have the same fields.
Also, the House class should have those fields:
    •	capacity: int
    •	data: List<Kid>
The class constructor should receive capacity. Also, it should initialize the data with a new collection instance.
Implement the following features:
    •	Method addKid(Kid kid) – adds an entity to the data if there is an empty space for the kid.
    •	Method removeKid(String name) – removes the kid by given name, if such exists, and returns boolean.
    •	Method getKid(String street) – returns the kid of a given street or null if no such kid exists.
    •	Getter getAllKids() – returns the number of kids.
    •	getStatistics() – returns a String in the following format:
            " Children who visited a house for candy:
		    {name} from {street} street
            {name} from {street} street
            (…)"
Constraints:
    •	The age of the kids will always be a positive number. */

    public static void main(String[] args) {

    }
}
