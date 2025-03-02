package D_OOP.D_InterfacesAndAbstraction.E06_MilitaryElite.Implementations;

import D_OOP.D_InterfacesAndAbstraction.E06_MilitaryElite.Enums.*;
import D_OOP.D_InterfacesAndAbstraction.E06_MilitaryElite.Interfaces.*;

public class SpecialisedSoldierImpl extends PrivateImpl implements Soldier {

    private Corp corp;

    public SpecialisedSoldierImpl(String firstName, String lastName, int id, double salary, String corp) {
        super(firstName, lastName, id, salary);
        setCorp(corp);
    }

    public String getCorp() {
        return this.corp.toString();
    }

    public void setCorp(String corp) {
        try {
            this.corp = Corp.valueOf(corp);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid corp!");
        }
    }
}
