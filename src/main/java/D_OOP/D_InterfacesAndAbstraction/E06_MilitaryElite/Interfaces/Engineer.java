package D_OOP.D_InterfacesAndAbstraction.E06_MilitaryElite.Interfaces;
import D_OOP.D_InterfacesAndAbstraction.E06_MilitaryElite.Implementations.*;
import java.util.*;

public interface Engineer {
    void addRepair(RepairImpl repair);
    Collection<RepairImpl> getRepairs();
}
