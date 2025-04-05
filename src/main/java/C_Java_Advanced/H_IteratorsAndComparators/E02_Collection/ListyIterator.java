package C_Java_Advanced.H_IteratorsAndComparators.E02_Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {

    private List<String> list;
    private int index;

    public ListyIterator(String... elements) {

        this.list = new ArrayList<>(List.of(elements));
        this.index = 0;
    }

    public boolean hasNext() {
        return this.index < list.size() - 1;
    }

    public boolean move() {

        if (hasNext()) {
            this.index++;
            return true;
        }
        return false;
    }

    public void print() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        }
        System.out.println(list.get(index));
    }

    public void printAll() {
        System.out.println(String.join(" ", list));
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {

            private int internalIndex;

            @Override
            public boolean hasNext() {
                return internalIndex < list.size() - 1;
            }

            @Override
            public String next() {
                return list.get(internalIndex++);

            }
        };
    }
}
