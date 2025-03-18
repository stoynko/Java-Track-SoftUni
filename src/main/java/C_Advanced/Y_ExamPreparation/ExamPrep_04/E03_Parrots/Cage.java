package C_Advanced.Y_ExamPreparation.ExamPrep_04.E03_Parrots;

import java.util.*;

public class Cage {

    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public String getName() {
        return this.name;
    }

    public void add(Parrot parrot) {
        if (this.data.size() < this.capacity) {
            this.data.add(parrot);
        }
    }

    public boolean remove(String name) {

        for (int index = 0; index < this.data.size(); index++) {
            if (this.data.get(index).getName().equals(name)) {
                this.data.remove(index);
                return true;
            }
        }
        return false;
    }

    public Parrot sellParrot(String name) {

        Parrot parrotToSell = null;

        for (int index = 0; index < data.size(); index++) {
            if (data.get(index).getName().equals(name)) {
                parrotToSell = data.get(index);
                parrotToSell.setAvailable(false);
                break;
            }
        }

        return parrotToSell;
    }

    public List<Parrot> sellParrotBySpecies(String species) {

        List<Parrot> parrotsToSell = new ArrayList<>();
        for (int index = 0; index < data.size(); index++) {
            if (data.get(index).getSpecies().equals(species)) {
                Parrot currentParrot = data.get(index);
                currentParrot.setAvailable(false);
                parrotsToSell.add(currentParrot);
            }
        }
        return parrotsToSell;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {

        StringBuilder output = new StringBuilder();

        output.append(String.format("Parrots available at %s:", this.name));
        output.append(System.lineSeparator());
        data.stream().filter(parrot -> parrot.isAvailable()).forEach(parrot -> output.append(parrot).append(System.lineSeparator()));
        return output.toString();
    }
}
