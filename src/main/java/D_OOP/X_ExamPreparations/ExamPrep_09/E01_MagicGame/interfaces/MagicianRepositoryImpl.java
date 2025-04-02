package D_OOP.X_ExamPreparations.ExamPrep_09.E01_MagicGame.interfaces;

import D_OOP.X_ExamPreparations.ExamPrep_09.E01_MagicGame.common.*;
import D_OOP.X_ExamPreparations.ExamPrep_09.E01_MagicGame.models.magicians.*;

import java.util.*;

public class MagicianRepositoryImpl implements MagicianRepository<Magician> {

    private Collection<Magician> data;

    public MagicianRepositoryImpl() {
        this.data = new ArrayList<>();
    }

    @Override
    public void addMagician(Magician model) {
        if (model == null) {
            throw new NullPointerException(ExceptionMessages.INVALID_MAGICIAN_REPOSITORY);
        }
        this.data.add(model);
    }

    @Override
    public boolean removeMagician(Magician model) {
        return this.data.remove(model);
    }

    @Override
    public Magician findByUsername(String name) {
        return this.data.stream().filter(magician -> magician.getUsername().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<Magician> getData() {
        return this.data;
    }
}
