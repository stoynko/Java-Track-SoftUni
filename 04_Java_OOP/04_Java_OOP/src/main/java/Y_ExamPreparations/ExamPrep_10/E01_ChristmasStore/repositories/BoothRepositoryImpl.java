package Y_ExamPreparations.ExamPrep_10.E01_ChristmasStore.repositories;

import D_Java_OOP.Y_ExamPreparations.ExamPrep_10.E01_ChristmasStore.entities.booths.interfaces.*;
import D_Java_OOP.Y_ExamPreparations.ExamPrep_10.E01_ChristmasStore.repositories.interfaces.*;

import java.util.*;

public class BoothRepositoryImpl implements BoothRepository<Booth> {

    private Collection<Booth> booths;

    public BoothRepositoryImpl() {
        this.booths = new ArrayList<>();
    }

    @Override
    public void add(Booth booth) {
        this.booths.add(booth);
    }

    @Override
    public Collection<Booth> getAll() {
        return Collections.unmodifiableCollection(this.booths);
    }

    @Override
    public Booth getByNumber(int number) {
        return this.booths.stream().filter(booth -> booth.getBoothNumber() == number).findFirst().orElse(null);
    }
}
