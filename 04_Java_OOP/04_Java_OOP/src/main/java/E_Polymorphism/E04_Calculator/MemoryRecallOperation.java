package E_Polymorphism.E04_Calculator;

import java.util.*;

public class MemoryRecallOperation implements Operation{

    private Deque<Integer> memory;

    public MemoryRecallOperation(Deque<Integer> memory) {
        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {
        // Unnecessary
    }

    @Override
    public int getResult() {
        return memory.pop();
    }

    @Override
    public boolean isCompleted() {
        return true;
    }
}
