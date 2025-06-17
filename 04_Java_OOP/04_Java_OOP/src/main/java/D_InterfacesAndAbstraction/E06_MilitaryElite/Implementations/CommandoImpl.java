package D_InterfacesAndAbstraction.E06_MilitaryElite.Implementations;
import D_Java_OOP.D_InterfacesAndAbstraction.E06_MilitaryElite.Enums.*;
import D_Java_OOP.D_InterfacesAndAbstraction.E06_MilitaryElite.Interfaces.*;
import java.util.*;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {

    private List<MissionImpl> missions;

    public CommandoImpl(String firstName, String lastName, int id, double salary, Corp corp) {
        super(firstName, lastName, id, salary, corp);
        this.missions = new ArrayList<>();
    }

    @Override
    public void addMission(MissionImpl mission) {
        missions.add(mission);
    }

    @Override
    public Collection<MissionImpl> getMissions() {
        return Collections.unmodifiableCollection(this.missions);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        output.append(String.format("Name: %s %s Id: %d Salary: %.2f", getFirstName(), getLastName(), getId(), getSalary()));
        output.append(System.lineSeparator());
        output.append(String.format("Corps: %s", getCorp()));
        output.append(System.lineSeparator());
        output.append("Missions:");
        for (MissionImpl mission : missions) {
            output.append(System.lineSeparator());
            output.append("  ").append(mission.toString());
        }
        return output.toString().trim();
    }
}
