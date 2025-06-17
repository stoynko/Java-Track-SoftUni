package G_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.core.commands;

import D_Java_OOP.G_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.annotations.*;
import D_Java_OOP.G_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.interfaces.*;

public class RetireCommand extends Command {

    @Inject
    private Repository repository;

    protected RetireCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        try {
            String unitType = getData()[1];
            repository.removeUnit(unitType);
            return unitType + " retired!";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}
