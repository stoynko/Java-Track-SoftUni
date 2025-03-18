package D_OOP.D_InterfacesAndAbstraction.E06_MilitaryElite.Implementations;
import D_OOP.D_InterfacesAndAbstraction.E06_MilitaryElite.Interfaces.*;
import java.util.*;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {

    HashSet<MissionImpl> missions;

    public CommandoImpl(String firstName, String lastName, int id, double salary, String corp) {
        super(firstName, lastName, id, salary, corp);
    }

    @Override
    public void addMission(MissionImpl mission) {
        missions.add(mission);
    }

    @Override
    public Collection<MissionImpl> getMissions() {
        return Collections.unmodifiableCollection(this.missions);
    }
}
