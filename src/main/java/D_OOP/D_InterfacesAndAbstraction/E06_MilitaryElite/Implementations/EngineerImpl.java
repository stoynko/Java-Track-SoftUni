package D_OOP.D_InterfacesAndAbstraction.E06_MilitaryElite.Implementations;
import D_OOP.D_InterfacesAndAbstraction.E06_MilitaryElite.Enums.*;
import D_OOP.D_InterfacesAndAbstraction.E06_MilitaryElite.Interfaces.*;
import java.util.*;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {

    private List<RepairImpl> repairs;

    public EngineerImpl(String firstName, String lastName, int id, double salary, Corp corp) {
        super(firstName, lastName, id, salary, corp);
        this.repairs = new ArrayList<>();
    }

    @Override
    public void addRepair(RepairImpl repair) {
        this.repairs.add(repair);
    }

    @Override
    public Collection<RepairImpl> getRepairs() {
        return Collections.unmodifiableCollection(this.repairs);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        output.append(String.format("Name: %s %s Id: %d Salary: %.2f", super.getFirstName(), super.getLastName(), super.getId(), super.getSalary()));
        output.append(System.lineSeparator());
        output.append(String.format("Corps: %s", super.getCorp()));
        output.append(System.lineSeparator());
        output.append("Repairs:");
        output.append(System.lineSeparator());

        for (RepairImpl repair : repairs) {
            output.append("  ").append(repair.toString());
            output.append(System.lineSeparator());
        }

        return output.toString().trim();
    }
}
