package E01_Products_Shop.service.utilities;

import E01_Products_Shop.service.dtos.*;

public interface ExporterUtil {

    <E> void exportWithGson(Iterable <E> e, String fileName);
    <E> void exportWithJackson(Iterable <E> e, String fileName);
}
