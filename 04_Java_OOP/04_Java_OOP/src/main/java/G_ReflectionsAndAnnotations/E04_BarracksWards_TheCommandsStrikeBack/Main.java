package G_ReflectionsAndAnnotations.E04_BarracksWards_TheCommandsStrikeBack;

import D_Java_OOP.G_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.core.commands.*;
import D_Java_OOP.G_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.interfaces.*;
import G_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.core.Engine;
import G_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.core.factories.UnitFactoryImpl;
import G_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.data.UnitRepository;
import G_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.interfaces.Runnable;

public class Main {

/*As you might have noticed commands in the project from Problem 3 are implemented via a switch case with method calls in the Engine class.
Although this approach works it is flawed when you add a new command because you have to add a new case for it. In some projects, you might not have access to the engine and this would not work.
Imagine this project will be outsourced and the outsourcing firm will not have access to the engine. Make it so whenever they want to add a new command they won't have to change anything in the Engine.
To do so employ the design pattern called Command Pattern.

Notice how all commands that extend this one will have both a Repository and a UnitFactory although not all of them need these. Leave it like this for this problem,
because for the reflection to work we need all constructors to accept the same parameters. We will see how to go around this issue in Problem 5.

Once you've implemented the pattern add a new command. It will have the following syntax:
    •	retire {UnitType} - All it has to do is remove a unit of the provided type from the repository.
        o	If there are no such units currently in the repository print: "No such units in repository."
        o	If there is such a unit currently in the repository, print: "{UnitType} retired!"

To implement this command, you will also have to implement a corresponding method in the UnitRepository.
If you do everything correctly for this problem, you should write/refactor code only in the core and data packages.*/

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();
        CommandInterpreter commandInterpreter = new CommandInterpretorImpl(repository, unitFactory);
        Runnable engine = new Engine(commandInterpreter);
        engine.run();
    }
}
