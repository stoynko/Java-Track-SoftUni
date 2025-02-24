package D_OOP.C_Inheritance.L03_RandomArrayList;

import java.util.*;

public class RandomArrayList<T> extends ArrayList<T> {

    public T getRandomElement() {
        int index = new Random().nextInt(super.size());
        return super.remove(index);
    }
}
