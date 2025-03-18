package D_OOP.D_InterfacesAndAbstraction.E06_MilitaryElite.Implementations;
import D_OOP.D_InterfacesAndAbstraction.E06_MilitaryElite.Interfaces.*;
import java.util.*;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {

    HashSet<RepairImpl> repairs;

    public EngineerImpl(String firstName, String lastName, int id, double salary, String corp) {
        super(firstName, lastName, id, salary, corp);
        this.repairs = new HashSet<>();
    }

    @Override
    public void addRepair(RepairImpl repair) {
        this.repairs.add(repair);
    }

    @Override
    public Collection<RepairImpl> getRepairs() {
        return Collections.unmodifiableCollection(this.repairs);
    }
}
