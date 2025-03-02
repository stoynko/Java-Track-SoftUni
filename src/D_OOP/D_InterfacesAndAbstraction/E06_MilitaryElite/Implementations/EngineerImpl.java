package D_OOP.D_InterfacesAndAbstraction.E06_MilitaryElite.Implementations;
import java.util.*;

public class EngineerImpl extends SpecialisedSoldierImpl{

    HashSet<RepairImpl> repairs;

    public EngineerImpl(String firstName, String lastName, int id, double salary, String corp) {
        super(firstName, lastName, id, salary, corp);
        this.repairs = new HashSet<>();
    }

    public void addRepair(RepairImpl repair) {
        this.repairs.add(repair);
    }

    public Collection<RepairImpl> getRepairs() {
        return Collections.unmodifiableCollection(this.repairs);
    }
}
