package D_Java_OOP.G_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.core.commands;

import D_Java_OOP.G_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.annotations.*;
import D_Java_OOP.G_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.interfaces.*;

public class ReportCommand extends Command {

    @Inject
    private Repository repository;

    public ReportCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return repository.getStatistics();
    }
}
