package D_OOP.Y_ExamPreparations.ExamPrep_02.E01_Climbers.core;

import D_OOP.Y_ExamPreparations.ExamPrep_02.E01_Climbers.common.*;
import D_OOP.Y_ExamPreparations.ExamPrep_02.E01_Climbers.models.climber.*;
import D_OOP.Y_ExamPreparations.ExamPrep_02.E01_Climbers.models.climbing.Climbing;
import D_OOP.Y_ExamPreparations.ExamPrep_02.E01_Climbers.models.climbing.ClimbingImpl;
import D_OOP.Y_ExamPreparations.ExamPrep_02.E01_Climbers.models.mountain.*;
import D_OOP.Y_ExamPreparations.ExamPrep_02.E01_Climbers.repositories.*;

import java.util.*;
import java.util.stream.*;

public class ControllerImpl implements Controller {

    private ClimberRepository climberRepository;
    private MountainRepository mountainRepository;
    private Climbing climbing;
    private int climbs;

    public ControllerImpl() {
        climberRepository = new ClimberRepository();
        mountainRepository = new MountainRepository();
        this.climbing = new ClimbingImpl();
        this.climbs = 0;
    }

    @Override
    public String addClimber(String type, String climberName) {
        Climber climber;
        switch (type) {
            case "WallClimber": climber = new WallClimber(climberName);
                break;
            case "RockClimber": climber = new RockClimber(climberName);
                break;
            default: throw new IllegalArgumentException(ExceptionMessages.CLIMBER_INVALID_TYPE);
        }
        climberRepository.add(climber);
        return String.format(ConstantMessages.CLIMBER_ADDED, type, climberName);
    }

    @Override
    public String addMountain(String mountainName, String... peaks) {

        Mountain mountain = new MountainImpl(mountainName);
        for (String peak : peaks) {
            mountain.getPeaksList().add(peak);
        }
        mountainRepository.add(mountain);
        return String.format(ConstantMessages.MOUNTAIN_ADDED, mountainName);
    }

    @Override
    public String removeClimber(String climberName) {

        Climber climber = climberRepository.byName(climberName);

        if (climber != null) {
            climberRepository.remove(climber);
        } else {
            throw new IllegalArgumentException(String.format(ExceptionMessages.CLIMBER_DOES_NOT_EXIST, climberName));
        }

        return String.format(String.format(ConstantMessages.CLIMBER_REMOVE, climberName));
    }

    @Override
    public String startClimbing(String mountainName) {

        if (climberRepository.getCollection().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.THERE_ARE_NO_CLIMBERS);
        }
        Mountain mountain = mountainRepository.byName(mountainName);
        Collection<Climber> climbersList = climberRepository.getCollection();
        climbing.conqueringPeaks(mountain, climbersList);
        climbersList = climbersList.stream().filter(Climber::canClimb).collect(Collectors.toList());
        int disqualifiedClimbers = climberRepository.getCollection().size() - climbersList.size();
        this.climbs++;
        return String.format(ConstantMessages.PEAK_CLIMBING, mountainName, disqualifiedClimbers);
    }

    @Override
    public String getStatistics() {
        int mountainsClimbed = mountainRepository.getCollection().size();
        StringBuilder output = new StringBuilder();
        output.append(String.format(ConstantMessages.FINAL_MOUNTAIN_COUNT, this.climbs)).append(System.lineSeparator());
        output.append(ConstantMessages.FINAL_CLIMBERS_STATISTICS).append(System.lineSeparator());
        for (Climber climber : climberRepository.getCollection()) {
            output.append(String.format(ConstantMessages.FINAL_CLIMBER_NAME, climber.getName())).append(System.lineSeparator());
            output.append(String.format(ConstantMessages.FINAL_CLIMBER_STRENGTH, climber.getStrength())).append(System.lineSeparator());
            output.append("Conquered peaks: ");
            if (!climber.getRoster().getPeaks().isEmpty()) {
                String climbedPeaks = String.join(ConstantMessages.FINAL_CLIMBER_FINDINGS_DELIMITER, climber.getRoster().getPeaks());
                output.append(String.format("%s", climbedPeaks)).append(System.lineSeparator());
            } else {
                output.append("None").append(System.lineSeparator());
            }
        }
        return output.toString().trim();
    }
}
