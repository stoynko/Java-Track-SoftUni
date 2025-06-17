package G_Generics.E01_GenericBox;

import java.util.*;

public class Box<T> {

    private List<T> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        this.elements.add(element);
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
