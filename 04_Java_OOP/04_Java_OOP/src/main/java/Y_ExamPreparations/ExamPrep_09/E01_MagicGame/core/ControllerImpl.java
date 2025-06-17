package Y_ExamPreparations.ExamPrep_09.E01_MagicGame.core;

import D_Java_OOP.Y_ExamPreparations.ExamPrep_09.E01_MagicGame.common.*;
import D_Java_OOP.Y_ExamPreparations.ExamPrep_09.E01_MagicGame.models.magicians.*;
import D_Java_OOP.Y_ExamPreparations.ExamPrep_09.E01_MagicGame.models.magics.*;
import D_Java_OOP.Y_ExamPreparations.ExamPrep_09.E01_MagicGame.models.region.*;
import D_Java_OOP.Y_ExamPreparations.ExamPrep_09.E01_MagicGame.interfaces.*;

import java.util.*;
import java.util.stream.*;

public class ControllerImpl implements Controller {

    private MagicRepository<Magic> magicRepository;
    private MagicianRepository<Magician> magicianRepository;
    private Region region;

    public ControllerImpl() {
        this.magicRepository = new MagicRepositoryImpl();
        this.magicianRepository = new MagicianRepositoryImpl();
        this.region = new RegionImpl();
    }

    @Override
    public String addMagic(String type, String name, int bulletsCount) {
        Magic magic;
        switch (type) {
            case "RedMagic": magic = new RedMagic(name, bulletsCount);
                break;
            case "BlackMagic": magic = new BlackMagic(name, bulletsCount);
                break;
            default: throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGIC_TYPE);
        }
        this.magicRepository.addMagic(magic);
        return String.format(OutputMessages.SUCCESSFULLY_ADDED_MAGIC, name);
    }

    @Override
    public String addMagician(String type, String username, int health, int protection, String magicName) {
        Magic magic = this.magicRepository.getData().stream().filter(m -> m.getName().equals(magicName)).findFirst().orElse(null);
        if (magic == null) {
            throw new NullPointerException(ExceptionMessages.MAGIC_CANNOT_BE_FOUND);
        }
        Magician magician;
        switch (type) {
            case "Wizard": magician = new Wizard(username, health, protection, magic);
                break;
            case "BlackWidow": magician = new BlackWidow(username, health, protection, magic);
                break;
            default: throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_TYPE);
        }
        this.magicianRepository.addMagician(magician);
        return String.format(OutputMessages.SUCCESSFULLY_ADDED_MAGICIAN, username);
    }

    @Override
    public String startGame() {
        List<Magician> aliveMagicians = this.magicianRepository.getData().stream().filter(Magician::isAlive).collect(Collectors.toList());
        return this.region.start(aliveMagicians);
    }

    @Override
    public String report() {
        StringBuilder output = new StringBuilder();
        Comparator<Magician> comparator = Comparator.comparingInt(Magician::getHealth)
                                                    .thenComparing(Magician::getProtection)
                                                    .thenComparing(Magician::getUsername)
                                                    .thenComparing(magician -> magician.getClass().getSimpleName());
        List<Magician> magicians = new ArrayList<>(this.magicianRepository.getData());
        magicians.sort(comparator);
        for (Magician magician : magicians) {
            output.append(String.format("%s: %s", magician.getClass().getSimpleName(), magician.getUsername())).append(System.lineSeparator());
            output.append(String.format("Health: %d", magician.getHealth())).append(System.lineSeparator());
            output.append(String.format("Protection: %d", magician.getProtection())).append(System.lineSeparator());
            output.append(String.format("Magic: %s", magician.getMagic().getName())).append(System.lineSeparator());
        }
        return output.toString().trim();
    }
}
