package D_OOP.D_InterfacesAndAbstraction.E06_MilitaryElite.Implementations;

public class PrivateImpl extends SoldierImpl {

    private double salary;

    public PrivateImpl(String firstName, String lastName, int id, double salary) {
        super(firstName, lastName, id);
        this.salary = salary;
    }

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
