package D_Java_OOP.Z_Exam.E02_Aquarium;

import java.util.*;
import java.util.stream.Collectors;

public class Aquarium {

    private static final String NOT_COMPATIBLE_FISH = "This fish is not compatible with the water in this aquarium!";
    private static final String INVALID_AQUARIUM_NAME = "Invalid aquarium name!";
    private static final String FISH_EXIST = "This fish exists in the aquarium!";

    private String name;
    private String waterType;
    private Collection<Fish> fishes;

    public Aquarium(String name, String waterType) {
        this.setName(name);
        this.waterType = waterType;
        this.fishes = new ArrayList<>();
    }

    public void addFish(Fish fish) {
        if (!fish.getHabitat().equals(this.waterType)) {
            throw new IllegalArgumentException(NOT_COMPATIBLE_FISH);
        }
        boolean fishExist = this.fishes
                .stream()
                .anyMatch(c -> c.getName().equals(fish.getName()));

        if (fishExist) {
            throw new IllegalArgumentException(FISH_EXIST);
        }
        this.fishes.add(fish);
    }

    public boolean removeFish(String name) {
        Fish fish = this.fishes
                .stream()
                .filter(m -> m.getName()
                .equals(name))
                .findFirst()
                .orElse(null);

        return this.fishes.remove(fish);
    }

    public String getFastestFish() {
        Fish fastest = fishes.stream().max(Comparator.comparing(Fish::getSpeed)).orElse(null);
        assert fastest != null;
        return fastest.getName();
    }

    public String getEndangeredFishes() {
        List<Fish> endangeredFishes = fishes.stream().filter(Fish::isEndangered).toList();
        List<String> resultNames = endangeredFishes.stream().map(Fish::getName).toList();

        return String.join(", ", resultNames);
    }

    public List<Fish> getFishByHabitat(String habitat) {
        return fishes.stream().filter(m -> m.getHabitat().equals(habitat)).collect(Collectors.toList());
    }

    public int getCount() {
        return fishes.size();
    }

    public Fish getFish(String name) {
        return fishes.stream().filter(m -> m.getName().equals(name)).findFirst().orElse(null);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(INVALID_AQUARIUM_NAME);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
