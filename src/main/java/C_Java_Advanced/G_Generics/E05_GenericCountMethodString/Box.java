package C_Java_Advanced.G_Generics.E05_GenericCountMethodString;

import java.util.*;

public class Box<T> {

    public List<T> getElements() {
        return elements;
    }

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

    public <T extends Comparable<T>> int compareElements (List<T> list, T element){
        int countOfElements = 0;

        for (T t : list) {
            if (t.compareTo(element) > 0) {
                countOfElements++;
            }
        }

        return countOfElements;
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
