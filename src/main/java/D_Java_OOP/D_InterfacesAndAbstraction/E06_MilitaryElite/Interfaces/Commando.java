package D_Java_OOP.D_InterfacesAndAbstraction.E06_MilitaryElite.Interfaces;
import D_Java_OOP.D_InterfacesAndAbstraction.E06_MilitaryElite.Implementations.*;
import java.util.*;

public interface Commando {
    void addMission(MissionImpl mission);
    Collection<MissionImpl> getMissions();
}
