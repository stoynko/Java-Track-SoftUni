package C_Inheritance.L04_StackOfStrings;

import java.util.*;

public class StackOfStrings extends ArrayDeque<String> {

    private List<String> data;

    public void push(String item) {
        this.data.add(item);
    }

    public String pop(){
        return this.data.remove(this.data.size() - 1);
    }

    public String peek() {
        return  this.data.get(this.data.size() - 1);
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }
}
