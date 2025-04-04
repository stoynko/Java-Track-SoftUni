package D_OOP.Y_ExamPreparations.ExamPrep_06.E01_HarpoonDiving.repositories;

import D_OOP.Y_ExamPreparations.ExamPrep_06.E01_HarpoonDiving.models.diver.*;

import java.util.*;

public class DiverRepository implements Repository<Diver> {

    private Collection<Diver> divers;

    public DiverRepository() {
        this.divers = new ArrayList<>();
    }

    @Override
    public void add(Diver entity) {
        this.divers.add(entity);
    }

    @Override
    public boolean remove(Diver entity) {
        return this.divers.remove(entity);
    }

    @Override
    public Diver byName(String name) {
        return this.divers.stream().filter(diver -> diver.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<Diver> getCollection() {
        return Collections.unmodifiableCollection(this.divers);
    }
}
