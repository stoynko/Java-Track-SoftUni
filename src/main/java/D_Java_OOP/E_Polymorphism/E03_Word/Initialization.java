package D_Java_OOP.E_Polymorphism.E03_Word;


public class Initialization {

    public static CommandInterface buildCommandInterface(StringBuilder text) {
        CommandInterface commandInterface = new CommandImpl(text);
        commandInterface.init();
        return commandInterface;
    }
}
