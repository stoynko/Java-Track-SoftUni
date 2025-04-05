package D_Java_OOP.G_ReflectionsAndAnnotations.E03_BarracksWars_NewFactory;

import D_Java_OOP.G_ReflectionsAndAnnotations.E03_BarracksWars_NewFactory.interfaces.Repository;
import D_Java_OOP.G_ReflectionsAndAnnotations.E03_BarracksWars_NewFactory.interfaces.Runnable;
import D_Java_OOP.G_ReflectionsAndAnnotations.E03_BarracksWars_NewFactory.interfaces.UnitFactory;
import D_Java_OOP.G_ReflectionsAndAnnotations.E03_BarracksWars_NewFactory.core.Engine;
import D_Java_OOP.G_ReflectionsAndAnnotations.E03_BarracksWars_NewFactory.core.factories.UnitFactoryImpl;
import D_Java_OOP.G_ReflectionsAndAnnotations.E03_BarracksWars_NewFactory.data.UnitRepository;

public class Main {

/*You are given a small console-based project called Barracks (the code for it is included in the provided skeleton).
The general functionality of the project is adding new units to its repository and printing a report with statistics about the units currently in the repository.
First, let's go over the original task before the project was created:

Input:
The input consists of commands each on a separate line. Commands that execute the functionality are:
    •	add {Archer/Swordsman/Pikeman/{…}} - adds a unit to the repository
    •	report - prints a lexicological ordered statistic about the units in the repository
    •	fight - ends the input
Output
Each command except fight should print output on the console.
    •	add should print: "{Archer/Swordsman/Pikeman/{…}} added!"
    •	report should print all the info in the repository in the format: "{UnitType} -> {UnitQuantity}", sorted by UnitType
Constraints
    •	Input will consist of no more than 1000 lines.
    •	report command will never be given before any valid add command was provided.
Your Task
1) You have to study the code of the project and figure out how it works. However, there are parts of it that are not implemented (left with TODOs).
You must implement the functionality of the createUnit method in the UnitFactoryImpl class so that it creates a unit based on the unit type received as a parameter.
Implement it in such a way that whenever you add a new unit it will be creatable without the need to change anything in the UnitFactoryImpl class (psst - use reflection).
You can use the approach called Simple Factory.
2) Add two new unit classes (there will be tests that require them) - Horseman with 50 health and 10 attacks and Gunner with 20 health and 20 attacks.

If you do everything correctly for this problem, you should write code only in the factories and units packages. */

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
