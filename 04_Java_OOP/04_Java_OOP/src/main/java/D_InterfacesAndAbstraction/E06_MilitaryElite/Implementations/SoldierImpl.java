package D_InterfacesAndAbstraction.E06_MilitaryElite.Implementations;
import D_Java_OOP.D_InterfacesAndAbstraction.E06_MilitaryElite.Interfaces.*;

public class SoldierImpl implements Soldier {

    private String firstName;
    private String lastName;
    private int id;

    public SoldierImpl(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public int getId() {
        return this.id;
    }
}
