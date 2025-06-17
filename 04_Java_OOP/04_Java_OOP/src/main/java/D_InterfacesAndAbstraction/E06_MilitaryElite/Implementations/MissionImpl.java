package D_InterfacesAndAbstraction.E06_MilitaryElite.Implementations;
import D_InterfacesAndAbstraction.E06_MilitaryElite.Enums.MissionState;
import D_Java_OOP.D_InterfacesAndAbstraction.E06_MilitaryElite.Interfaces.*;

public class MissionImpl implements Mission {

    private String codeName;
    MissionState state;

    public MissionImpl(String codeName, MissionState state) {
        this.codeName = codeName;
        this.state = state;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public void setState(String state) {
        this.state = MissionState.valueOf(state);
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    @Override
    public String getState() {
        return this.state.toString();
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.codeName, this.state);
    }
}
