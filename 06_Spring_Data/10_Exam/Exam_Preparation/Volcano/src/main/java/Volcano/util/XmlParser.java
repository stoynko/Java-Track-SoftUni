package Volcano.util;


import jakarta.xml.bind.*;

public interface XmlParser {

    <T> T fromFile(String filePath, Class<T> tClass) throws JAXBException;
}
