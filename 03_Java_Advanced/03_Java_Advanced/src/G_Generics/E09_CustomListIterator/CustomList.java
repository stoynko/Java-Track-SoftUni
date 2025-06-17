package G_Generics.E09_CustomListIterator;

import java.util.*;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {

    private List<T> customList;

    public CustomList() {
        this.customList = new ArrayList<>();
    }

    public void add(T element) {
        this.customList.add(element);
    }

    public void remove(int index) {
        this.customList.remove(index);
    }

    public boolean contains(T element) {
        return this.customList.contains(element);
    }

    public void swap(int indexA, int indexB) {
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

    public T getMax() {
        return Collections.max(this.customList);
    }

    public T getMin() {
        return Collections.min(this.customList);
    }

    public void sort() {
        this.customList.sort(Comparable::compareTo);
    }

    public void print() {
        for (T element : this.customList) {
            System.out.println(element);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomListIterator();
    }

    private class CustomListIterator implements Iterator<T> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < customList.size();
        }

        @Override
        public T next() {
            return customList.get(index++);
        }
    }
}