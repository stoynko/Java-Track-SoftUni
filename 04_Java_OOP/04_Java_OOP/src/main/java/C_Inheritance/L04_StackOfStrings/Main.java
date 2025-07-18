package C_Inheritance.L04_StackOfStrings;

public class Main {

/*Create a class StackOfStrings that can store only strings and has the following functionality:
    •	Private field: data: ArrayList<String>
    •	Public method: push(String item): void
    •	Public method: pop(): String
    •	Public method: peek(): String
    •	Public method: isEmpty(): boolean */

    public static void main(String[] args) {
        StackOfStrings sos = new StackOfStrings();
        sos.push("one");
        sos.push("two");
        sos.push("three");

        System.out.println(sos.isEmpty());
        System.out.println(sos.peek());
        System.out.println(sos.pop());
        System.out.println(sos.pop());
        System.out.println(sos.pop());
    }
}
