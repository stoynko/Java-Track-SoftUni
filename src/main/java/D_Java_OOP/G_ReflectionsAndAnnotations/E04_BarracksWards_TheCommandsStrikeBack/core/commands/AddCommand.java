package D_Java_OOP.G_ReflectionsAndAnnotations.E04_BarracksWards_TheCommandsStrikeBack.core.commands;

import D_Java_OOP.G_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.interfaces.*;

public class AddCommand extends Command {

    public AddCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];
        Unit unitToAdd = getUnitFactory().createUnit(unitType);
        this.getRepository().addUnit(unitToAdd);
        return unitType + " added!";
    }
}
