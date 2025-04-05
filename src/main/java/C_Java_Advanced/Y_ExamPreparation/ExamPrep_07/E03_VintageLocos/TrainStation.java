package C_Java_Advanced.Y_ExamPreparation.ExamPrep_07.E03_VintageLocos;

import java.util.*;

public class TrainStation {

    private String name;
    private int capacity;
    private int railGauge;
    private List<Locomotive> locomotives;

    public TrainStation(String name, int capacity, int railGauge) {
        this.name = name;
        this.capacity = capacity;
        this.railGauge = railGauge;
        this.locomotives = new ArrayList<>();
    }

    public void addLocomotive(Locomotive locomotive) {

        if (this.locomotives.size() < this.capacity) {
            if (this.railGauge != locomotive.getGauge()) {
                System.out.printf("The rail gauge of this station does not match the locomotive gauge! Difference: %d mm.\n",
                                                                            Math.abs(this.railGauge - locomotive.getGauge()));
            } else {
                this.locomotives.add(locomotive);
            }
        } else {
            System.out.println("This train station is full!");
        }
    }

    public boolean removeLocomotive(String name) {
        return this.locomotives.removeIf(locomotive -> locomotive.getName().equals(name));
    }

    public String getFastestLocomotive() {
        if (!this.locomotives.isEmpty()) {
            Locomotive fastestLocomotive = this.locomotives.stream().max(Comparator.comparing(Locomotive::getMaxSpeed)).get();
            return String.format("%s is the fastest locomotive with a maximum speed of %d km/h.",
                                    fastestLocomotive.getName(), fastestLocomotive.getMaxSpeed());
        } else {
            return "There are no locomotives.";
        }
    }

    public Locomotive getLocomotive(String name) {
        return this.locomotives.stream().filter(locomotive -> locomotive.getName().equals(name)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.locomotives.size();
    }

    public String getOldestLocomotive() {
        if (!this.locomotives.isEmpty()) {
            Locomotive oldestLocomotive = this.locomotives.stream().min(Comparator.comparing(Locomotive::getBuildDate)).get();
            return String.format("%s", oldestLocomotive.getName());
        } else {
            return "There are no locomotives.";
        }
    }

    public String getStatistics() {

        if (!this.locomotives.isEmpty()) {
            StringBuilder output = new StringBuilder();
            output.append(String.format("Locomotives departed from %s:", this.name));
            int counter = 1;
            for (Locomotive locomotive : this.locomotives) {
                output.append(System.lineSeparator());
                output.append(counter++).append(". ").append(locomotive.getName());
            }
            return output.toString();
        } else {
            return String.format("There are no locomotives departing from %s station.", this.name);
        }
    }
}
