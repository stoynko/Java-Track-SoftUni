package D_Java_OOP.G_ReflectionsAndAnnotations.E04_BarracksWards_TheCommandsStrikeBack.core.commands;

import D_Java_OOP.G_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.interfaces.*;

public class FightCommand extends Command {

    public FightCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return "fight";
    }
}
