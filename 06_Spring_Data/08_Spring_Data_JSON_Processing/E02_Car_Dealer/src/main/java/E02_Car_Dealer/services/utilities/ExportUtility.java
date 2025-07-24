package E02_Car_Dealer.services.utilities;

import java.io.*;

public interface ExportUtility {

    <E>void exportCollectionWithJackson(Iterable<E> e, String fileName);
    <E>void exportWithJackson(E e, String fileName);
    <E>void exportCollectionWithGson(Iterable<E> e, String fileName);
    <E>void exportWithGson(E e, String fileName);
    File createFile(String fileName);
}
