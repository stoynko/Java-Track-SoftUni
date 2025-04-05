package C_Java_Advanced.G_Generics.L02_GenericArrayCreator;

import java.lang.reflect.*;

public class ArrayCreator {

    public static <T> T[] create(int length, T item) {

        T[] array = (T[]) Array.newInstance(item.getClass(), length);
        for (int i = 0; i < length; i++) {
            array[i] = item;
        }
        return array;
    }

    public static <T> T[] create(Class<T> clasz, int length, T item) {
        T[] array = (T[]) Array.newInstance(clasz, length);
        for (int i = 0; i < length; i++) {
            array[i] = item;
        }
        return array;
    }
}
