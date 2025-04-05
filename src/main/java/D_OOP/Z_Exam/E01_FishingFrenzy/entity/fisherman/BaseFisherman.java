package D_OOP.Z_Exam.E01_FishingFrenzy.entity.fisherman;

import D_OOP.Z_Exam.E01_FishingFrenzy.common.*;

public class BaseFisherman implements Fisherman {

    private String name;
    private int harvest;
    private int bait;

    public BaseFisherman(String name, int bait) {
        setName(name);
        this.harvest = 0;
        this.bait = bait;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessages.FISHERMAN_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHarvest() {
        return this.harvest;
    }

    @Override
    public int getBait() {
        return this.bait;
    }

    @Override
    public void fishing() {
        this.harvest += 1;
        this.bait -= 10;
        if (this.bait < 0) {
            this.bait = 0;
        }
    }
}
