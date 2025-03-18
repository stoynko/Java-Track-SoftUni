package D_OOP.D_InterfacesAndAbstraction.E06_MilitaryElite;

import D_OOP.D_InterfacesAndAbstraction.E06_MilitaryElite.Implementations.*;

public class Main {

    public static void main(String[] args) {

        SoldierImpl soldier = new SoldierImpl("Pesho", "Ot Zapasa", 315);
        PrivateImpl privaat = new PrivateImpl("Gosho", "Ne ot zapasa", 53, 150.50);
        LieutenantGeneralImpl general = new LieutenantGeneralImpl("Bosa", "na Kompleksa", 1, 500.10);

    }
}
