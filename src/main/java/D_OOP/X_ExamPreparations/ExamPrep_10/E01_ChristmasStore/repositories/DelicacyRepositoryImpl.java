package D_OOP.X_ExamPreparations.ExamPrep_10.E01_ChristmasStore.repositories;

import D_OOP.X_ExamPreparations.ExamPrep_10.E01_ChristmasStore.entities.delicacies.interfaces.*;
import D_OOP.X_ExamPreparations.ExamPrep_10.E01_ChristmasStore.repositories.interfaces.*;

import java.util.*;

public class DelicacyRepositoryImpl implements DelicacyRepository<Delicacy> {

    private Collection<Delicacy> delicacies;

    public DelicacyRepositoryImpl() {
        this.delicacies = new ArrayList<>();
    }

    @Override
    public void add(Delicacy delicacy) {
        this.delicacies.add(delicacy);
    }

    @Override
    public Collection<Delicacy> getAll() {
        return Collections.unmodifiableCollection(this.delicacies);
    }

    @Override
    public Delicacy getByName(String name) {
        return this.delicacies.stream().filter(delicacy -> delicacy.getName().equals(name)).findFirst().orElse(null);
    }
}