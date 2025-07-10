package E01_Products_Shop.service.utilities;

public interface ExporterUtil {

    <E> void exportWithGson(Iterable <E> e, String fileName);
    <E> void exportWithJackson(Iterable <E> e, String fileName);;
}
