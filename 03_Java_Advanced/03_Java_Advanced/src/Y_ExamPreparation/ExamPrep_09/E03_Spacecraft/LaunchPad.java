package Y_ExamPreparation.ExamPrep_09.E03_Spacecraft;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LaunchPad {

    private String name;
    private int capacity;
    private List<Spacecraft> spacecrafts;

    public LaunchPad(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.spacecrafts = new ArrayList<>();
    }

    public void addSpacecraft(Spacecraft spacecraft) {

        if (this.spacecrafts.size() < this.capacity) {
            this.spacecrafts.add(spacecraft);
        } else {
            System.out.println("This launchpad is at full capacity!");
        }
    }

    public boolean removeSpacecraft(String name) {
        return this.spacecrafts.removeIf(spacecraft -> spacecraft.getName().equals(name));
    }

    public String getHeaviestSpacecraft() {
        Spacecraft spacecraft = this.spacecrafts.stream().max(Comparator.comparing(Spacecraft::getWeight)).get();
        return String.format("%s - %dkg.", spacecraft.getName(), spacecraft.getWeight());
    }

    public Spacecraft getSpacecraft(String name) {
        return this.spacecrafts.stream().filter(spacecraft -> spacecraft.getName().equals(name)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.spacecrafts.size();
    }

    public List<Spacecraft> getSpacecraftsByMissionType (String missionType) {

        List<Spacecraft> spacecraftsOnMission = new ArrayList<>();
        for (Spacecraft spacecraft : this.spacecrafts) {
            if (spacecraft.getMissionType().equals(missionType)) {
                spacecraftsOnMission.add(spacecraft);
            }
        }
        if (spacecraftsOnMission.isEmpty()) {
            System.out.println("There are no spacecrafts to respond this criteria.");
        }
        return spacecraftsOnMission;
    }
    public String getStatistics() {

        StringBuilder output = new StringBuilder();
        output.append(String.format("Spacecrafts launched from %s:", this.name));
        output.append(System.lineSeparator());
        int counter = 1;
        if (!this.spacecrafts.isEmpty()) {
            for (Spacecraft spacecraft : this.spacecrafts) {
                output.append(counter++ + ". ").append(spacecraft.getName());
                output.append(System.lineSeparator());
            }
        } else {
            output.append(System.lineSeparator());
            output.append("none");
        }
        return output.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
