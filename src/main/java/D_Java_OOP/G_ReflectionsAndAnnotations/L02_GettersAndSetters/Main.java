package D_Java_OOP.G_ReflectionsAndAnnotations.L02_GettersAndSetters;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class reflectionClass = Reflection.class;
        List<Method> getMethods = Arrays.stream(reflectionClass.getDeclaredMethods())
                                        .filter(m -> m.getName().contains("get"))
                                        .sorted(Comparator.comparing(Method::getName))
                                        .collect(Collectors.toList());
        List<Method> setMethods = Arrays.stream(reflectionClass.getDeclaredMethods())
                                        .filter(m -> m.getName().contains("set"))
                                        .sorted(Comparator.comparing(Method::getName))
                                        .collect(Collectors.toList());

        for (Method getMethod : getMethods) {
            System.out.printf("%s will return class %s\n", getMethod.getName(), getMethod.getReturnType().getTypeName());
        }

        for (Method setMethod : setMethods) {
            System.out.printf("%s and will set field of class %s\n", setMethod.getName(), setMethod.getParameterTypes()[0].getSimpleName());
        }
    }
}
