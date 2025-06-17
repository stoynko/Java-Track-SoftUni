package Y_ExamPreparations.ExamPrep_09.E01_MagicGame.interfaces;

import D_Java_OOP.Y_ExamPreparations.ExamPrep_09.E01_MagicGame.common.*;
import D_Java_OOP.Y_ExamPreparations.ExamPrep_09.E01_MagicGame.models.magics.*;

import java.util.*;

public class MagicRepositoryImpl implements MagicRepository<Magic> {

    private Collection<Magic> data;

    public MagicRepositoryImpl() {
        this.data = new ArrayList<>();
    }

    @Override
    public void addMagic(Magic model) {
        if (model == null) {
            throw new NullPointerException(ExceptionMessages.INVALID_MAGIC_REPOSITORY);
        }
        this.data.add(model);
    }

    @Override
    public boolean removeMagic(Magic model) {
        return this.data.remove(model);
    }

    @Override
    public Magic findByName(String name) {
        return this.data.stream().filter(magic -> magic.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<Magic> getData() {
        return this.data;
    }
}
