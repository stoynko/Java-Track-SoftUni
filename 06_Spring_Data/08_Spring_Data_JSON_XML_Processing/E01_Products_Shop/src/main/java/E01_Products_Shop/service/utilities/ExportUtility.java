package E01_Products_Shop.service.utilities;

import java.io.*;

public interface ExportUtility {

    <E>void exportJSONCollectionWithJackson(Iterable<E> e, String fileName);
    <E>void exportJSONWithJackson(E data, String fileName);
    <E>void exportJSONCollectionWithGson(Iterable<E> e, String fileName);
    <E>void exportJSONWithGson(E data, String fileName);
    <E>void exportXMLCollection(Iterable<E> data, String fileName);
    <E>void exportXML(E data, String fileName);
    File createFile(String fileName);
}
