package Y_ExamPreparations.ExamPrep_09.E01_MagicGame.models.region;

import Y_ExamPreparations.ExamPrep_09.E01_MagicGame.models.magicians.Magician;

import java.util.Collection;

public interface Region {
    String start(Collection<Magician> magicians);
}
