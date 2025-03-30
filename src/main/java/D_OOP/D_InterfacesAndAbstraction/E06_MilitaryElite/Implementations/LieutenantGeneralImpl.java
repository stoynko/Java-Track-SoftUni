package D_OOP.D_InterfacesAndAbstraction.E06_MilitaryElite.Implementations;
import D_OOP.D_InterfacesAndAbstraction.E06_MilitaryElite.Interfaces.*;
import java.util.*;
import java.util.stream.Collectors;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {

    List<Private> privates;

    public LieutenantGeneralImpl(String firstName, String lastName, int id, double salary) {
        super(firstName, lastName, id, salary);
        this.privates = new ArrayList<>();
    }

    @Override
    public void addPrivate (Private priv) {
        privates.add(priv);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Name: %s %s Id: %d Salary: %.2f", super.getFirstName(), super.getLastName(), super.getId(), super.getSalary()));
        output.append(System.lineSeparator());
        output.append("Privates:");

        if (!privates.isEmpty()) {
            List<Private> privatesList = privates.stream().collect(Collectors.toList());
            privatesList.sort(Comparator.comparing(Private::getId).reversed());
            output.append(System.lineSeparator());
            for (Private p : privatesList) {
                output.append("  ").append(p.toString());
                output.append(System.lineSeparator());
            }
        }

        return output.toString().trim();
    }
}
