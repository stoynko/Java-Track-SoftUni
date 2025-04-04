package D_OOP.Y_ExamPreparations.ExamPrep_06.E01_HarpoonDiving.core;

import D_OOP.Y_ExamPreparations.ExamPrep_06.E01_HarpoonDiving.common.*;
import D_OOP.Y_ExamPreparations.ExamPrep_06.E01_HarpoonDiving.models.diver.*;
import D_OOP.Y_ExamPreparations.ExamPrep_06.E01_HarpoonDiving.models.divingSite.*;
import D_OOP.Y_ExamPreparations.ExamPrep_06.E01_HarpoonDiving.repositories.*;

import java.util.*;
import java.util.stream.*;

public class ControllerImpl implements Controller {

    private DiverRepository diverRepository;
    private DivingSiteRepository divingSiteRepository;
    private int dives;

    public ControllerImpl() {
        this.diverRepository = new DiverRepository();
        this.divingSiteRepository = new DivingSiteRepository();
        this.dives = 0;
    }

    @Override
    public String addDiver(String kind, String diverName) {

        Diver diver;

        switch (kind) {
            case "OpenWaterDiver":
                diver = new OpenWaterDiver(diverName);
                break;
            case "DeepWaterDiver":
                diver = new DeepWaterDiver(diverName);
                break;
            case "WreckDiver":
                diver = new WreckDiver(diverName);
                break;
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessages.DIVER_DOES_NOT_EXIST, kind));
        }
        this.diverRepository.add(diver);
        return String.format(ConstantMessages.DIVER_ADDED, kind, diverName);
    }

    @Override
    public String addDivingSite(String siteName, String... seaCreatures) {
        DivingSite divingSite = new DivingSiteImpl(siteName);
        for (String seaCreature : seaCreatures) {
            divingSite.getSeaCreatures().add(seaCreature);
        }
        this.divingSiteRepository.add(divingSite);
        return String.format(ConstantMessages.DIVING_SITE_ADDED, siteName);
    }

    @Override
    public String removeDiver(String diverName) {
        Diver diver = this.diverRepository.getCollection().stream().filter(d -> d.getName().equals(diverName)).findAny().orElse(null);
        if (diver != null) {
            this.diverRepository.remove(diver);
        } else {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DIVER_DOES_NOT_EXIST, diverName));
        }
        return String.format(ConstantMessages.DIVER_REMOVE, diverName);
    }

    @Override
    public String startDiving(String siteName) {
        DivingSite divingSite = divingSiteRepository.getCollection().stream().filter(site -> site.getName().equals(siteName)).findFirst().orElse(null);
        List<Diver> diverList = this.diverRepository.getCollection().stream().filter(diver -> diver.getOxygen() > 30).collect(Collectors.toCollection(ArrayList::new));

        if (diverList.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.SITE_DIVERS_DOES_NOT_EXISTS);
        }
        Iterator<String> seaCatchIterator = divingSite.getSeaCreatures().iterator();
        for (Diver diver : diverList) {
            while (diver.canDive() && seaCatchIterator.hasNext()) {
                String seaCatch = seaCatchIterator.next();
                diver.shoot();
                diver.getSeaCatch().getSeaCreatures().add(seaCatch);
                seaCatchIterator.remove();
            }
        }
        List<Diver> removedDivers = diverList.stream().filter(diver -> diver.getOxygen() == 0).collect(Collectors.toList());
        dives++;
        return String.format(ConstantMessages.SITE_DIVING, siteName, removedDivers.size());
    }

    @Override
    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        output.append(String.format(ConstantMessages.FINAL_DIVING_SITES, dives)).append(System.lineSeparator());
        output.append(ConstantMessages.FINAL_DIVERS_STATISTICS).append(System.lineSeparator());
        for (Diver diver : this.diverRepository.getCollection()) {
            output.append(String.format(ConstantMessages.FINAL_DIVER_NAME, diver.getName())).append(System.lineSeparator());
            ;
            output.append(String.format(ConstantMessages.FINAL_DIVER_OXYGEN, diver.getOxygen())).append(System.lineSeparator());
            String seaCatch = String.join(ConstantMessages.FINAL_DIVER_CATCH_DELIMITER, diver.getSeaCatch().getSeaCreatures());
            if (seaCatch.isBlank()) {
                seaCatch = "None";
            }
            output.append(String.format(ConstantMessages.FINAL_DIVER_CATCH, seaCatch)).append(System.lineSeparator());
        }

        return output.toString();
    }
}
