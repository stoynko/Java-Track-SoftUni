package D_OOP.G_ReflectionsAndAnnotations.L01_Reflection;

import java.lang.reflect.InvocationTargetException;

public class Main {

/*Import "Reflection.java" to your "src" folder in your project. Try to use reflection and print some information about this class.
Print everything on a new line:
    •	This class type
    •	Super class type
    •	All interfaces that are implemented by this class
    •	Instantiate object using reflection and print it too */

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class reflectionClass = Reflection.class;
        System.out.println(reflectionClass.getSimpleName());
        Class superClass = reflectionClass.getSuperclass();
        System.out.println(superClass);
        Class[] myClassInterfaces = reflectionClass.getInterfaces();

        for (Class myClassMethod : myClassInterfaces) {
            System.out.println(myClassMethod);
        }

        Object reflectionObject = reflectionClass.getDeclaredConstructor().newInstance();
        System.out.println(reflectionObject);
    }
}
