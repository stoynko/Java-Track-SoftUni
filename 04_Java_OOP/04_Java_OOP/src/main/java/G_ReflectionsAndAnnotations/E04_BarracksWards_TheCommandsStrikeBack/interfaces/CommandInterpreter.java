package G_ReflectionsAndAnnotations.E04_BarracksWards_TheCommandsStrikeBack.interfaces;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
