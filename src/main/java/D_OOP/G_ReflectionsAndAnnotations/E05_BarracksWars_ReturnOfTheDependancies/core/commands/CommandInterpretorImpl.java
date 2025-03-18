package D_OOP.G_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.core.commands;

import D_OOP.G_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.annotations.*;
import D_OOP.G_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.interfaces.*;
import D_OOP.G_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.interfaces.Executable;

import java.lang.reflect.*;

public class CommandInterpretorImpl implements CommandInterpreter {

    private Repository repository;
    private UnitFactory unitFactory;
    public final static String COMMAND_PACKAGE = "D_OOP.G_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.core.commands.";

    public CommandInterpretorImpl(Repository repository, UnitFactory unitFactory) {
        this.unitFactory = unitFactory;
        this.repository = repository;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {
        String className = parseCommandToClassName(commandName);
        Executable command = null;
        try {
            Class commandClass = Class.forName(className);
            Constructor<Command> commandConstructor = commandClass.getDeclaredConstructors()[0];
            command = commandConstructor.newInstance(new Object[]{data});
            inject(command, commandClass);
        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return command;
    }

    private void inject(Executable command, Class commandClass) throws IllegalAccessException {
        Field[] fields = commandClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                if (field.getType().equals(Repository.class)) {
                    field.setAccessible(true);
                    field.set(command, repository);
                } else if (field.getType().equals(UnitFactory.class)) {
                    field.setAccessible(true);
                    field.set(command, unitFactory);
                }
            }
        }
    }

    private String parseCommandToClassName (String commandName) {
        return COMMAND_PACKAGE + Character.toUpperCase(commandName.charAt(0)) + commandName.substring(1) + "Command";
    }
}
