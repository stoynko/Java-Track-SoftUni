package D_Java_OOP.Y_ExamPreparations.ExamPrep_09.E01_MagicGame.models.region;

import D_Java_OOP.Y_ExamPreparations.ExamPrep_09.E01_MagicGame.models.magicians.*;

import java.util.*;
import java.util.stream.*;

public class RegionImpl implements Region {

    @Override
    public String start(Collection<Magician> magicians) {
        List<Magician> wizards = magicians.stream().filter(magician -> magician.getClass().getSimpleName().equals("Wizard")).collect(Collectors.toList());
        List<Magician> blackWidows = magicians.stream().filter(magician -> magician.getClass().getSimpleName().equals("BlackWidow")).collect(Collectors.toList());
        while (wizards.stream().anyMatch(Magician::isAlive) && blackWidows.stream().anyMatch(Magician::isAlive)) {
            for (Magician wizard : wizards) {
                if (!wizard.isAlive()) {
                    continue;
                }
                for (Magician widow : blackWidows) {
                    if (!widow.isAlive()) {
                        continue;
                    }
                    widow.takeDamage(wizard.getMagic().fire());
                }
            }

            for (Magician widow : blackWidows) {
                if (!widow.isAlive()) {
                    continue;
                }
                for (Magician wizard : wizards) {
                    if (!wizard.isAlive()) {
                        continue;
                    }
                    wizard.takeDamage(widow.getMagic().fire());
                    }
                }
            }

        if (wizards.stream().anyMatch(Magician::isAlive)) {
            return "Wizards win!";
        } else {
            return "Black widows win!";
        }
    }
}
