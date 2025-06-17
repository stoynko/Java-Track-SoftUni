package Y_ExamPreparations.ExamPrep_08.E01_VehicleShop.models.tool;

import Y_ExamPreparations.ExamPrep_08.E01_VehicleShop.common.*;

public class ToolImpl implements Tool {

    public static final int POWER_LOSS = 5;

    private int power;

    public ToolImpl(int power) {
        setPower(power);
    }

    public void setPower(int power) {
        if (power < 0) {
            throw new IllegalArgumentException(ExceptionMessages.TOOL_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }

    @Override
    public int getPower() {
        return this.power;
    }

    @Override
    public void decreasesPower() {
        this.power -= POWER_LOSS;
        if (this.power < 0) {
            this.power = 0;
        }
    }

    @Override
    public boolean isUnfit() {
        return this.power == 0;
    }
}
