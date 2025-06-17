package H_IteratorsAndComparators.E03_StackIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomStack implements Iterable<Integer> {

    private List<Integer> data;

    public CustomStack() {
        this.data = new ArrayList<>();
    }

    public void push(int element) {
        this.data.add(element);
    }

    public void pop() {
        if (data.isEmpty()) {
            System.out.println("No elements");
        } else {
            data.remove(data.get(data.size() - 1));
        }
    }

    @Override
    public Iterator<Integer> iterator() {

        return new Iterator<Integer>() {

            int index = data.size() - 1;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public Integer next() {
                return data.get(index--);
            }
        };
    }
}
