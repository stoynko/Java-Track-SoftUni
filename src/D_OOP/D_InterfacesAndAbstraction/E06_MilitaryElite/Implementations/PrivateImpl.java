package D_OOP.D_InterfacesAndAbstraction.E06_MilitaryElite.Implementations;
import D_OOP.D_InterfacesAndAbstraction.E06_MilitaryElite.Interfaces.*;

public class PrivateImpl extends SoldierImpl implements Private {

    private double salary;

    public PrivateImpl(String firstName, String lastName, int id, double salary) {
        super(firstName, lastName, id);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public int getId() {
        return super.getId();
    }
}
