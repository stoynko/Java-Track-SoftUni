package E_Polymorphism.E04_Calculator;

import java.util.*;

public class DivisionOperation implements Operation {

    private List<Integer> operands;
    private int result;

    public DivisionOperation() {
        this.operands = new ArrayList<>();
    }

    @Override
    public void addOperand(int operand) {
        this.operands.add(operand);

        if (isCompleted()) {
            this.result = this.operands.get(0) / this.operands.get(1);
        }
    }

    @Override
    public int getResult() {
        return this.result;
    }

    @Override
    public boolean isCompleted() {
        return this.operands.size() == 2;
    }
}
