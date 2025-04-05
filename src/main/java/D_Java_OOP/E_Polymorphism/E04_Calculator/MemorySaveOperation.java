package D_Java_OOP.E_Polymorphism.E04_Calculator;

import java.util.*;

public class MemorySaveOperation implements Operation {

    Deque<Integer> memory;

    public MemorySaveOperation(Deque<Integer> memory) {
        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {
        memory.push(operand);
    }

    @Override
    public int getResult() {
        if (!this.memory.isEmpty()) {
            return memory.peek();
        }
        return 0;
    }

    @Override
    public boolean isCompleted() {
        return false;
    }
}
