package Y_ExamPreparations.ExamPrep_01.E02_MushroomKingdom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Field {

    private static final String NO_MORE_SPACE = "No more space in the field!";
    private static final String INVALID_FIELD_NAME = "Invalid field name!";
    private static final String INVALID_CAPACITY = "Invalid capacity!";
    private static final String MUSHROOM_EXIST = "This mushroom exists in the field!";
    private static final int ZERO_CAPACITY = 0;

    private String name;
    private int capacity;
    private final Collection<Mushroom> mushrooms;

    public Field(String name, int capacity) {
        this.setName(name);
        this.setCapacity(capacity);
        this.mushrooms = new ArrayList<>();
    }

    public void addMushroom(Mushroom mushroom) {
        if (mushrooms.size() >= this.getCapacity()) {
            throw new IllegalArgumentException(NO_MORE_SPACE);
        }
        boolean mushroomExist = this.mushrooms
                .stream()
                .anyMatch(c -> c.getName().equals(mushroom.getName()));

        if (mushroomExist) {
            throw new IllegalArgumentException(MUSHROOM_EXIST);
        }
        mushrooms.add(mushroom);
    }

    public boolean removeMushroom(String name) {
        Mushroom mushroom = this.mushrooms
                .stream()
                .filter(m -> m.getName()
                        .equals(name))
                .findFirst()
                .orElse(null);

        return this.mushrooms.remove(mushroom);
    }

    public String getMostPoisonousMushroom() {
        Mushroom mostPoisonous = mushrooms.stream().max(Comparator.comparing(Mushroom::getToxicity)).orElse(null);
        assert mostPoisonous != null;
        return mostPoisonous.getName();
    }

    public List<Mushroom> getInedibleMushrooms() {
        return mushrooms.stream().filter(m -> !m.isEdible()).collect(Collectors.toList());
    }

    public List<Mushroom> getMushroomsByFlavor(String flavor) {
        return mushrooms.stream().filter(m -> m.getFlavor().equals(flavor)).collect(Collectors.toList());
    }

    public int getCount() {
        return mushrooms.size();
    }

    public Mushroom getMushroom(String name) {
        return mushrooms.stream().filter(m -> m.getName().equals(name)).findFirst().orElse(null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(INVALID_FIELD_NAME);
        }
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity < ZERO_CAPACITY) {
            throw new IllegalArgumentException(INVALID_CAPACITY);
        }
        this.capacity = capacity;
    }
}
