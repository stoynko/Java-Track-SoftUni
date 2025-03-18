package C_Advanced.G_Generics.E08_CustomListSorter;

import java.util.*;

public class CustomList<T extends Comparable<T>> {

    private List<T> customList;

    public CustomList() {
        this.customList = new ArrayList<>();
    }

    public void add(T element) {
        this.customList.add(element);
    }

    public void remove (int index) {
        this.customList.remove(index);
    }

    public boolean contains(T element) {
        return this.customList.contains(element);
    }

    public void swap (int indexA, int indexB) {
        Collections.swap(this.customList, indexA, indexB);
    }

    public int countGreaterThan(T element) {
        int count = 0;
        for (T t : this.customList) {
            if (t.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    public T getMax () {
        return Collections.max(this.customList);
    }

    public T getMin () {
        return Collections.min(this.customList);
    }

    public void sort() {
        this.customList.sort((e1, e2) -> e1.compareTo(e2));
    }

    public void print() {
        for (T element : this.customList) {
            System.out.println(element);
        }
    }
}
