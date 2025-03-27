package D_OOP.X_ExamPreparations.ExamPrep_02.E01_Climbers.repositories;

import D_OOP.X_ExamPreparations.ExamPrep_02.E01_Climbers.models.climber.Climber;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ClimberRepository implements Repository<Climber> {

    private List<Climber> climbers;

    public ClimberRepository() {
        this.climbers = new ArrayList<>();
    }

    @Override
    public void add(Climber entity) {
        this.climbers.add(entity);
    }

    @Override
    public boolean remove(Climber entity) {
        return this.climbers.remove(entity);
    }

    @Override
    public Climber byName(String name) {
        return this.climbers.stream().filter(climber -> climber.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<Climber> getCollection() {
        return Collections.unmodifiableCollection(this.climbers);
    }






}
