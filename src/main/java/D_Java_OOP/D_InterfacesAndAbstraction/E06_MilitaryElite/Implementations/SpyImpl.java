package D_Java_OOP.D_InterfacesAndAbstraction.E06_MilitaryElite.Implementations;
import D_Java_OOP.D_InterfacesAndAbstraction.E06_MilitaryElite.Interfaces.*;

public class SpyImpl extends SoldierImpl implements Spy {

    private String codeNumber;

    public SpyImpl(String firstName, String lastName, int id, String codeNumber) {
        super(firstName, lastName, id);
        this.codeNumber = codeNumber;
    }

    @Override
    public String getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Name: %s %s Id: %d", getFirstName(), getLastName(), getId())).append(System.lineSeparator());
        output.append(String.format("Code Number: %s", this.codeNumber));
        return output.toString().trim();
    }
}
