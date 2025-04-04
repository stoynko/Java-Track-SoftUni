package D_OOP.Y_ExamPreparations.ExamPrep_02.E01_Climbers.repositories;

import D_OOP.Y_ExamPreparations.ExamPrep_02.E01_Climbers.models.mountain.Mountain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MountainRepository implements Repository<Mountain> {

    private List<Mountain> mountains;

    public MountainRepository() {
        this.mountains = new ArrayList<>();
    }

    @Override
    public void add(Mountain entity) {
        this.mountains.add(entity);
    }

    @Override
    public boolean remove(Mountain entity) {
        return this.mountains.remove(entity);
    }

    @Override
    public Mountain byName(String name) {
        return this.mountains.stream().filter(mountain -> mountain.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection getCollection() {
        return Collections.unmodifiableCollection(this.mountains);
    }
}
