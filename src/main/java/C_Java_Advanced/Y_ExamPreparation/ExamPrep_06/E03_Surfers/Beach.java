package C_Java_Advanced.Y_ExamPreparation.ExamPrep_06.E03_Surfers;


import java.util.*;
import java.util.stream.*;

public class Beach {

    private String name;
    private int surfboardsForRent;
    private List<Surfer> surfers;

    public Beach(String name, int surfboardsForRent) {
        this.name = name;
        this.surfboardsForRent = surfboardsForRent;
        this.surfers = new ArrayList<>();
    }

    public String addSurfer(Surfer surfer) {

        if (surfer.hasSurfboard()) {
            this.surfers.add(surfer);
            return String.format("Surfer %s added.", surfer.getName());
        } else if (surfer.getMoney() < 50) {
            return String.format("%s has not enough money to rent a surfboard.", surfer.getName());
        } else if (surfer.getMoney() >= 50) {
            if (this.surfboardsForRent > 0) {
                this.surfboardsForRent--;
                int surfersMoney = surfer.getMoney();
                surfer.setMoney(surfersMoney - 50);
                this.surfers.add(surfer);
            } else {
                return "There are no free surfboards.";
            }
        }
        return String.format("Surfer %s added.", surfer.getName());
    }

    public boolean removeSurfer(String name) {

        for (Surfer surfer : this.surfers) {
            if (surfer.getName().equals(name)) {
                surfers.remove(surfer);
                return true;
            }
        }
        return false;
    }

    public String getMostExperiencedSurfer() {

        if (this.surfers.isEmpty()) {
            return "There are no surfers.";
        }
        Surfer mostExperienced = null;
        int mostExperience = 0;

        for (Surfer surfer : this.surfers) {
            if (surfer.getExperience() > mostExperience) {
                mostExperienced = surfer;
            }
        }
        return String.format("%s is most experienced surfer with %d years experience.", mostExperienced.getName(), mostExperienced.getExperience());
    }

    public Surfer getSurfer(String name) {

        for (Surfer surfer : this.surfers) {
            if (surfer.getName().equals(name)) {
                return surfer;
            }
        }
        return null;
    }

    public int getCount() {
        return this.surfers.size();
    }

    public String getSurfersWithPersonalSurfboards() {

        if (!this.surfers.isEmpty()) {
            String surfersWithBoards = this.surfers.stream().filter(Surfer::hasSurfboard).map(Surfer::getName).collect(Collectors.joining(", "));
            return String.format("Surfers who have their own surfboards: %s", surfersWithBoards);
        } else {
            return "There are no surfers.";
        }
    }

    public String getReport() {

        if (this.surfers.isEmpty()) {
            return String.format("There are no surfers on %s beach.", this.name);
        }

        StringBuilder output = new StringBuilder();

        output.append(String.format("Beach %s was visited by the following surfers:", this.name));
        output.append(System.lineSeparator());
        Iterator<Surfer> iterator = this.surfers.iterator();
        int counter = 0;

        while (iterator.hasNext()) {
            counter++;
            Surfer surfer = iterator.next();
            if (surfer.getExperience() != 0) {
                output.append(String.format("%d. %s with %d years experience.", counter, surfer.getName(), surfer.getExperience()));
            } else {
                output.append(String.format("%d. %s with no experience.", counter, surfer.getName()));
            }
            if (iterator.hasNext()) {
                output.append(System.lineSeparator());
            }
        }

        return output.toString();
    }
}
