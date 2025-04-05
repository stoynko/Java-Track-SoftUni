package C_Java_Advanced.Y_ExamPreparation.ExamPrep_08.E03_Halloween;

import java.util.*;

public class House {

    private int capacity;
    private List<Kid> data;

    public House(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addKid(Kid kid) {
        if (this.data.size() < capacity) {
            this.data.add(kid);
        }
    }

    public boolean removeKid(String name) {
        return this.data.removeIf(kid -> kid.getName().equals(name));
    }

    public Kid getKid(String street) {
        return this.data.stream().filter(kid -> kid.getStreet().equals(street)).findFirst().orElse(null);
    }

    public int getAllKids() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        output.append("Children who visited a house for candy:");
        this.data.forEach(kid -> {
            output.append(System.lineSeparator());
            output.append(String.format("%s from %s street", kid.getName(), kid.getStreet()));
        });
        return output.toString();
    }

}
