package G_ReflectionsAndAnnotations.L03_HighQualityMistakes;

import java.lang.reflect.*;
import java.util.*;

public class Main {

/*You are already an expert on High-Quality Code, so you know what kind of access modifiers must be set for members of the class.
The time for revenge has come. Now you have to check the code produced by your "Beautiful and Smart" trainers in class Reflection.
Check all fields and methods access modifiers. Sort each category of members alphabetically. Print on the console all mistakes in the format:
    •	For Fields: "{fieldName} must be private!"
    •	For Getters: "{methodName} have to be public!"
    •	For Setters: "{methodName} have to be private!" */

    public static void main(String[] args) {

        Class reflectionClass = Reflection.class;

        Field[] fields = reflectionClass.getDeclaredFields();
        Arrays.sort(fields, Comparator.comparing(Field::getName));
        Arrays.stream(fields).filter(f -> !Modifier.isPrivate(f.getModifiers()))
                             .forEach(f -> System.out.printf("%s must be private!\n", f.getName()));

        Arrays.stream(reflectionClass.getDeclaredMethods()).sorted(Comparator.comparing(Method::getName))
                                                           .filter(m -> m.getName().startsWith("get"))
                                                           .filter(m -> !Modifier.isPublic(m.getModifiers()))
                                                           .forEach(m -> System.out.printf("%s have to be public!\n", m.getName()));

        Arrays.stream(reflectionClass.getDeclaredMethods()).sorted(Comparator.comparing(Method::getName))
                                                           .filter(m -> m.getName().startsWith("set"))
                                                           .filter(m -> !Modifier.isPrivate(m.getModifiers()))
                                                           .forEach(m -> System.out.printf("%s have to be private!\n", m.getName()));

    }
}
