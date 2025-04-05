package C_Java_Advanced.Y_ExamPreparation.ExamPrep_01.E03_Geoglyphs;

public class Main {

/*Problem description: Your task is to create a repository that stores Geoglyphs by creating the classes described below.
Geoglyph: First, write a class Geoglyph with the following properties:
    •	name: String
    •	shape: String
    •	size: int
    •	constructionTechnique: String

The class constructor should receive the name, shape, size and constructionTechnique. You need to create the appropriate getters and setters. All Geoglyph's names will be unique.
Override the toString() method in the following format: {geoglyph name} is {geoglyph size} meters long and is made by {geoglyph constructionTechnique}.

Location: The Location class, located in the geoglyphs package, should have the following properties:
    •	name: String
    •	geoglyphs: Collection<Geoglyph>
The class constructor should receive a name. Also, it should initialise the geoglyphs with a new collection instance. Implement the following features:
    •	Method addGeoglyph(Geoglyph geoglyph) – adds an entity to the collection of Geoglyph. If the Geoglyph with the same name exists in the Location,
        throw a new IllegalArgumentException with the following message:
            o	"This geoglyph exists in the location!"
If the Geoglyph is added successfully to the Location return the following String: "{geoglyph name} added to {location name}."
    •	Method removeGeoglyph(String name) – removes a Geoglyph by given name, if such exists, and returns boolean (true if it is removed, otherwise – false)
    •	Method getGeoglyphsByConstructionTechnique(String constructionTechnique)– returns String that lists all matching geoglyphs, in the following format:
        "Geoglyphs made by {constructionTechnique}: {geoglyph name1}, {geoglyph name2}, …{geoglyph namen}"
        If there are no geoglyphs that meet the search criteria in the given Location, return:
        "There are no geoglyphs made by {constructionTechnique} in this location."
    •	Method getLargestGeoglyph() – returns String –  the Geoglyph with the biggest size in the following format: "The largest geoglyph is {geoglyph name} with a length of {geoglyph size} meters."
    •	Method getGeoglyphByName(String name) – returns the matching Geoglyph, if such exists, otherwise – returns null.
    •	Method getCount() – returns the count of geoglyphs in the given Location.
    •	Method getStatistics() – returns a String in the following format (print the Geoglyphs in order of addition):
        o	"Geoglyphs located in {location name}:
            * {geoglyph name1}
            * {geoglyph name2}
            (…)
            * {geoglyph namen}"

If there are no geoglyphs in some of the locations print only this text: "No geoglyphs have yet been discovered in {location name}."

Constraints:
    •	You will always have a Geoglyph added before receiving methods manipulating the Location's Geoglyphs.*/

    public static void main(String[] args) {

    }
}
