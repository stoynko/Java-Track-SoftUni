package D_Java_OOP.Y_ExamPreparations.ExamPrep_09.E01_MagicGame.models.magics;

import D_Java_OOP.Y_ExamPreparations.ExamPrep_09.E01_MagicGame.common.*;

public class MagicImpl implements Magic {

    public static final int DEFAULT_BULLETS_FIRED = 1;

    private String name;
    private int bulletsCount;

    public MagicImpl(String name, int bulletsCount) {
        setName(name);
        setBulletsCount(bulletsCount);
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new NullPointerException(ExceptionMessages.INVALID_MAGIC_NAME);
        }
        this.name = name;
    }

    public void setBulletsCount(int bulletsCount) {
        if (bulletsCount < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGIC_BULLETS_COUNT);
        }
        this.bulletsCount = bulletsCount;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getBulletsCount() {
        return this.bulletsCount;
    }

    @Override
    public int fire() {
        if (this.bulletsCount >= DEFAULT_BULLETS_FIRED) {
            this.bulletsCount -= DEFAULT_BULLETS_FIRED;
            return DEFAULT_BULLETS_FIRED;
        } else {
            return 0;
        }
    }
}
