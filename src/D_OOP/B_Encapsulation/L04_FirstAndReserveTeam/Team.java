package D_OOP.B_Encapsulation.L04_FirstAndReserveTeam;
import java.util.*;
import java.util.stream.*;

public class Team {

    private String name;
    private List<Person> firstTeam;
    private List<Person> reserveTeam;

    public Team(String name) {
        this.name = name;
        this.firstTeam = new ArrayList<>();
        this.reserveTeam = new ArrayList<>();
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer (Person person) {
        if (person.getAge() < 40) {
            this.firstTeam.add(person);
        } else {
            this.reserveTeam.add(person);
        }
    }

    public List<Person> getFirstTeam () {
        return this.firstTeam.stream().collect(Collectors.toUnmodifiableList());
    }

    public List<Person> getReserveTeam() {
        return this.reserveTeam.stream().collect(Collectors.toUnmodifiableList());
    }
}
