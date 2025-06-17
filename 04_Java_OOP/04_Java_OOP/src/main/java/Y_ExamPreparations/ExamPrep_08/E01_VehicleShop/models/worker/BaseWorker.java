package Y_ExamPreparations.ExamPrep_08.E01_VehicleShop.models.worker;

import Y_ExamPreparations.ExamPrep_08.E01_VehicleShop.common.*;
import Y_ExamPreparations.ExamPrep_08.E01_VehicleShop.models.tool.*;

import java.util.*;

public class BaseWorker implements Worker {

    public static final int INITIAL_STRENGTH_LOSS = 10;

    private String name;
    private int strength;
    private Collection<Tool> tools;

    public BaseWorker(String name, int strength) {
        setName(name);
        setStrength(strength);
        this.tools = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessages.WORKER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setStrength(int strength) {
        if (strength < 0) {
            throw new IllegalArgumentException(ExceptionMessages.WORKER_STRENGTH_LESS_THAN_ZERO);
        }
        this.strength = strength;
    }

    @Override
    public void working() {
        this.strength -= INITIAL_STRENGTH_LOSS;
        if (this.strength < 0) {
            this.strength = 0;
        }
    }

    @Override
    public void addTool(Tool tool) {
        this.tools.add(tool);
    }

    @Override
    public boolean canWork() {
        return this.strength > 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getStrength() {
        return this.strength;
    }

    @Override
    public Collection<Tool> getTools() {
        return this.tools;
    }
}
