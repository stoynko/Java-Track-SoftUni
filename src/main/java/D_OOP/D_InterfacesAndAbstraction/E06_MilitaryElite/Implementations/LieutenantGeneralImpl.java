package D_OOP.D_InterfacesAndAbstraction.E06_MilitaryElite.Implementations;
import D_OOP.D_InterfacesAndAbstraction.E06_MilitaryElite.Interfaces.*;
import java.util.*;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {

    HashSet<PrivateImpl> privates = new HashSet<>();

    public LieutenantGeneralImpl(String firstName, String lastName, int id, double salary) {
        super(firstName, lastName, id, salary);
        this.privates = new HashSet<>();
    }

    @Override
    public void addPrivate (PrivateImpl priv) {
        privates.add(priv);
    }
}
