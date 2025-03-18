package D_OOP.G_ReflectionsAndAnnotations.E02_BlackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Main {

/*You are helping a buddy of yours who is still in the OOP Basics course - his name is John. He is rather slow and made a class with all private members.
Your tasks are to instantiate an object from his class (always with start value 0) and then invoke the different methods it has.
Your restriction is to not change anything in the class itself (consider it a black box). You can look at his class but don't touch anything!
The class itself is called BlackBoxInt. It is a wrapper for the int primitive. The methods it has are:

private void add(int addend) {
    this.innerValue += addend;
}

private void subtract(int subtrahend) {
    this.innerValue -= subtrahend;
}

private void multiply(int multiplier) {
    this.innerValue *= multiplier;
}

private void divide(int divider) {
    this.innerValue /= divider;
}

private void leftShift(int shifter) {
    this.innerValue <<= shifter;
}

private void rightShift(int shifter) {
    this.innerValue >>= shifter;
}

Input:
•	The input will consist of lines in the form: "{command name}_{value}"
Input will always be valid and in the format described, so there is no need to check it explicitly. You stop receiving input when you encounter the command "END".

Output:
Each command (except the "END" one) should print the current value of innerValue of the BlackBoxInt object you instantiated.
Don't cheat by overriding toString in the class - you must get the value from the private field. */

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Object blackbox = createObject(BlackBoxInt.class);

        while (!"END".equals(input)) {

            String command = input.split("_")[0];
            int value = Integer.parseInt(input.split("_")[1]);
            Method method = getMethod(blackbox, command);
            method.invoke(blackbox, value);
            print(blackbox);

            input = scanner.nextLine();
        }
    }

    private static Object createObject(Class<BlackBoxInt> blackBoxIntClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> blackBoxClass = BlackBoxInt.class;
        Constructor<?> blackBoxConstructor = blackBoxClass.getDeclaredConstructor();
        blackBoxConstructor.setAccessible(true);
        return blackBoxConstructor.newInstance();
    }

    private static Method getMethod(Object blackbox, String command) throws NoSuchMethodException {

        Method method = null;

        switch (command) {
            case "add" -> method = blackbox.getClass().getDeclaredMethod("add", int.class);
            case "subtract" -> method = blackbox.getClass().getDeclaredMethod("subtract", int.class);
            case "multiply" -> method = blackbox.getClass().getDeclaredMethod("multiply", int.class);
            case "divide" -> method = blackbox.getClass().getDeclaredMethod("divide", int.class);
            case "leftShift" -> method = blackbox.getClass().getDeclaredMethod("leftShift", int.class);
            case "rightShift" -> method = blackbox.getClass().getDeclaredMethod("rightShift", int.class);
        }

        method.setAccessible(true);
        return method;
    }

    public static void print (Object blackBox) throws NoSuchFieldException, IllegalAccessException {
        Class blackBoxClass = blackBox.getClass();
        Field value = blackBoxClass.getDeclaredField("innerValue");
        value.setAccessible(true);
        System.out.println(value.get(blackBox));
    }
}
