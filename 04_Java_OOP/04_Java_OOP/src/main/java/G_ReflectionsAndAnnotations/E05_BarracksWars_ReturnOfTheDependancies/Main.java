package G_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies;

import D_Java_OOP.G_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.core.commands.*;
import D_Java_OOP.G_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.interfaces.*;
import G_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.core.Engine;
import G_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.core.factories.UnitFactoryImpl;
import G_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.data.UnitRepository;
import G_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.interfaces.Runnable;

public class Main {

/*In the final part of this epic problem trilogy, we will resolve the issue where all Commands received all utility classes as parameters in their constructors.
We can accomplish this by using an approach called dependency injection container. This approach is used in many frameworks like Spring for instance.
We will do a little twist on that approach. Remove all fields from the abstract command except the data. Instead, put whatever fields each command needs in the concrete class.
Create an annotation called Inject and make it so it can be used only on fields. Put the annotation over the fields we need to set through reflection.
Once you've prepared all of this, write the necessary reflection code in the Command Interpreter (which you should have refactored out from the engine in Problem 4). */

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();
        CommandInterpreter commandInterpreter = new CommandInterpretorImpl(repository, unitFactory);
        Runnable engine = new Engine(commandInterpreter);
        engine.run();
    }
}
