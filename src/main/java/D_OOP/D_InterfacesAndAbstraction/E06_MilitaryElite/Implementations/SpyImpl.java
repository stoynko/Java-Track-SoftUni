package D_OOP.D_InterfacesAndAbstraction.E06_MilitaryElite.Implementations;

import D_OOP.D_InterfacesAndAbstraction.E06_MilitaryElite.Interfaces.*;

public class SpyImpl extends SoldierImpl implements Spy {

    private String codeNumber;

    public SpyImpl(String firstName, String lastName, int id, String codeNumber) {
        super(firstName, lastName, id);
        this.codeNumber = codeNumber;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %d\n", getFirstName(), getLastName(), getId() + "Code Number: %s\n", this.codeNumber);
    }

    @Override
    public String getCodeNumber() {
        return this.codeNumber;
    }
}
