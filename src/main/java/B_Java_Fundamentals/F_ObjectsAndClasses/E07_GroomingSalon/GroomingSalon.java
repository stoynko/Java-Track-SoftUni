package B_Java_Fundamentals.F_ObjectsAndClasses.E07_GroomingSalon;

import java.util.*;

public class GroomingSalon {

    private int capacity;
    private List<Pet> petsData = new ArrayList<>(capacity);

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
    }

    public void add(Pet pet) {
        if (this.petsData.size() < capacity) {
            petsData.add(pet);
        }
    }

    public boolean remove(String name) {
        for (Pet petName : this.petsData) {
            if (name.equals(petName.getName())) {
                this.petsData.remove(petName);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        for (Pet pet : this.petsData) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
            }
        }
        return null;
    }

    public int getCount() {
        return this.petsData.size();
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        output.append("The grooming salon has the following clients:").append(System.lineSeparator());
        for (Pet pet : this.petsData) {
            output.append(pet.getName()).append(" ").append(pet.getOwner());
            output.append(System.lineSeparator());
        }
        return output.toString();
    }
}
