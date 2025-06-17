package G_Generics.E04_GenericSwapMethodInteger;

import java.util.*;

public class Box<T> {

    private List<T> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public void swap(int indexA, int indexB) {

        T elementA = this.elements.get(indexA);
        T elementB = this.elements.get(indexB);
        this.elements.set(indexA, elementB);
        this.elements.set(indexB, elementA);
    }
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        for (T element : elements) {
            output.append(element.getClass().getName() + ": " + element).append(System.lineSeparator());
        }
        return output.toString();
    }
}
