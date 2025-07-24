package E01_Products_Shop.service.utilities;

import java.io.*;

public interface ExportUtility {

    <E>void exportCollectionWithJackson(Iterable<E> e, String fileName);
    <E>void exportWithJackson(E e, String fileName);
    <E>void exportCollectionWithGson(Iterable<E> e, String fileName);
    <E>void exportWithGson(E e, String fileName);
    File createFile(String fileName);
}
