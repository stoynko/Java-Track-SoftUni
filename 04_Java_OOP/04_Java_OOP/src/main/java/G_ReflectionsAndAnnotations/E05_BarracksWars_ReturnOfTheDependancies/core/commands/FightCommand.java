package G_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.core.commands;

public class FightCommand extends Command {

    public FightCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return "fight";
    }
}
