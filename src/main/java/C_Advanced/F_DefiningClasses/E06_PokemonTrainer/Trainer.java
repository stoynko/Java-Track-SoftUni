package C_Advanced.F_DefiningClasses.E06_PokemonTrainer;

import java.util.*;

public class Trainer {

    public static final int BADGES_INITIAL_VALUE = 0;

    private String name;
    private int badgesCount = BADGES_INITIAL_VALUE;

    public Trainer(String name, int badgesCount) {
        this.name = name;
        this.badgesCount = badgesCount;
    }

    public String getName() {
        return name;
    }

    public int getBadgesCount() {
        return badgesCount;
    }

    public void setBadgesCount(int badgesCount) {
        this.badgesCount = badgesCount;
    }

    @Override
    public String toString() {
        return name.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainer trainer = (Trainer) o;
        return Objects.equals(name, trainer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
